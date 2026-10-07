@Verify
Feature: Verify page 

Background:
Given User login with valid credentials 

Scenario Outline: Verifying the verify page
Given User clicks on verify module 
When User verifies the title of page 
And User enters any certifiacte ID in the input field "<ID>"
Then User clicks on verify button "<ID>","<result>"

Examples:
| ID               | result  |
| abc              | invalid |
| CZ-CERT-F80DE0EB | valid   |

Scenario Outline: Validating certificate details
And User validates the result after clicking submit button "<id>"

Examples:
| id               |
| CZ-CERT-F80DE0EB |
