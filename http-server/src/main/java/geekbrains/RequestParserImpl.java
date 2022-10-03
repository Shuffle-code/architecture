package geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.List;

public class RequestParserImpl implements RequestParser {
  HttpRequest httpRequest = new HttpRequest();
    @Override
    public HttpRequest parse(List<String> rawRequest) {
        String[] parts = rawRequest.get(0).split(" ");
        httpRequest.setPath(parts[1]);
        return httpRequest;
    }
}
