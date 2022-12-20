import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Demo {
    //Especificamos que estamos haciendo un Test con la anotacion @Test
    @Test
    // 1.- List of Users
    public void testListUsers() {
        // Esta es la base URL en la cual realizaremos las pruebas
        baseURI = "https://reqres.in/api";
        //Hice uso de la terminologia GHERKIN
        String body = given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .body().asString();

        System.out.println(body);
    }

    // 2.-List <RESOURSE>
    @Test
    public void testListResource() {
        baseURI = "https://reqres.in/api";

        String body;
        body = given()
                .when()
                .get("/unknown")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        System.out.println(body);
    }

    //3.-Create
    @Test
    public void testCreate() {
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        given()
                .log().all()
                .body(map.toString())
                .post("/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    //4.-Update
    @Test
    public void testUpdate() {
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "zion resident");

        given()
                .log().all()
                .body(map.toString())
                .put("/users/2")
                .then()
                .log().all()
                .statusCode(200);

    }

    //5.-Update
    @Test
    public void testUpdatePatch() {
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "zion resident");

        given()
                .log().all()
                .body(map.toString())
                .patch("/users/2")
                .then()
                .log().all()
                .statusCode(200);

    }

    //6.-Delete
    @Test
    public void delete() {
        baseURI = "https://reqres.in/api";

        given()
                .delete("/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }

    //7.-Register - Successful
    @Test
    public void regSucc(){
        baseURI = "https://reqres.in/api";

    }

    //8.-Register - Unsuccessful
    @Test
    public void regUns() {

    }

    //9.-Login Successful
    @Test
    public void loginSucc() {

    }


    //10.-Login Unsuccessful
    @Test
    public void loginUns() {
        baseURI = "https://reqres.in/api";

    }
}