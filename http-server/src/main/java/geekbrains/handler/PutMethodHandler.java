package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpRequest;
import geekbrains.domain.HttpResponse;
import geekbrains.domain.Status;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;

@Handler(order = 2)
public class PutMethodHandler extends MethodHandler {

    public PutMethodHandler( MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        super("PUT", next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.builder()
                .protocol("HTTP/1.1")
                .statusCode(200)
                .status(Status.OK.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .body("<h1>PUT method handled</h1>")
                .build();
    }
//    PutMethodHandler putMethodHandler = new PutMethodHandler("POST", null, socketService, responseSerializer, config);
}