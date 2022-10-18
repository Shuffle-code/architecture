package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpRequest;
import geekbrains.domain.HttpResponse;
import geekbrains.domain.Status;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;

@Handler(order = 1)
public class PostMethodHandler extends MethodHandler {

    public PostMethodHandler(MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        super("POST", next, socketService, responseSerializer, config);
    }
    private final PutMethodHandler putMethodHandler = null;

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.builder()
                .protocol("HTTP/1.1")
                .statusCode(200)
                .status(Status.OK.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .body("<h1>POST method handled</h1>")
                .build();
    }
//    PostMethodHandler postMethodHandler = new PostMethodHandler("POST", putMethodHandler.putMethodHandler, socketService, responseSerializer, config);


}
