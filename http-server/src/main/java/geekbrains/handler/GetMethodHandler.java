package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpRequest;
import geekbrains.domain.HttpResponse;
import geekbrains.domain.Status;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Handler(order = 0)
public class GetMethodHandler extends MethodHandler {

    public GetMethodHandler(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        super(method, next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        Path path = Paths.get(config.getWWW(), request.getPath());

        if (!Files.exists(path)) {
            return HttpResponse.builder()
                    .protocol("HTTP/1.1")
                    .statusCode(404)
                    .status(Status.NOT_FOUND.getTitle())
                    .type("Content-Type: text/html; charset=utf-8")
                    .body("<h1>Файл не найден!</h1>")
                    .build();
        }

        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(sb::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return HttpResponse.builder()
                .protocol("HTTP/1.1")
                .statusCode(200)
                .status(Status.OK.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .body(sb.toString())
                .build();
    }
}
