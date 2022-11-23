package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpRequest;
import geekbrains.domain.HttpResponse;
import geekbrains.service.ResponseSerializer;
import geekbrains.service.SocketService;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

public abstract class MethodHandler {
    private final MethodHandler next;
    private final String method;
    protected final SocketService socketService;

    protected final ResponseSerializer responseSerializer;
    final Config config;

    protected MethodHandler(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        this.next = next;
        this.method = method;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
        this.config = config;
    }
    public void handle(HttpRequest request) throws IOException {
        HttpResponse response;
        System.out.println(request.getMethod());
        if (method.equals(request.getMethod())){
            response = handleInternal(request);
            }else if (next != null){
            next.handle(request);
            return;
        }else {
            response = new HttpResponse().responseNotAllowed();
        }
        String rawResponse = responseSerializer.serialize(response);
        socketService.writeResponse(rawResponse);

    }
    protected abstract HttpResponse handleInternal(HttpRequest request);

}
