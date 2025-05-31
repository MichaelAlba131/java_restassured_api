package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import interactions.GenericosInteractions;
import interactions.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GenericosSteps extends GenericosInteractions {

    private final ScenarioContext contexto;
    private final GenericosInteractions interactions;

    public GenericosSteps() {
        this.contexto = new ScenarioContext();
        this.interactions = new GenericosInteractions();
    }

    @Given("the base URL is {string}")
    public void the_base_url_is(String url) {
        contexto.setBaseUrl(url);
    }

    @Given("I set the request headers:")
    public void i_set_the_request_headers(DataTable dataTable) {
        initRequest();
        Map<String, String> headers = dataTable.asMap(String.class, String.class);
        addHeaders(headers);
    }

    @And("I set the request query parameters:")
    public void i_set_the_request_query_parameters(DataTable dataTable) {
        Map<String, String> params = new HashMap<>(dataTable.asMap(String.class, String.class));
        contexto.setQueryParams(params);
    }

    @And("I set the request body with fields:")
    public void i_set_the_request_body_with_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> bodyMap = dataTable.asMap(String.class, String.class);
        setBody(bodyMap);
    }

    @When("I send a {string} request to {string}")
    public void i_send_a_request_to(String method, String endpoint) {
        String url = contexto.getBaseUrl() + endpoint;
        Response response;
        if (contexto.getQueryParams() == null || contexto.getQueryParams().isEmpty()) {
            response = interactions.sendRequest(method, url);
        } else {
            response = interactions.sendRequestWithQueryParams(method, url, contexto.getQueryParams());
        }
        contexto.setResponse(response);
        System.out.println(response.prettyPrint());

    }


    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        assertEquals(statusCode.intValue(), contexto.getResponse().statusCode());
    }

    @Then("the item with {string} equal to {string} should have the field {string} with value {string}")
    public void validateItemDynamically(String chaveBusca, String valorBusca, String campoValidar, String valorEsperado) throws JsonProcessingException {
        assertItemFieldValue(contexto.getResponse(), chaveBusca, valorBusca, campoValidar, valorEsperado);
    }
}