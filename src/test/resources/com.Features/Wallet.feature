@Wallet
Feature: Wallet page

Background:
Given User login with valid credentials

Scenario: Verifying the wallet page 
Given User clicks on wallet icon 
And User verifies the title of navigated page 
Then User gets the available balance in wallet 
And User copies the referral code 
Then User verifies it 