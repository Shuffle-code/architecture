package system_patterns.orm;

import geekbrains.current.DatabaseConnection;
import geekbrains.current.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection conn;

    private PreparedStatement selectUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {

        this.conn = conn;
        try {
            this.selectUser = conn.prepareStatement("select id, username, password from account_user where id = ?");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
//                return Optional.of(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }
    public void update (User user) {
        try {
            conn.setAutoCommit(false);
            selectUser = conn.prepareStatement(
                    "UPDATE users SET username = ?, password = ? WHERE id = ?");
            selectUser.setString(1, user.getUsername());
            selectUser.setString(2, user.getPassword());
            selectUser.setLong(3, user.getId());
            selectUser.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert (User user) {
        try {
            conn.setAutoCommit(false);
            selectUser = conn.prepareStatement(
                    "INSERT INTO users (id, username, password) VALUES (?, ?, ?)");
            selectUser.setLong(1, user.getId());
            selectUser.setString(2, user.getUsername());
            selectUser.setString(3, user.getPassword());
            selectUser.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(User user) {
        int id = user.getId();
        try {
            conn.setAutoCommit(false);
            selectUser = conn.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            selectUser.setLong(1, id);
            selectUser.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

//1. Для всех объектов, которые непосредственно хранятся в БД, реализовать шаблон Data Mapper.
//2. Проконтролировать получение объектов из БД, используя шаблон Identity Map.
