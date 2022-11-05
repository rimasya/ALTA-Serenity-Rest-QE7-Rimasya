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

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //scanario tugas 1
    @Given("Get single user with parameter page {int}")
    public void getSingleUserWithParameterPageId(int id) {
        reqresAPI.setGetSingleUsers(id);
    }
    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }
    @Then("Status code single user should be {int} OK")
    public void statusCodeSingleUserShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Response body page single user should be {int}")
    public void responseBodyPageSingleUserShouldBePage(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }
    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
