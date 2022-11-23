package interview.lesson4.hw4;

import geekbrains.config.ConfigConnection;
import geekbrains.config.ConfigConnectionFromFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ConfigConnection config = new ConfigConnectionFromFile("./../../server.properties");
        Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        HandlerRequest handlerRequest = new HandlerRequest();
        handlerRequest.requestError(connection);
        handlerRequest.requestPause(connection);
        handlerRequest.requestStat(connection);
        handlerRequest.getTotal(connection);
        handlerRequest.requestStatTimeStart(connection);
    }

}
