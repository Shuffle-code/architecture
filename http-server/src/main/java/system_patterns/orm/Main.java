package system_patterns.orm;

import geekbrains.config.ConfigConnection;
import geekbrains.config.ConfigConnectionFromFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        ConfigConnection config = new ConfigConnectionFromFile("./../../server.properties");
        Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        AuthorityMapper authorityMapper = new AuthorityMapper(connection);
//        UserMapper userMapper = new UserMapper(connection);
//        Optional<User> byId = userMapper.findById(1);
//        System.out.println(byId.get().getUsername());
//        userMapper.insert(new User(7, "Ivan", "12345"));
//        userMapper.delete(new User(1, "kk", "k"));
//        userMapper.update(new User(2, "kk", "k"));
//        connection.close();
        UserRepository userRepository = new UserRepository(connection);
        userRepository.insert(new User(10, "Ivan", "12345"));
        userRepository.beginTransaction();
        authorityMapper.insert(new Authority(5, "product.write"));
    }
}

