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

public class GetDelayResponseDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get delayed with parameter delay {int}")
    public void getDelayedWithParameterDelayId(int id) {
        reqresAPI.setGetDelayedResponse(id);
    }

    @When("Send delayed response request")
    public void sendDelayedResponseRequest() {
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

    @Then("Status code delayed should be {int} OK")
    public void statusCodeDelayedShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate delay response json schema")
    public void validateDelayResponseJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetDelayResponseSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
