package geekbrains.domain;

import lombok.*;

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

    // изменить на заголовок и тело body и Header

//    HttpResponse responseNotFound = new HttpResponseBuilder()
//                .protocol("HTTP/1.1")
//                .statusCode(404)
//                .status(Status.NOT_FOUND.getTitle())
//                .type("Content-Type: text/html; charset=utf-8")
//                .build();
    public HttpResponse responseNotFound(){
        return new HttpResponse().builder()
                .protocol("HTTP/1.1")
                .statusCode(404)
                .status(Status.NOT_FOUND.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .build();
    }

    public HttpResponse responseOk(){
        return new HttpResponse().builder()
                .protocol("HTTP/1.1")
                .statusCode(200)
                .status(Status.OK.getTitle())
                .type("Content-Type: text/html; charset=utf-8")
                .build();
    }
}
