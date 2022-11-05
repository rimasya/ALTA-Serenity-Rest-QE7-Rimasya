package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;

import java.io.File;

public class ReqresAPI {

    public static final String URL ="https://reqres.in";
    public static final String DIR =System.getProperty("user.dir");
    public static final String JSON_REQ_BODY =DIR+"/src/test/resources/JSON/RequestBody";
    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String PUT_UPDATE_USER =URL+"/api/users/{id}";
    public static String DELETE_USER =URL+"/api/users/{id}";
    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_SINGLE_USERS = URL+"/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND =URL+"/api/users/{id}";
    public static String GET_LIST_RESOURCE =URL+"/api/{id}";
    public static String POST_REGISTER_SUCCESSFUL =URL+"/api/register";
    public static String POST_REGISTER_UNSUCCESSFUL = URL +"/api/register";
    public static String POST_LOGIN_SUCCESSFUL = URL+"/api/login";
    public static String POST_LOGIN_UNSUCCESSFUL =URL+"/api/login";
    public static String GET_SINGLE_USER_RESOURCE = URL+"/api/unknown/{id}";
    public static String GET_SINGLE_RESOURCE_NOTFOUND =URL+"/api/unknown/{id}";
    public static String GET_DELAYED_RESPONSE= URL+"/api/users?delay/{id}";
    public static String PUT_UPDATE_USER_BODY= URL+"/api/users/{id}";
    public static String DELETE_USER_INVALID_ID= URL+"/api/users/{id}";

    @Step("Get list users")
    public void setGetListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Put update user")
    public void  putUpdateUser(int id, File json){
    SerenityRest.given()
            .pathParam("id", id)
            .contentType(ContentType.JSON)
            .body(json);
}
    @Step ("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
}
    @Step("Get single user")
    public void setGetSingleUsers(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get single user not found")
    public void setGetSingleUserNotFound (int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get list user resource")
    public void setGetListResource(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post register successful")
    public void setPostRegisterSuccessful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post register unsuccessful")
    public void setPostRegisterUnsuccessful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post login successful")
    public void setPostLoginSuccessful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post login unsuccessful")
    public void setPostLoginUnsuccessful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Get single user resource")
    public void setGetSingleUserResource(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single resource not found")
    public  void setGetSingleResourceNotfound(int id){
        SerenityRest.given().pathParam("id",id);
    }
    public void setGetDelayedResponse(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Put update user body")
    public void setPutUpdateUserBody(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Delete user with invalid id ")
    public void setDeleteUserInvalidId(int id) {
        SerenityRest.given().pathParam("id", id);
    }
//    @Step ("Delete user")
//    public void deleteUser(int id){
//        SerenityRest.given()
//                .pathParam("id",id);
}

