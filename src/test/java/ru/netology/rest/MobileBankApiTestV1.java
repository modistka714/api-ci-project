package ru.netology.rest;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

import static io.restassured.module.jsonschema.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        RestAssured.given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}