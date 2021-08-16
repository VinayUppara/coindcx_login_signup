package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoinDcxSignup {


	public WebDriver driver;

	public CoinDcxSignup(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[.='Login'])[1]")
	public WebElement loginLink;

	@FindBy(xpath="//button[.='Login ']/..")
	public WebElement loginToCoinDCX;
	
	@FindBy(xpath="//p[.='Invalid credentials']")
	public WebElement invalidCredentialsError;

	@FindBy(xpath="//span[contains(.,'REGISTER')]")
	public WebElement register;

	@FindBy(xpath="//h2[.='Sign Up']")
	public WebElement signupHeader;

	@FindBy(xpath="//input[@name='firstName']")
	public WebElement firstName;

	@FindBy(xpath="//input[@name='lastName']")
	public WebElement lastName;

	@FindBy(xpath="//input[@name='email']")
	public WebElement email;

	@FindBy(xpath="//input[@name='password']")
	public WebElement password;

	@FindBy(xpath="//div/*[contains(@class,'country')]/div")
	public WebElement countryCode;

	@FindBy(xpath="(//div[@class='country'])[1]")
	public WebElement firstCountry;


	@FindBy(xpath="//div[@class='common-signin-signup-page']")
	public WebElement mainContainer;

	@FindBy(xpath="//input[@name='phone']")
	public WebElement mobileNumber;

	@FindBy(xpath="//label[@class='referral-section']/span")
	public WebElement referralCodeCheckbox;

	@FindBy(xpath="//input[@name='referral']")
	public WebElement enterReferralCode;

	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	public WebElement captchaFrame;

	@FindBy(xpath="//span[@id='recaptcha-anchor']/div[1]")
	public WebElement clickCaptcha;

	@FindBy(xpath="//span[.='Register']/..")
	public WebElement registerOnSignup;

	@FindBy(xpath="//*[.='Invalid Email ID']/..")
	public WebElement emailError;

	@FindBy(xpath="//div[contains(@class,'password-checker')]/following-sibling::*//div[contains(@class,'trigger')]")
	public WebElement passwordError;

	@FindBy(xpath="//span[contains(@class,'active') and text()='Invalid phone number']/..")
	public WebElement invalidMobileError;

}
