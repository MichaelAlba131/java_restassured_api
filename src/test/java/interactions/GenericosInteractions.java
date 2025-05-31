package interactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class GenericosInteractions {

    private RequestSpecification request;
    private Response response;

    public void initRequest() {
        request = RestAssured.given();
    }

    public void addHeaders(Map<String, String> headers) {
        if (request == null) {
            initRequest();
        }
        headers.forEach(request::header);
    }

    public void setBody(Map<String, String> body) {
        if (request == null) {
            initRequest();
        }
        request.body(body);
    }

    public void setBody(String jsonBody) {
        if (request == null) {
            initRequest();
        }
        request.body(jsonBody);
    }

    public Response sendRequest(String method, String endpoint) {
        if (request == null) {
            initRequest();
        }
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

    public Response sendRequestWithQueryParams(String method, String url, Map<String, String> queryParams) {
        if (request == null) {
            initRequest();
        }
        switch(method.toUpperCase()) {
            case "GET":
                return request.queryParams(queryParams).get(url);
            case "POST":
                return request.queryParams(queryParams).post(url);
            default:
                throw new IllegalArgumentException("Método não suportado: " + method);
        }
    }

    public void assertItemFieldValue(Response response, String chaveBusca, String valorBusca, String campoValidar, String valorEsperado) throws JsonProcessingException, JsonProcessingException {
        String json = response.getBody().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> itens = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
        Map<String, Object> itemEncontrado = itens.stream()
                .filter(m -> valorBusca.equals(
                        m.getOrDefault(chaveBusca, "").toString()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Nenhum item encontrado com " + chaveBusca + "=" + valorBusca));
        Object valor = itemEncontrado.get(campoValidar);
        org.junit.Assert.assertEquals(valorEsperado, valor != null ? valor.toString() : null);
    }

}