package ru.geek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class InitializeSocket {
    public ServerSocket startedSocket () throws IOException {
        System.out.println("Server started!");
        return new ServerSocket(8080);
    }
}
