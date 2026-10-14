@Refund
Feature: Refund functionality

Background:
Given User login with valid credentials 

Scenario Outline: Verify the refund request functioanlity
Given User moves to learning space page 
When User clicks on any course from the list 
#And User clicks on refund option 
#Then User verifies the displayed popup 
#And User clicks the submit button without entering the reason
#And User enters the reason for refund "<reason>"
#Then User clicks on submit button 
#And User verifies the popup displayed after submit 
#Then User validates the visibility of refund claim in profile page 

Examples:
#| reason               |
#| Due to college exams |