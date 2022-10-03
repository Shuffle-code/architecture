package geekbrains;

import ru.geekbrains.domain.HttpResponse;

public class ResponseSerializerImpl implements ResponseSerializer {

    @Override
    public String serialize(HttpResponse httpResponse) {
        String protocol = httpResponse.getProtocol();
        String statusCode = String.valueOf(httpResponse.getStatusCode());
        String status = httpResponse.getStatus();
        String type = httpResponse.getType();
        String httpResponseString = protocol + " " + statusCode + " " + status + "\n" + type + "\n"  + "\n";
        return httpResponseString;
    }
}
