package coindcx.test;

import java.util.List;
import org.testng.Assert;

import coindcx.base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.CoinDcxSignup;

public class SignupSteps extends BaseClass {

	CoinDcxSignup signup = new CoinDcxSignup(driver);

	@Given("User is present on CoinDCX homepage")
	public void user_is_present_on_coindcx_homepage() {

		driver.get(prop.getProperty("url"));

		waitUntilElementDetected(signup.loginLink);
	}

	@When("User clicks on login from homepage")
	public void user_clicks_on_login_from_homepage() throws InterruptedException {

		click(signup.loginLink);

		waitUntilElementDetected(signup.register);

	}

	@When("clicks on register present on login_register page")
	public void clicks_on_register_present_on_login_register_page() throws InterruptedException {

		click(signup.register);

		waitUntilElementDetected(signup.signupHeader);

	}

	@Then("User should be landed successfully on CoinDCX signup page")
	public void user_should_be_landed_successfully_on_coindcx_signup_page() throws Exception {

		highlight(signup.signupHeader);
	}

	@When("User verifies all signup fields")
	public void user_verifies_all_signup_fields() throws Exception {

		highlight(signup.firstName);

		highlight(signup.lastName);

		highlight(signup.email);

		highlight(signup.password);

		click(signup.countryCode);

		click(signup.firstCountry);

		//signup.scrollDownCountryList();

		click(signup.mainContainer);

		highlight(signup.mobileNumber);

		scollTillPageEnd();

		jsClick(signup.referralCodeCheckbox);

		Assert.assertEquals(isElementPresent(signup.enterReferralCode), true);

		clickCaptcha(signup.captchaFrame,signup.clickCaptcha);

		click(signup.mainContainer);

		Assert.assertFalse(isEnabled(signup.registerOnSignup), "Register to signup is disabled as expected");
	}

	@Then("UI of Signup page is validated successfully")
	public void ui_of_signup_page_is_validated_successfully() {

		System.out.println("UI of CionDCX signup page is validated successfully");

	}

	@When("User verifies error message with invalid emails")
	public void user_verifies_error_message_with_invalid_emails(DataTable table) throws Exception {

		List<String> invalidEmails = table.asList();

		for(String email : invalidEmails) {

			setValue(signup.email, email);

			click(signup.password);

			Thread.sleep(2000);

			Assert.assertEquals(isElementPresent(signup.emailError), true);

			highlight(signup.emailError);

		}

	}

	@Then("Signup with invalid email should be validated successfully")
	public void signup_with_invalid_email_should_be_validated_successfully() {

		System.out.println("Signup with invalid email should be validated successfully");

	}

	@When("User verifies signup with valid emails")
	public void user_verifies_signup_with_valid_emails(DataTable table) throws InterruptedException {

		List<String> validEmails = table.asList();

		for(String email : validEmails) {

			setValue(signup.email, email);

			click(signup.password);

			Thread.sleep(2000);

			Assert.assertFalse(isElementPresent(signup.emailError), "Email Is Accepeted");

		}

	}

	@Then("valid email entered by user should be accepted without any errors")
	public void signup_with_valid_emails_should_be_validated_successfully() {

		System.out.println("valid email entered by user should be accepted without any errors");

	}

	@When("User verifies error message with invalid password format")
	public void user_verifies_error_message_with_invalid_password_format(DataTable table) throws Exception {

		List<String> invalidPasswords = table.asList();

		for(String password : invalidPasswords) {

			setValue(signup.password, password);

			click(signup.email);

			Thread.sleep(2000);

			Assert.assertEquals(isElementPresent(signup.passwordError), true);

			highlight(signup.passwordError);

		}

	}

	@Then("corresponding invalid password format error should be displayed")
	public void corresponding_invalid_password_format_error_should_be_displayed() {

		System.out.println("Corresponding invalid password format error should be displayed successfully");

	}

	@When("User verifies signup with valid password format")
	public void user_verifies_signup_with_valid_password_format(DataTable table) throws InterruptedException {

		List<String> validPasswords = table.asList();

		for(String password : validPasswords) {

			setValue(signup.password, password);

			click(signup.email);

			Thread.sleep(2000);

			Assert.assertEquals(isElementPresent(signup.passwordError), false);

		}

	}

	@Then("valid password entered by user should be accepted without any errors")
	public void valid_password_entered_by_user_should_be_accepted_without_any_errors() {

		System.out.println("valid password entered by user should be accepted without any errors");

	}

	@When("User verifies error message with invalid mobile number format")
	public void user_verifies_error_message_with_invalid_mobile_number_format(DataTable table) throws Exception {

		List<String> invalidMobileNumbers = table.asList();

		for(String mobile : invalidMobileNumbers) {

			setValue(signup.mobileNumber, mobile);

			click(signup.password);

			Thread.sleep(2000);

			Assert.assertEquals(isElementPresent(signup.invalidMobileError), true);

			highlight(signup.invalidMobileError);

		}

	}

	@Then("corresponding invalid mobile number format error should be displayed successfully")
	public void corresponding_invalid_mobile_number_format_error_should_be_displayed_successfully() {

		System.out.println("Corresponding invalid mobile number format error should be displayed successfully");

	}

	@When("User verifies signup with valid mobile number format")
	public void user_verifies_signup_with_valid_mobile_number_format(DataTable table) throws InterruptedException {

		List<String> validMobileNumbers = table.asList();

		for(String mobile : validMobileNumbers) {

			setValue(signup.mobileNumber, mobile);

			click(signup.password);

			Thread.sleep(2000);
		}

	}

	@Then("valid mobile number entered by user should be accepted without any errors")
	public void valid_mobile_number_entered_by_user_should_be_accepted_without_any_errors () {

		System.out.println("Valid mobile number entered by user should be accepted without any errors ");

	}

}
