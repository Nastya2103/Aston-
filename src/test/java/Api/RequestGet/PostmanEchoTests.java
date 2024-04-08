package Api.RequestGet;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {
    private final static String URL = "https://postman-echo.com";

    @Test
    //  @Description("Проверка метода из папки Request Methods - GET Request")
    public void testGetFields() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        // Response response = (Response)
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
                //.assertThat().body("headers.postman-token", notNullValue())
                //.assertThat().body("cookie", notNullValue())
                .extract().response();
    }

    @Test
    //   @Description("Проверка метода из папки Request Methods - POST Raw Text")
    public void testPostRawText() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        String text = new String("{\n    \"test\": \"value\"\n}");
        given()
                .body(text)
                .when()
                .post("/post")
                .then().log().all()
                .assertThat().body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.content-length", equalTo("23"))
                .assertThat().body("headers.accept", equalTo("*/*"))
                .assertThat().body("headers.content-type", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.accept-encoding", notNullValue())
                .assertThat().body("json", equalTo(null))
                .assertThat().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    //  @Description("Проверка метода из папки Request Methods - POST Form Data")
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

    @Test
    //   @Description("Проверка метода из папки Request Methods - PUT Request")
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

    @Test
    //   @Description("Проверка метода из папки Request Methods - PATCH Request")
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

    @Test
    //   @Description("Проверка метода из папки Request Methods - DELETE Request")
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
}
