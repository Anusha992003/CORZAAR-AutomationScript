@Sorting
Feature: Sorting the courses

  Background:
    Given User login with valid credentials
    And User click the sort dropdown

  Scenario: Sorting functionality
    Given User select the Highest rated option from sort dropdown 
    Then All courses should change to descending order based on ratings  
    When User select the Price (Low to High) option 
    Then Courses should be arranged in ascending order based on price 
    And User select the Price (High to Low) option
    Then Courses should be arranged in descending order based on price