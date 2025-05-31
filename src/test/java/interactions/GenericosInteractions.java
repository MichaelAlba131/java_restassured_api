package interactions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class GenericosInteractions {

    private RequestSpecification request;
    private Response response;

    public void initRequest() {
        request = RestAssured.given();
    }

    public void addHeaders(Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }
    }

    public void setBody(Map<String, String> body) {
        request.body(body);
    }

    public void setBody(String jsonBody) {
        request.body(jsonBody);
    }

    public Response sendRequest(String method, String endpoint) {
        switch (method.toUpperCase()) {
            case "POST":
                response = request.post(endpoint);
                break;
            case "PUT":
                response = request.put(endpoint);
                break;
            case "GET":
                response = request.get(endpoint);
                break;
            case "DELETE":
                response = request.delete(endpoint);
                break;
            case "PATCH":
                response = request.patch(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
        return response;
    }

    protected Response sendRequestWithQueryParams(String method, String url, Map<String, String> queryParams) {
        switch(method.toUpperCase()) {
            case "GET":
                return request.queryParams(queryParams).get(url);
            case "POST":
                return request.queryParams(queryParams).post(url);
            default:
                throw new IllegalArgumentException("Método não suportado: " + method);
        }
    }
}