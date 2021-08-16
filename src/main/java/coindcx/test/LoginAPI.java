package coindcx.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.Assert;

import utils.FileUtil;
import utils.PayLoad;


public class LoginAPI {


	Response response;

	String responseData;

	OkHttpClient client;

	MediaType mediaType;

	RequestBody body;
	
	Request request;
	
	@Given("user have a invalid email request body")
	public void user_have_a_CoinDCX_baseuri_with_invalid_email_request_body() throws IOException {


		 mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.invalidEmailData);

	}

	@When("user hits CoinDCX authenticateAPI with POST http request")
	public void user_hits_CoinDCX_authenticateAPI_with_POST_http_request() throws IOException {

		client = new OkHttpClient();
		
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));

		request = new Request.Builder().url("https://api.coindcx.com/api/v3/authenticate").addHeader("content-type", "application/json").post(body).build();

		response = client.newCall(request).execute();

		responseData = response.body().string();

		System.out.println(response.toString());
	}

	@Then("the API call should be success with status code 422")
	public void the_API_call_should_be_success_with_status_code_422() {

		Assert.assertEquals(response.code(),422);
	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) throws IOException {

		Assert.assertEquals(FileUtil.getJsonPath(responseData,keyValue),Expectedvalue);
	}

	@Given("user have a invalid password request body")
	public void user_have_a_CoinDCX_baseuri_with_invalid_password_request_body() throws IOException {

		mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.invalidPasswordData);

	}
	
	@Given("user have a unregistered valid request body")
	public void user_have_a_unregistered_user_request_body() throws IOException {

		mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.unregisteredData);

	}
	
	@Then("the API call should be success with status code 401")
	public void the_API_call_should_be_success_with_status_code_401() {

		Assert.assertEquals(response.code(),401);
	}
	
	@Given("user have a registered user request body with invalid email")
	public void user_have_a_registered_user_request_body_with_invalid_email() throws IOException {

		mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.registeredInvalidEmailData);

	}
	
	@Given("user have a registered user request body with invalid password")
	public void user_have_a_registered_user_request_body_with_invalid_password() throws IOException {

		mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.registeredInvalidPasswordData);

	}
	
	@Given("user have a registered user request body with valid data")
	public void user_have_a_registered_user_request_body_with_valid_data() throws IOException {

		mediaType = MediaType.parse("application/json");
		 body = RequestBody.create(mediaType, PayLoad.registeredValidData);

	}
	
	@Then("the API call should be success with status code 200")
	public void the_API_call_should_be_success_with_status_code_200() {

		Assert.assertEquals(response.code(),200);
	}

}
