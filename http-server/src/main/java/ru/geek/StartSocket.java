package ru.geek;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartSocket {
    public static InitializeSocket initializeSocket = new InitializeSocket();
    public static HandleRequest handleRequest = new HandleRequest();
    public void startApp() throws IOException {
        ServerSocket serverSocket = initializeSocket.startedSocket();
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");
            new Thread(() -> {handleRequest.handleRequest(socket);
            }).start();
        }
    }
}
