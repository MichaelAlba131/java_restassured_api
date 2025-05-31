@produtossad
Feature: Makeup API - teasdf

  @getssad
  Scenario: Retrieve all produc
    Given the base URL is "http://makeup-api.herokuapp.com"
    And I set the request headers:
      | Content-Type | application/json |
    When I send a "GET" request to "/api/v1/products.json"
    Then the response status code should be 200
    Then the item with "id" equal to "1" should have the field "name" with value "Pure Anada Natural Mascara"
    When pauso cinco segundos

  @gets @filtros
  Scenario: Successfully retrie
    Given the base URL is "http://makeup-api.herokuapp.com"
    And I set the request query parameters:
      | brand        | covergirl |
      | product_type | lipstick  |
    And I set the request headers:
      | Content-Type | application/json |
    When I send a "GET" request to "/api/v1/products.json"
    Then the response status code should be 200
    When pauso cinco segundos

  #Caso seja uma requisição POST USAR:
  # When I send a "POST" request to "/api/v1/..."
  #And I set the request body with fields:
  #  | name | Michael Alba |
  #  | job  | QA Engineer  |