#Author: vinaykumar.u@fnp.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@signup
Feature: Verifying Signup flow of CoindDCX website

Background: Navigating to CoinDCX signup page

		Given User is present on CoinDCX homepage
		
		When User clicks on login from homepage
		And clicks on register present on login_register page
		
		Then User should be landed successfully on CoinDCX signup page
		

  
  Scenario: Verifying UI of Signup page
   	
   	When User verifies all signup fields
    
    Then UI of Signup page is validated successfully
    

 
  Scenario: Verify Signup with invalid email 
  
    When User verifies error message with invalid emails
    |test123|
    |test123@|
    |@test123|
    |test@123.|
    |.test@123|
    |test@123.com.|
    
    Then Signup with invalid email should be validated successfully
    
	@email
  Scenario: Verify Signup with valid emails 
  
    When User verifies signup with valid emails
    |test@123|
    |123@test|
    |a@a|
   	|1@1|
   	|test@123.com|
   	|a@1.com|
    
    Then valid email entered by user should be accepted without any errors
    
  
  Scenario: Verify Signup with invalid password format 
  
    When User verifies error message with invalid password format
    | |
    |a|
    |A|
		|1|
  	|        |
    |aaaaaaaa|
    |AAAAAAAA|
    |11111111|
    |a1Aa1A.|
    
    Then corresponding invalid password format error should be displayed
    
 
  Scenario: Verify Signup with valid password format
  
    When User verifies signup with valid password format
    |a1A.a1A.|
    |aaaaaaaaA1|
    |AAAAAAAAa1|
    |11111111aA|
    
    Then valid password entered by user should be accepted without any errors
    
 
  Scenario: Verify Signup with invalid mobile number format 
  
    When User verifies error message with invalid mobile number format
    |909090909|
    |90909090909|
    |0909090909|
		|+919090909090|
  	|e|
  	|E|
    
    Then corresponding invalid mobile number format error should be displayed successfully
    
 
  Scenario: Verify Signup with valid mobile number format
  
    When User verifies signup with valid mobile number format
    |+09090909090|
    |+9090909090|
    |9090909090|
    
    Then valid mobile number entered by user should be accepted without any errors 
    