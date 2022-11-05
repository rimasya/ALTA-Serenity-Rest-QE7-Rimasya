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

public class PostRegisterSuccessfulDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register successful with valid json")
    public void postRegisterSuccessfulWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterSuccessful.json");
        reqresAPI.setPostRegisterSuccessful(json);
    }

    @When("Send post register request")
    public void sendPostRegisterRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    @Then("Status code register successful should be {int} OK")
    public void statusCodeRegisterSuccessfulShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id,String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate register successful json schema")
    public void validateRegisterSuccessfulJsonSchema() {
        File json = new File (ReqresAPI.JSON_SCHEMA+"/PostRegisterSuccessfulSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
