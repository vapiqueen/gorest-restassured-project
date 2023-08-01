package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostsAssertionTest extends TestBase {
    static ValidatableResponse response;


    public PostsAssertionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 25
    @Test
    public void test001() {
        response.body("size", equalTo(25));
    }
    //2. Verify the if the title of id =  57253 is equal to ”Aggero coerceo acceptus vereor molestias.”
    @Test
    public void test002(){
        response.body("find{it.id = 57253}.title", equalTo("Aggero coerceo acceptus vereor molestias."));

    }
    //3. Check the single user_id in the Array list (4104811)
    @Test
    public void test003(){
        response.body("id", hasItem(4104811));
    }
    //4. Check the multiple ids in the ArrayList (57249,57248,57247)
    @Test
    public void test004(){
        response.body("id", hasItems(57249,57248,57247));
    }
    //5. Verify the body of userid = 4104812 is equal “Quas cito veritatis. Cunctatio quidem cras. Doloribus ut vitae. Toties causa advenio. Viscus depono tricesimus. Tui claustrum attollo. Corrupti curis solum. Tero adflicto complectus. Accipio eum crepusculum. Auditor clamo thalassinus. Undique patior accusantium. Absque stillicidium benevolentia. Umbra substantia acerbitas. Et spectaculum tolero. Utor voluptatum coniecto. Virtus bestia vesper. Clam auctus amissio. Acies decens ullus.”
    @Test
    public void test005(){
        response.body("find{it.user_id == 4104812 }.body", equalTo("Quas cito veritatis. Cunctatio quidem cras. Doloribus ut vitae. Toties causa advenio. Viscus depono tricesimus. Tui claustrum attollo. Corrupti curis solum. Tero adflicto complectus. Accipio eum crepusculum. Auditor clamo thalassinus. Undique patior accusantium. Absque stillicidium benevolentia. Umbra substantia acerbitas. Et spectaculum tolero. Utor voluptatum coniecto. Virtus bestia vesper. Clam auctus amissio. Acies decens ullus."));
    }
}
