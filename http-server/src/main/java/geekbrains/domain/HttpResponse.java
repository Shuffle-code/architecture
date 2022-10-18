package geekbrains.domain;

import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
@Builder
@AllArgsConstructor
public class HttpResponse {

    private int statusCode;
    private String status;
    private String protocol;
    private String type;
    private String body;

    // изменить на заголовок и тело body и Header


//    HttpResponse responseNotFound = new HttpResponseBuilder()
//                .protocol("HTTP/1.1")
//                .statusCode(404)
//                .status(Status.NOT_FOUND.getTitle())
//                .type("Content-Type: text/html; charset=utf-8")
//                .build();
    public HttpResponse responseNotFound(){
        return HttpResponse.builder()
                .protocol("HTTP/1.1")
                .statusCode(404)
                .status(Status.NOT_FOUND.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .body("<h1>Файл не найден!</h1>\n")
                .build();
    }

    public HttpResponse responseNotAllowed(){
        return HttpResponse.builder()
                .protocol("HTTP/1.1")
                .statusCode(500)
                .status(Status.METHOD_NOT_ALLOWED.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .body("<h1>Метод не поддерживается!</h1>\n")
                .build();
    }
}
