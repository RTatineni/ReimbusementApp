Feature: Test Manager functionality 

Scenario: Check Manager is able to approve reimbursement

	Given browser is open 
	And user is on login page 
	When user enters username and password and selects login type
	And user clicks on login
	And user approves form and note and submits approval
	Then user navigates to the employee or manager page
	