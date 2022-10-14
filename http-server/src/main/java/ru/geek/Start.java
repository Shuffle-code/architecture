package ru.geek;

import java.io.IOException;
import java.net.ServerSocket;

public class Start {
    public static StartSocket startSocket = new StartSocket();
    public static InitializeSocket initializeSocket = new InitializeSocket();

    public static void main(String[] args) throws IOException {
        startSocket.startApp();
//        initializeSocket.startedSocket();
    }
}
