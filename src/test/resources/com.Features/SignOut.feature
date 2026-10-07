@SignOut
Feature: Signout

Background:
Given User login with valid credentials

Scenario:: Verifying the signout functionality
Given User clicks on profile icon from dashboard 
And User clicks on signout option 
Then User should be navigated to login page 