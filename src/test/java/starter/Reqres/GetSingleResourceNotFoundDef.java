package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetSingleResourceNotFoundDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single resource with parameter invalid {int}")
    public void getSingleResourceWithParameterInvalidId(int id) {
        reqresAPI.setGetSingleResourceNotfound(id);
    }

    @When("Send get single resource invalid request")
    public void sendGetSingleResourceInvalidRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE_NOTFOUND);
    }

    @Then("Status code invalid single should be {int} NOT FOUND")
    public void statusCodeInvalidSingleShouldBeNOTFOUND(int NOT_FOUND) {
        SerenityRest.then().statusCode(NOT_FOUND);
    }
}
