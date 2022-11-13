package system_patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AuthorityMapper {


    private final Connection conn;

    private PreparedStatement selectUser;

    public AuthorityMapper(Connection conn) {
        this.conn = conn;
        try {
            this.selectUser = conn.prepareStatement("select id, permission from authority where id = ?");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<Authority> findById(long id) {
        Authority authority;
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
//                return Optional.of(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
                authority = new Authority(rs.getInt(1), rs.getString(2));
//                identityMap.put(id, user);
                return Optional.of(authority);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void insert (Authority authority) {
        try {
            conn.setAutoCommit(false);
            selectUser = conn.prepareStatement(
                    "INSERT INTO authority (id, permission) VALUES (?, ?)");
            selectUser.setInt(1, authority.getId());
            selectUser.setString(2, authority.getPermission());
            selectUser.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
