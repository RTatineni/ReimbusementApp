Feature: Test Employee functionality 

Scenario: Check login is successful with valid credentials 

	Given browser is opened
	And user is on the login page 
	When user enters username and password and selects employee login
	And user clicks on login btn
	And user fills out form and submits
	Then browser is closed
	