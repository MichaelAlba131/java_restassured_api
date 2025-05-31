@produtos
Feature: Makeup API - Products

  @get
  Scenario: Retrieve all products and validate a specific item by ID
    Given the base URL is "http://makeup-api.herokuapp.com"
    And I set the request headers:
      | Content-Type | application/json |
    When I send a "GET" request to "/api/v1/products.json"
    Then the response status code should be 200
    Then the item with "id" equal to "1" should have the field "name" with value "Pure Anada Natural Mascara"

  @get @filtro
  Scenario: Successfully retrieve lipsticks of brand Covergirl
    Given the base URL is "http://makeup-api.herokuapp.com"
    And I set the request query parameters:
      | brand        | covergirl |
      | product_type | lipstick  |
    And I set the request headers:
      | Content-Type | application/json |
    When I send a "GET" request to "/api/v1/products.json"
    Then the response status code should be 200


  #Caso seja uma requisição POST USAR:
  # When I send a "POST" request to "/api/v1/..."
  #And I set the request body with fields:
  #  | name | Michael Alba |
  #  | job  | QA Engineer  |