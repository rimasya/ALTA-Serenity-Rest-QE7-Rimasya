package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostRegisterUnsuccessfulDef {

    @Steps

    ReqresAPI reqresAPI;

    @Given("Post register unsuccessful with valid json")
    public void postRegisterUnsuccessfulWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterUnsuccessful.json");
        reqresAPI.setPostRegisterUnsuccessful(json);
    }

    @When("Send post register unsuccessful request")
    public void sendPostRegisterUnsuccessfulRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_UNSUCCESSFUL);
    }

    @Then("Status code register unsuccessful should be {int}")
    public void statusCodeRegisterUnsuccessfulShouldBe(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate register unsuccessful json schema")
    public void validateRegisterUnsuccessfulJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostRegisterUnsuccessfulSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
