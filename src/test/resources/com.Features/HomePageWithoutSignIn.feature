@HomeSign
Feature: Validating the home page without sign in 

Scenario: Verify browse by discipline section
Given User clicks on home page icon 
And User clicks on All Disciplines link 
When User clicks on design option 
Then User should be navigated to courses page 
And design courses should be filtered and displayed 

Scenario: Verify featured courses section
Given User clicks on View All link 
And User clicks on any course from the featured courses section 
Then User clicks on any institute card from the Accredited teaching institutes section 
And User clicks on view syllabus link of course card in institute details page 
And User clicks on View all offers 
Then User clicks on Get certified and eligible button 

Scenario: Verify footer links
Given User clicks on All courses link 
And User clicks on Scholarship & offers link 
And User clciks on Verify credentials link 
And User clicks on Learner space link 
And User clicks on Merchant studio link 
And User clicks on Admin command center link 