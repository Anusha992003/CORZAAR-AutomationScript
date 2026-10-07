@Offers
Feature: Offers page

Background:
Given User login with valid credentials

Scenario: Verifying the offers page 
Given User clicks on offers module
And User verifies the title of offers page 
Then User clicks on copy option of any card 
And User clicks on Get My Referral code button 
Then User verifies the page navigation to wallet page 