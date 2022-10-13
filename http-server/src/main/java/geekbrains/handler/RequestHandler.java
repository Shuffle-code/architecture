package geekbrains.handler;

import geekbrains.config.Config;
import geekbrains.domain.HttpResponse;
import geekbrains.domain.Status;
import geekbrains.logger.ConsoleLogger;
import geekbrains.logger.Logger;
import geekbrains.service.*;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {
    private static final Logger logger = new ConsoleLogger();
    private static final RequestParser requestParse = new RequestParserImpl();
    private static final ResponseSerializer responseSerializer = new ResponseSerializerImpl();
//    private final SocketService socketService;
    private final SocketService socketService;
    private final Config config;
    private static HttpResponse response = new HttpResponse();

    private RequestHandler(SocketService socketService, Config config, HttpResponse response) {
        this.socketService = socketService;
        this.config = config;
        this.response = response;
    }
    public static RequestHandler createRequestHandler(SocketService socketService, Config config){
        return new RequestHandler(socketService, config, response);
    }

    @Override
    public void run() {
        List<String> request = socketService.readRequest();
        String pathRequest = requestParse.parse(request).getPath();
        Path path = Paths.get(config.getWWW(), pathRequest);
        if (!Files.exists(path)) {
            socketService.writeResponse(responseSerializer.serialize(response.responseNotFound())
            );
            System.out.println(responseSerializer.serialize(response.responseNotFound()));
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(sb::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

            socketService.writeResponse(responseSerializer.serialize(response.builder()
                            .protocol("HTTP/1.1")
                            .statusCode(200)
                            .status(Status.OK.getTitle())
                            .type("Content-Type: text/html; charset=utf-8")
                            .body(sb.toString())
                            .build())
                );

        System.out.println(sb);

        logger.info("Client disconnected!");
    }
}
