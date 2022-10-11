package geekbrains.domain;

import lombok.*;

import java.util.Map;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class HttpRequest {

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;

//    public HttpRequest(String method, String path, Map<String, String> headers, String body) {
//    }

    public static class Builder {
        private String method;
        private String url;
        private Map<String, String> headers;
        private String body;
        
        public Builder withMethod(String method){
            this.method = method;
            return this;
        }
        public Builder withUrl(String url){
            this.url = url;
            return this;
        }
        public Builder withHeaders(String headers, String value){
            this.headers.put(headers, value);
            return this;
        }
        public Builder withBody(String body){
            this.body = body;
            return this;
        }
        public HttpRequest build(){
            return new HttpRequest(method, url, headers, body);
        }
    }

}
