package coindcx.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import coindcx.base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.FileUtil;

public class Hooks extends BaseClass {

	@Before
	public void setup() {

		prop = FileUtil.getPropData();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> chromePerfsMap=new HashMap<>();
		chromePerfsMap.put("profile.managed_default_content_settings.javascript", 1);
		chromePerfsMap.put("profile.default_content_settings.popups",1);
		options.setExperimentalOption("prefs", chromePerfsMap);
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		options.addArguments("start-maximized");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-notifications");
		options.addArguments("disable-extentions");
		options.addArguments("disable-infobars");
		options.addArguments("disable-dev-shm-usage");
		options.addArguments("no-sandbox");
		driver=new ChromeDriver(options);
	}

	@After
	public void tearDown() {
		driver.quit();  
	}
	
}
