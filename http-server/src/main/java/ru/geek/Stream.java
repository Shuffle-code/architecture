package ru.geek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Stream {
    public BufferedReader createInputStream(Socket socket) throws IOException {
        return new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
    }
    public PrintWriter createOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream());
    }

}
