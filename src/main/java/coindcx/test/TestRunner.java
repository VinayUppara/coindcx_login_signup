package coindcx.test;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= {"src/test/resources/features/signup.feature"}
		, glue = { "coindcx.test" }, monochrome = true )
public class TestRunner extends AbstractTestNGCucumberTests{


}
