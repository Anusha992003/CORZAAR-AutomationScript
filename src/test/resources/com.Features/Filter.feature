@Filter
Feature: Refine search of courses

Background:
Given User login with valid credentials

Scenario: Filter functionality
Given User is on courses page with filter options 
When User selects an option from discipline dropdown 
Then User should get the filtered result according to selected discipline option 
And User clicks on reset option to clear the selected result 
And User selects an option from delivery format section 
Then User should get the filtered result according to selected delivery format option 
And User selects an option from program duration dropdown 
Then User should get the filtered result according to selected program duration option 
When User clicks on Free enrollment only checkbox 
Then User should get only free courses 
And User verifies the result by applying all filters simultaneously 
Then User clicks on reset option  
 