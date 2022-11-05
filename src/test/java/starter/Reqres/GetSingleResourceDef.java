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

public class GetSingleResourceDef {
    @Steps
    ReqresAPI reqresAPI;


    @Given("Get single user with invalid parameter {int}")
    public void getSingleUserWithInvalidParameterParam(int id) {
        reqresAPI.setGetSingleUserResource(id);
    }

    @When("Send get single resource valid request")
    public void sendGetSingleResourceValidRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_RESOURCE);
    }

    @Then("Status code invalid single user should be {int} OK")
    public void statusCodeInvalidSingleUserShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get single user resource json schema")
    public void validateGetSingleUserResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
