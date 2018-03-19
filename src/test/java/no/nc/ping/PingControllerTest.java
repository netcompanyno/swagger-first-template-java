package no.nc.ping;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PingControllerTest {

    @Autowired
    WebApplicationContext context;

    @Before
    public void setUp() {
        RestAssuredMockMvc.mockMvc(MockMvcBuilders.webAppContextSetup(context).build());
    }

    @Test
    public void ping_with_empty_message_should_return_empty_message_and_timestamp() {
        RestAssuredMockMvc
                .given()
                    .log().all()
                .when()
                    .get("/ping")
                .then()
                    .assertThat()
                        .body("message", nullValue())
                        .body("dateAndTime", notNullValue());
    }

    @Test
    public void ping_with_message_should_return_message() {
        String message = "Hello";

        final MockMvcResponse response = RestAssuredMockMvc
                .given()
                    .param("message", message)
                    .log().all()
                .when()
                    .get("/ping");
        response
                .then()
                    .statusCode(HttpStatus.OK.value())
                    .assertThat()
                        .body("message", equalTo(message))
                        .body("dateAndTime", notNullValue());
    }
}
