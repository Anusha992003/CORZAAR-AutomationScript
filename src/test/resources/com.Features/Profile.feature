@Profile
Feature: Profile page

Background:
Given User login with valid credentials

Scenario Outline: Verifying the profile page
Given User clicks on profile icon
And User should click on My Profile option 
Then User should be navigated to profile page 
And User verifies the title  
When User enters the email "<mail>"
And User clicks on save button 
Then User verifies the changes 

Examples:
| mail          |
| abc@gmail.com |
