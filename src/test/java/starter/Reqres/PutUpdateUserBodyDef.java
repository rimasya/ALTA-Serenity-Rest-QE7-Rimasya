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

public class PutUpdateUserBodyDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update body user with valid json with id {int}")
    public void putUpdateBodyUserWithValidJsonWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PutUpdateUserBody.json");
        reqresAPI.setPutUpdateUserBody(id, json);
    }
    @When("Send put update body user request")
    public void sendPutUpdateBodyUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER_BODY);

    }

    @Then("Status code update should be {int} OK")
    public void statusCodeUpdateShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain name {string} ,job {string} and age {string}")
    public void responseBodyShouldContainNameJobAndAge(String name, String job, String age) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job))
                .body(ReqresResponses.AGE,equalTo(age));
    }
    @And("Validate put update user json schema")
    public void validatePutUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateUserBodySchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
