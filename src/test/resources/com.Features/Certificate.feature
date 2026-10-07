@Certificate 
Feature: Certificate verification 

Background:
Given User login with valid credentials 

Scenario: Verifying the certificate page 
Given User clicks on generated certificate link 
And User verifies the page navigation 
Then User validates the certificate ID 
And User clicks on the view button 
Then User verifies the navigated page  