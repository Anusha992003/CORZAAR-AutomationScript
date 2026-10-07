@Learning
Feature: Completion of course

Background:
Given User login with valid credentials

Scenario: Learning the selected course 
Given User clicks on the course from My Programs section
And User verifies the overall course completion status at first 
Then User clicks on a module to start the progress 
And User verifies the completion status 
When User clicks on other remaining modules 
Then Course should get completed 
And Official certificate should be generated   
 
