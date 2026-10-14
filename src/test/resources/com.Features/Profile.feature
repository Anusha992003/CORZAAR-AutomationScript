@Profile
Feature: Profile page

Background:
Given User login with valid credentials

Scenario Outline: Verifying the profile page
Given User clicks on profile icon
And User should click on My Profile option 
Then User should be navigated to profile page 
And User verifies the title  
When User enters the full name "<name>"
When User enters the email "<mail>"
And User clicks on save button 
Then User verifies the changes "<result>"

Examples:
| name | mail          | result     |
#|      | abc@gmail.com | empty      |
| 1234 | abc@gmail.com | invalidname|
| @#$  | abc@gmail.com | invalidname|
| ab@1 | abc@gmail.com | invalidname|
| Anu  |               | optionalMail|
| Anu  | abcgmail.com  | invalidmail|
| Anu  | abc@          | invalidmail|
| Anu  | abc@gmail.com | valid      |

Scenario: Verify the refund claims 
Then User validates the claims count 

