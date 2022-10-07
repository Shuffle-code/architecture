package geekbrains;

import geekbrains.config.Config;
import geekbrains.domain.HttpResponse;
import geekbrains.domain.Status;
import geekbrains.logger.ConsoleLogger;
import geekbrains.logger.Logger;
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
    private final SocketService socketService;
    private final Config config;

    private RequestHandler(SocketService socketService, Config config) {
        this.socketService = socketService;
        this.config = config;
    }
    public static RequestHandler createRequestHandler(SocketService socketService, Config config){
        return new RequestHandler(socketService,config);
    }
    HttpResponse response = new HttpResponse();

    @Override
    public void run() {
        List<String> request = socketService.readRequest();
        String pathRequest = requestParse.parse(request).getPath();
        Path path = Paths.get(config.getWWW(), pathRequest);
        if (!Files.exists(path)) {
            socketService.writeResponse(responseSerializer.serialize(response.responseNotFound()),
                   new StringReader("<h1>Файл не найден!</h1>\n")
            );
            return;
        }
        try {
            socketService.writeResponse(responseSerializer.serialize(response.responseOk()),
                    Files.newBufferedReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Client disconnected!");
    }
}
