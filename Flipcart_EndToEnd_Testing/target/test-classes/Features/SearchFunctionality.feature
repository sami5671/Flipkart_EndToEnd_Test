Feature: To validate the Flipkart Application

Background:

Given Launch the Flipkart Application 
When Close the popup 
Then It should Navigate to the Home page

@tc001 @Regression
Scenario: To validate the Search functionality

Given User enter the Text in the Search field 
When Click the search button 
Then It should navigate to the search result page and display the relevent details
Then Extract the result and print in console 
Then Print the Thrid result and keep it in the console
And Select Minimum and Maximum Amount
And Select the Brand
And Select the Ram
And Select the Battery Capacity
Then It should display the Relevant result


@tc002 @Regression
Scenario: To validate the Fashion Functionality

Then It should Navigate to the Home page
Given User to move to the Fashion link
When Cursor to move to the Kids link 
And Move to girls dress and click 
And Click the price high to low link 
Then It should display the relevent details and get the title 