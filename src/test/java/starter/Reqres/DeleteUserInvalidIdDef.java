package starter.Reqres;

import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORBHolder;
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

public class DeleteUserInvalidIdDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        reqresAPI.setDeleteUserInvalidId(id);
    }
    @When("Send delete user with invalid request")
    public void sendDeleteUserWithInvalidRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_INVALID_ID);
    }

    @Then("Status code should with invalid be {int} No Content")
    public void statusCodeShouldWithInvalidBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
