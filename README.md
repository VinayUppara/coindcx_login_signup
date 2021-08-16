# coindcx_login_signup
This repo hosts code for CoinDCX login using RESAPI and CoinDCX signup using Selenium

## **Test Coverage**

    •	Login using RestAPI+Java+Cucumber with url  https://api.coindcx.com/api/v3/authenticate
    •	Signup using Selenium+Cucumber+Java+testNg with url  https://coindcx.com/  
    •   **OTP functionality cannot be checked for Signup as we cannot bypyass CAPTCHA using AUtomation/Selenium**
    
    

## **How to Run ?**

**Project has been developed using Cucumber BDD instead of POM as we can reuse functionality and also define test scenarios as feature files.**

**Create a project by doing a checkout of this repository.**


**Platform and tools information:**

 - OS: Windows 10 
   
 - Browsers: Chrome


 - Frameworks/Tools: Selenium, Cucumber,TestNg, Java, RestAPI

 - IDE: Eclipse Version 20210612-2011

 - Java JDK Version: 1.8

**Framework:**

	

 1. The framework used is Cucumber BDD framework and the testcases are written as feature files and can be found under src/test/resources/features package, login.feature for Login using RestAPI and signup.feature for Signup using web automation.

 2. Testdata is passed in feature files as framework is meant to be simple and Step Definitions for these feature files can be found in coindcx.test package, LoginAPI for login.feature and SignupSteps for signup.feature

 3. coindcx.base.BaseClass has all base methods required for the automation and pages package has all pageobjects and utils package has all the utility methods.

 4. coindcx.test.TestRunner class has the code to run these stepdefinition and feature files

 1. Hooks class has the driver setup and teardown methods which run
    before each scenario.

 1. TESTNG.xml which if run by user triggers the TestRunner file as TestRunner class is configured to run from testing.xml (testing.xml helps when project is complex and multiple TestRunner files are needed)

**Execution:**

**Using TestRunner file** -> In TestRunner file to run any specific feature like login or signup, mention the  feature file  and corresponding step definition path to run.

1.	Ex: **`features={"src/test/resources/features/signup.feature"}`** will run only signup.feature

2.	If path is till features folder, then all features in that folder are run alphabetically like **`features= {"src/test/resources/features}`** will execute both login, signup features alphabetically.

4.	The corresponding step definitions classes for these features must be mentioned as `glue = {"coindcx.test"}` where the glue path denotes the path for the stepdefinition classes. Since both step definition classes are present in coindcx.test package the framework will automatically lookup the steps for the feature files.

•	**Using TestNG.xml file** -> Running testing.xml file will invoke the TestRunner file as its configured as the class to be executed. (testing.xml helps when project is complex and multiple TestRunner files are needed)
