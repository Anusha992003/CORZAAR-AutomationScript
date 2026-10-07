@Cart
Feature: Adding course to the cart

Background:
Given User login with valid credentials 

Scenario Outline: Cart functionality
Given User clicks on any course 
And User should be navigated to course details page 
When User clicks on Add to cart button 
Then Cart icon should be displayed with the number of courses added 
And User clicks on cart icon 
And User should be redirected to cart page 
And User enters promo code and clicks on apply button "<code>"
And User verifies the total after applying coupon 
And User clicks on Pay and enroll button 
Then User should be navigated to learning space 

Examples:
| code      |
| WELCOME20 |