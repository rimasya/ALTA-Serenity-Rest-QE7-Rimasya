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

public class GetListResourceDef {

    @Steps
    ReqresAPI reqresAPI;
    //scanerio tugas 3

    @Given("Get list user with invalid parameter {int}")
    public void getSingleUserWithInvalidParameterParam(int id) {
        reqresAPI.setGetListResource(id);
    }

    @When("Send get list resource valid request")
    public void sendGetListResourceValidRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @Then("Status code invalid user should be {int} OK")
    public void statusCodeInvalidUserShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate get list user resource json schema")
    public void validateGetListUserResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListUserResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
