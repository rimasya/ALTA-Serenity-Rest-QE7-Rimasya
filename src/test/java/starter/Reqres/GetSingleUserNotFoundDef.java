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

public class GetSingleUserNotFoundDef {

    @Steps
    ReqresAPI reqresAPI;
    //scanario tugas 2
    @Given("Get single user with parameter invalid {int}")
    public void getSingleUserWithParameterInvalidPagePage(int id) {
        reqresAPI.setGetSingleUserNotFound(id);
    }

    @When("Send get single user invalid request")
    public void sendGetSingleUserInvalidRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_NOT_FOUND);
    }

    @Then("Status code invalid user should be {int} NOT FOUND")
    public void statusCodeInvalidUserShouldBeNOTFOUND(int NOT_FOUND) {
        SerenityRest.then().statusCode(NOT_FOUND);
    }
}
