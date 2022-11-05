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

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scanerio 1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPagePage(int page) {
        reqresAPI.setGetListUsers(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/GetListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //scanerio 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/CreateUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);

    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate create user json schema")
    public void validateCreateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/CreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //scanerio 3
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate put user json schema")
    public void validatePutUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/PutUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //scanerio 4
    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
    //scanario tugas 1
//    @Given("Get single user with parameter page {int}")
//    public void getSingleUserWithParameterPagePage(int id) {
//        reqresAPI.setGetSingleUsers(id);
//    }
//
//    @When("Send get single user request")
//    public void sendGetSingleUserRequest() {
//        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
//    }
//    @Then("Status code single user should be {int} OK")
//    public void statusCodeSingleUserShouldBeOK(int OK) {
//        SerenityRest.then().statusCode(OK);
//    }
//
//    @And("Response body page single user should be {int}")
//    public void responseBodyPageSingleUserShouldBePage(int id) {
//        SerenityRest.then().body(ReqresResponses.DATAID,equalTo(id));
//    }
//
//    @And("Validate get single user json schema")
//    public void validateGetSingleUserJsonSchema() {
//        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserJsonSchema.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

//    @Given("Get single user with parameter invalid page {int}")
//    public void getSingleUserWithParameterPageInvalidPage(int id) {
//        reqresAPI.getSingleUserNotFound(id);
//
//    }
//
//    @When("Send get single user invalid request")
//    public void sendGetSingleUserInvalidRequest() {
//        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_NOT_FOUND );
//    }
//
//    @Then("Status code invalid user should be {int} NOT FOUND")
//    public void statusCodeInvalidUserShouldBeNOTFOUND(int NOT_FOUND) {
//        SerenityRest.then().statusCode(NOT_FOUND);
//    }
//
//    @And("Response body invalid user should be {int}")
//    public void responseBodyInvalidUserShouldBeId(int id) {
//        SerenityRest.then().body(ReqresResponses.DATAID,equalTo(id));
//    }
//}
