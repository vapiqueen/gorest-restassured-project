package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest extends TestBase {

    static ValidatableResponse response;


    public UserExtractionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        List<Integer> Ids = response.extract().path("Ids");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  id are : " + Ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the all Names
    @Test
    public void test002() {
        List<String> listOfAllName = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("listOfAllName : " + listOfAllName);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String Name = response.extract().path("[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th object  is : " + Name);
        System.out.println("------------------End of Test-------------------------");
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<HashMap<String, ?>> names = response.extract().path("findAll{it.status =='inactive'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("names of all object whose status = inactive: " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<HashMap<String, ?>> gender = response.extract().path("findAll{it.status =='active'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the gender of all the object whose status = active: " + gender);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<HashMap<String, ?>> gender = response.extract().path("findAll{it.gender=='female'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the names of the object whose gender = female" +gender);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007(){
        List<HashMap<String, ?>> email = response.extract().path("findAll{it.status=='inactive'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the emails of the object where status = inactive" +email);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008(){
        List<HashMap<Integer, ?>> gender = response.extract().path("findAll{it.gender=='male'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the ids of the object where gender = male" +gender);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the status
    @Test
    public void test009(){
        List<HashMap<String, ?>> status = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get all the status " + status);
        System.out.println("------------------End of Test---------------------------");

    }
    //10. Get email of the object where name = Jagadish Ahuja
    @Test
    public void test010(){
        List<HashMap<String, ?>> email = response.extract().path("findAll{it.name=='Jagadish Ahuja'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get email of the object where name = Jagadish Ahuja" +email);
        System.out.println("------------------End of Test---------------------------");

    }
    //11. Get gender of id = 4104807
    @Test
    public void test011(){
        List<String> genderID = response.extract().path("findAll{it.id =='4104807'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get gender of id = 4104807: " +genderID);
        System.out.println("------------------End of Test---------------------------");

    }
    }








