package br.com.fiap.hackaton.authorization.integration.test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.hackaton.authorization.integration.config.TestConfigs;
import br.com.fiap.hackaton.authorization.integration.containers.AbstractIntegrationTest;
import br.com.fiap.hackaton.authorization.mock.AccountCredentialsDtoMock;
import br.com.fiap.hackaton.authorization.mock.CreateCredentialsDtoMock;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthIntegrationTest extends AbstractIntegrationTest {
    
    private static RequestSpecification specification;

    @Test
    @Order(0)
    void createUser() {
        specification = new RequestSpecBuilder()
                .addHeader(TestConfigs.HEADER_PARAM_ORIGIN, TestConfigs.ORIGIN_FRONT)
                .setBasePath("/auth/create")
                .setPort(TestConfigs.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        final var response = given()
                .spec(specification)
                .contentType(TestConfigs.CONTENT_TYPE_JSON)
                .body(CreateCredentialsDtoMock.mock())
                .when().post().then()
                .statusCode(200)
                .extract().body().asString();

        assertNotNull(response);
    }
    
    @Test
    @Order(1)
    void signinUser() {
        specification = new RequestSpecBuilder()
                .addHeader(TestConfigs.HEADER_PARAM_ORIGIN, TestConfigs.ORIGIN_FRONT)
                .setBasePath("/auth/signin")
                .setPort(TestConfigs.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        final var response = given()
                .spec(specification)
                .contentType(TestConfigs.CONTENT_TYPE_JSON)
                .body(AccountCredentialsDtoMock.mock())
                .when().post().then()
                .statusCode(200)
                .extract().body().asString();

        assertNotNull(response);
    }

}
