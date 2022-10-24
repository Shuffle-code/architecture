package geekbrains.service;

import geekbrains.domain.HttpRequest;

import java.util.List;

public class RequestParserImpl implements RequestParser {

//    @Override
    public HttpRequest parse(List<String> rawRequest) {
//        HttpRequest httpRequest = new HttpRequest();
//        String[] parts = rawRequest.get(0).split(" ");
//        httpRequest.setPath(parts[1]);
        return new HttpRequest.Builder()
                .withUrl(rawRequest.get(0).split(" ")[1])
                .withMethod(rawRequest.get(0).split(" ")[0])
                .build();
//        return httpRequest;
    }
}
