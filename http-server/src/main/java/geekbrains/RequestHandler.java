package geekbrains;

import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.domain.Status;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {

    private static final String WWW = "C:\\Users\\79130\\IdeaProjects\\geek-architecture-123\\www";
    private static final Logger logger = new ConsoleLogger();
    private static final RequestParser requestParse = new RequestParserImpl();
    private static final ResponseSerializer responseSerializer = new ResponseSerializerImpl();

    private final SocketService socketService;

    public RequestHandler(SocketService socketService) {
        this.socketService = socketService;
    }

    HttpResponse response = new HttpResponse();
    public HttpResponse responseOk(){
        response.setProtocol("HTTP/1.1");
        response.setStatusCode(200);
        response.setStatus( Status.OK.getTitle());
        response.setType("Content-Type: text/html; charset=utf-8");
        HttpResponse responseOk = response;
        return responseOk;
    }
    public HttpResponse responseNotFound(){
        response.setProtocol("HTTP/1.1");
        response.setStatusCode(404);
        response.setStatus( Status.NOT_FOUND.getTitle());
        response.setType("Content-Type: text/html; charset=utf-8");
        HttpResponse responseOk = response;
        return responseOk;
    }

    @Override
    public void run() {

        List<String> request = socketService.readRequest();
//        String[] parts = request.get(0).split(" ");
        String pathRequest = requestParse.parse(request).getPath();
        Path path = Paths.get(WWW, pathRequest);
//        Path path = Paths.get(WWW, parts[1]);
        if (!Files.exists(path)) {
            socketService.writeResponse(responseSerializer.serialize(responseOk()),
                   new StringReader("<h1>Файл не найден!</h1>\n")
            );
            return;
        }

        try {
//            socketService.writeResponse("HTTP/1.1 200 OK\n" +
//                            "Content-Type: text/html; charset=utf-8\n" +
//                            "\n",
//                    Files.newBufferedReader(path));
            System.out.println(responseSerializer.serialize(responseOk()));
            System.out.println("HTTP/1.1 200 OK\n" +
                          "Content-Type: text/html; charset=utf-8\n" +
                            "\n");
            socketService.writeResponse(responseSerializer.serialize(responseOk()),
                    Files.newBufferedReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client disconnected!");
    }
}
