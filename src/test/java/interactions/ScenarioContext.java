package interactions;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Response response;
    private String baseUrl = "";
    private Map<String, String> queryParams = new HashMap<>();

    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }
    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

}
