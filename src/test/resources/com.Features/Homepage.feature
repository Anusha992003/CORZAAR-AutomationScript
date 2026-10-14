@HomePage
Feature: Exploring the courses

Background:
Given User login with valid credentials

Scenario Outline: Search functionality
Given User enters the text in search field "<search>"
And User clicks on Explore courses button 
Then User verifies the search result "<result>","<search>"

Examples:
| search | result  |
|        | empty   |
| 123    | invalid |
| @#$    | invalid | 
| apex   | invalid |
| sel    | valid   |