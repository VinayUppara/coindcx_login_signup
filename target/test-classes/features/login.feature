Feature: Validating CoinDCX login API

@invalid
Scenario: Verify response when login request is sent with invalid email
	Given user have a invalid email request body
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 422
	And "status" in response body should be "error"
	And "message" in response body should be "\"email\" length must be at least 5 characters long"

@invalid	
Scenario: Verify response when login request is sent with invalid password request body
	Given user have a invalid password request body
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 422
	And "status" in response body should be "error"
	And "message" in response body should be "Password is too short (minimum is 8 characters)"

	@unregistered	
Scenario: Verify response when login request is sent by unregistered user
	Given user have a unregistered valid request body
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 401
	And "status" in response body should be "unauthorized"
	And "message" in response body should be "Invalid credentials"
	
	@registered	
Scenario: Verify response when login request is sent by registered user with invalid email
	Given user have a registered user request body with invalid email
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 401
	And "status" in response body should be "unauthorized"
	And "message" in response body should be "Invalid credentials"
	
	@registered	
Scenario: Verify response when login request is sent by registered user with invalid password
	Given user have a registered user request body with invalid password
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 401
	And "status" in response body should be "unauthorized"
	And "message" in response body should be "Invalid credentials"
	
	@registered	
Scenario: Verify response when login request is sent by registered user with valid data
	Given user have a registered user request body with valid data
	When user hits CoinDCX authenticateAPI with POST http request
	Then the API call should be success with status code 200
	And "verify_device" in response body should be "true"
	And "message" in response body should be "Otp sent"
	