package geekbrains;

import geekbrains.config.Config;
import geekbrains.config.ConfigFactory;
import geekbrains.logger.ConsoleLogger;
import geekbrains.logger.Logger;
import geekbrains.service.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static final Logger logger = new ConsoleLogger();


    public static void main(String[] args) {
        Config config = ConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("port: " + config.getPort());
            logger.info("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                new Thread(RequestHandler.createRequestHandler(SocketServiceFactory.createSocketService(socket), config)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
