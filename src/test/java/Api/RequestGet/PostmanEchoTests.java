package Api.RequestGet;

import org.hamcrest.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {
    private final static String URL = "https://postman-echo.com";

    @Test(priority = 1)
    public void testGetFields() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .assertThat().body("args.foo1", equalTo("bar1"))
                .assertThat().body("args.foo2", equalTo("bar2"))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .extract().response();
    }

    @Test(priority = 2)
    public void testPostRawText() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        String text = new String("{test : value}");
        given()
                .body(text)
                .when()
                .post("/post")
                .then().log().all()
                .assertThat().body("data", equalTo("{test : value}"))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("14"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json", equalTo(null))
                .assertThat().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test(priority = 3)
    public void testPostFormData() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then().log().all()
                .assertThat().body("form.foo1", equalTo("bar1"))
                .assertThat().body("form.foo2", equalTo("bar2"))
                .assertThat().body("data", equalTo(""))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("19"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json.foo1", equalTo("bar1"))
                .assertThat().body("json.foo2", equalTo("bar2"))
                .assertThat().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test(priority = 4)
    public void testPut() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        String text = new String("This is expected to be sent back as part of response body.");
        given()
                .body(text)
                .contentType("application/json")
                .when()
                .put("/put")
                .then().log().all()
                .assertThat().body("data", equalTo("This is expected to be sent back as part of response body."))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("58"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json", equalTo(null))
                .assertThat().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test(priority = 5)
    public void testPatch() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        String text = new String("This is expected to be sent back as part of response body.");
        given()
                .body(text)
                .contentType("application/json")
                .when()
                .patch("/patch")
                .then().log().all()
                .assertThat().body("data", equalTo("This is expected to be sent back as part of response body."))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("58"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json", equalTo(null))
                .assertThat().body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test(priority = 6)
    public void testDelete() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        String text = new String("This is expected to be sent back as part of response body.");
        given()
                .body(text)
                .contentType("application/json")
                .when()
                .delete("/delete")
                .then().log().all()
                .assertThat().body("data", equalTo("This is expected to be sent back as part of response body."))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("58"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json", equalTo(null))
                .assertThat().body("url", equalTo("https://postman-echo.com/delete"));
    }

    @Test(priority = 7)
    public void testGetFieldPostmanToken() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .assertThat().body("headers.postman-token", notNullValue())
                .extract().response();
    }
    @Test(priority = 8)
    public void testGetFieldCookie() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .assertThat().body("cookie", notNullValue())
                .extract().response();
    }
}
