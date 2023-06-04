package StepDefinition;

import com.google.gson.Gson;
import core.ApiCall;
import core.DatabaseManager;
import core.HeaderFormatHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import repository.localRepo.dbModel.PostApidbModel;
import repository.remoteRepo.responseRepo.UserGetResponseModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import static core.CoreConstrainHelper.base_url;

public class UserGetResponseModelStepdefs {

    String url;
    private Response responseGetApi;
    private Gson gson = new Gson();

//    PostApidbModel postApidbModel;


    @Given("user has the base api")
    public void userHasTheBaseApi() {

        url = base_url + "users";
        
    }

    @When("user call the {string} and {string}")
    public void userCallTheParameterAndParamsValue(String paraName, String value) {

        url = url + paraName + "=" + value;
        System.out.println(url);
        responseGetApi = ApiCall.getCall(HeaderFormatHelper.commonHeaders(), url);
        System.out.println(responseGetApi.body().asString());
        
    }

    @Then("it will return valid data")
    public void itWillReturnValidData() throws SQLException, ClassNotFoundException {

        UserGetResponseModel userGetResponseModel = gson.fromJson(responseGetApi.getBody().asString(), UserGetResponseModel.class);

        System.out.println(userGetResponseModel.getData().get(0).getFirst_name());

//        ResultSet rs =  DatabaseManager.executeQueries("select * from qa_test.api limit 1");
//        while (rs.next()){
//
//            postApidbModel.setId(rs.getInt("id"));
//            postApidbModel.setJob(rs.getString("job"));
//            postApidbModel.setName(rs.getString("name"));
//            System.out.println(postApidbModel.getId());
//            System.out.println(postApidbModel.getJob());
//            System.out.println(postApidbModel.getName());
//
//            System.out.println(rs.getString(2));
//
//        }
    }
}
