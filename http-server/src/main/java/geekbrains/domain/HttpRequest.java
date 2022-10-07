package geekbrains.domain;

import lombok.*;

import java.util.Map;
@Getter
@Setter
@RequiredArgsConstructor
public class HttpRequest {

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;
    public static class Builder {
        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }
        public Builder withMethod(String method){
            this.httpRequest.method = method;
            return this;
        }
        public Builder withPath(String path){
            this.httpRequest.method = path;
            return this;
        }
        public Builder withHeaders(String headers){
            this.httpRequest.method = headers;
            return this;
        }
        public Builder withBody(String body){
            this.httpRequest.method = body;
            return this;
        }
        public HttpRequest build(){
            return this.httpRequest;
        }
    }

}
