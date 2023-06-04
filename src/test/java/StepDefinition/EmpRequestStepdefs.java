package StepDefinition;

import com.google.gson.Gson;
import core.ApiCall;
import core.DatabaseManager;
import core.FileHandleHelper;
import core.HeaderFormatHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import repository.localRepo.dbModel.PostApidbModel;
import repository.remoteRepo.requestRepo.EmpRegPostReqModel;

//import javax.xml.ws.Response;
import io.restassured.response.Response;
import repository.remoteRepo.responseRepo.EmpRegPostResponseModel;


import java.sql.ResultSet;
import java.sql.SQLException;

import static core.CoreConstrainHelper.base_url;
import static core.FilePathHelper.postApiPath;

public class EmpRequestStepdefs {

    private Gson gson = new Gson();

    private String requestModel;

    Response postApiResponse;

    EmpRegPostReqModel empRegPostReqModel;

    String url;






    @Given("employee has the api {string}")
    public void employeeHasTheApiPath(String path) {

        url = base_url + path;


    }

    @When("employee hit {string} and {string}")
    public void employeeHitNameAndJob(String name, String job) {

        JSONObject requestBody = new FileHandleHelper().readJsonFile(postApiPath);
        empRegPostReqModel = new Gson().fromJson(requestBody.toJSONString(),EmpRegPostReqModel.class);
        empRegPostReqModel.setJob(job);
        empRegPostReqModel.setName(name);
        requestModel = gson.toJson(empRegPostReqModel);

    }

    @And("call the api with body")
    public void callTheApiWithBody() {

        postApiResponse = ApiCall.postCall(HeaderFormatHelper.commonHeaders(),requestModel,url);
        System.out.println(postApiResponse.body().asString());

    }

    @Then("it will return created date data")
    public void itWillReturnCreatedDateData() throws SQLException, ClassNotFoundException {

        EmpRegPostResponseModel empRegPostResponseModel = gson.fromJson(postApiResponse.getBody().asString(), EmpRegPostResponseModel.class);
        System.out.println(empRegPostResponseModel.getJob());
        System.out.println("*************************");
        System.out.println(empRegPostResponseModel.getName());
        System.out.println("*************************");



        ResultSet rs =  DatabaseManager.executeQueries("select * from qa_test.api limit 1");
        while (rs.next()){
            PostApidbModel postApidbModel = new PostApidbModel();

            postApidbModel.setId(rs.getInt("id"));
            postApidbModel.setJob(rs.getString("name"));
            postApidbModel.setName(rs.getString("job"));
            System.out.println(postApidbModel.getId());
            System.out.println(postApidbModel.getJob());
            System.out.println(postApidbModel.getName());

//            System.out.println(rs.getString(2));

        }

    }
}


