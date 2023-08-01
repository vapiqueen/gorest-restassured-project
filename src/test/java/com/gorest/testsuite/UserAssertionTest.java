package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest extends TestBase {
    static ValidatableResponse response;


    public UserAssertionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }
    //1.Verify the if the total record is 20
    @Test
    public void test001() {
        response.body("size", equalTo(20));
    }
    //2. Verify the if the name of id = 4040691 is equal to ”Chaturbhuj Reddy”
    @Test
    public void test002(){
        response.body("find{it.id ==  4040691}.name", equalTo("Chaturbhuj Reddy"));
    }
    //3. Check the single ‘Name’ in the Array list (Bhima Chaturvedi)
    @Test
    public void test003(){
        response.body("name",hasItem("Bhima Chaturvedi"));
    }
    //4. Check the multiple ‘Names’ in the ArrayList ("Bhima Chaturvedi","Tushar Ahluwalia","Dhanesh Arora PhD")
    @Test
    public void test004(){
        response.body("name",hasItems("Bhima Chaturvedi","Tushar Ahluwalia","Dhanesh Arora PhD"));
    }
    //5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005(){
        response.body("find{it.id == 4040681}.email",equalTo("jahnu_abbott@dooley.example"));
    }
    //6. Verify the status is “active” of user name is “Dharani Kocchar”
    @Test
    public void test006(){
        response.body("find{it.name == 'Dharani Kocchar'}.status",equalTo("active"));
    }
//7. Verify the Gender = male of user name is “Uma Bhattacharya”
    @Test
    public void test007(){
        response.body("find{it.name == 'Uma Bhattacharya'}.gender",equalTo("male"));
    }
}
