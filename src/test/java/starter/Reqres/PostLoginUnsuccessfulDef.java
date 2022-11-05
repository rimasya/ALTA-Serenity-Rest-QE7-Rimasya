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

public class PostLoginUnsuccessfulDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login unsuccessful with valid json")
    public void postLoginUnsuccessfulWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginUnsuccessful.json");
        reqresAPI.setPostLoginUnsuccessful(json);
    }

    @When("Send post login unsuccessful request")
    public void sendPostLoginUnsuccessfulRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_UNSUCCESSFUL);
    }

    @Then("Status code login unsuccessful should be {int}")
    public void statusCodeLoginUnsuccessfulShouldBe(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }

    @And("Response body login unsuccessful should contain error {string}")
    public void responseBodyLoginUnsuccessfulShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate login unsuccessful json schema")
    public void validateLoginUnsuccessfulJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginUnsuccessfulSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
