package geekbrains.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class HttpResponse {

    private int statusCode;
    private String status;
    private String protocol;
    private String type;




    // TODO
}
