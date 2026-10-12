@Signin
Feature: Login Functionality

Scenario Outline: Learner signin
Given User is on signin page
When User enters Learner mobile number "<mobile>"
And User enters Full name "<name>"
And User clicks on Send OTP button 
Then User should navigate to otp verification page "<result>"

Examples:
| mobile      | name | result   | 
#|             | Anu  | empty    |
#| sdfg        | Anu  | invalid  |
#| 987653      | Anu  | invalid  |
| 987654321912 | Anu  | maxLen   |
#| 9876543210  |      | optional |
#| @$#%^       | Anu  | invalid  |
| 9876543210  | Anu  | valid    |


Scenario Outline: OTP verification
Given User enters OTP "<mobile>","<name>","<otp>"
And User clicks on Verify & enter learning space button 
Then User should navigate to home page "<result>"

Examples:
#| mobile     | name | otp    | result  |
#| 9876543210 | Anu  |        | empty   |
#| 9876543210 | Anu  | 123    | invalid |
#| 9876543210 | Anu  | @#$%   | invalid |
#| 9876543210 | Anu  | adff   | invalid |
| 9876543210 | Anu  | 123456 | valid   |