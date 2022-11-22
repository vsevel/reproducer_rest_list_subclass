package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    private static final Logger log = LoggerFactory.getLogger(GreetingResourceTest.class);

    @Test
    public void testHelloEndpoint() {
        
        String expected = "[{\"type\":\".ChildA\",\"shapes\":[{\"type\":\".Circle\",\"attChildA\":\"circle\"}],\"attChildA\":\"valA\"}]";
        log.info("expected = {}", expected);
        
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is(expected));
    }
}