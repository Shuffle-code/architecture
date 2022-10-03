package ru.geek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandleRequest {
    private static String WWW = "C:\\Users\\79130\\IdeaProjects\\architecture\\architecture\\www";
    private static Stream stream = new Stream();
    public void handleRequest(Socket socket) {
        try (BufferedReader input = stream.createInputStream(socket);
             PrintWriter output = stream.createOutputStream(socket)
        ) {
            while (!input.ready()) ;

            String firstLine = input.readLine();
            String[] parts = firstLine.split(" ");
            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path path = Paths.get(WWW, parts[1]);
            if (!Files.exists(path)) {
                output.println("HTTP/1.1 404 NOT_FOUND");
                output.println("Content-Type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>Файл не найден!</h1>");
                output.flush();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();

            try {
                Files.newBufferedReader(path).transferTo(output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Client disconnected!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
