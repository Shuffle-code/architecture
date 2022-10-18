package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpRequest;
import geekbrains.domain.HttpResponse;
import geekbrains.logger.ConsoleLogger;
import geekbrains.logger.Logger;
import geekbrains.service.*;

import java.io.IOException;
import java.util.List;

public class RequestHandler implements Runnable {
    private static final Logger logger = new ConsoleLogger();
    private static final RequestParser requestParse = new RequestParserImpl();
    private final SocketService socketService;
    private final Config config;
    private static HttpResponse response = new HttpResponse();
    private final MethodHandler methodHandler;

    private RequestHandler(SocketService socketService, Config config, HttpResponse httpResponse, MethodHandler methodHandler) {
        this.socketService = socketService;
        this.config = config;
        this.methodHandler = methodHandler;
    }
    public static RequestHandler createRequestHandler(SocketService socketService, Config config, MethodHandler methodHandler){
        return new RequestHandler(socketService, config, response, methodHandler);
    }

    @Override
    public void run() {
        List<String> request = socketService.readRequest();
        HttpRequest httpRequest = requestParse.parse(request);
        try {
            methodHandler.handle(httpRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        logger.info("Client disconnected!");
    }
}
