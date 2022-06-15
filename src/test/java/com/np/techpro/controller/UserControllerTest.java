package com.np.techpro.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static io.restassured.RestAssured.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    //This annotation will get the currently running port
    @LocalServerPort
    private int port;

    @Test
    public void testUser() {

        get("http://localhost:"+port+"/api/v1/users/list")
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstName", Matchers.equalTo("nimish"));
    }

}
