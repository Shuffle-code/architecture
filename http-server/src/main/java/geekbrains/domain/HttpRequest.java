package geekbrains.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@RequiredArgsConstructor
public class HttpRequest {

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;
}
