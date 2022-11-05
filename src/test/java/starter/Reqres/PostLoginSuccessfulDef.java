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

public class PostLoginSuccessfulDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post login successful with valid json")
    public void postLoginSuccessfulWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginSuccessful.json");
        reqresAPI.setPostLoginSuccessful(json);
    }

    @When("Send post login successful request")
    public void sendPostLoginSuccessfulRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESSFUL);

    }

    @Then("Status code login successful should be {int} OK")
    public void statusCodeLoginSuccessfulShouldBeOK(int OK) {SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate login successful json schema")
    public void validateLoginSuccessfulJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginSuccessfulSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
