Feature: To validate the Flipkart Application

Background:

Given Launch the Flipkart Application 
When Close the popup 
Then It should Navigate to the Home page

@tc001 
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


@tc003 @Regression
Scenario Outline: To validate the search functionality with different values

Given Enter the "<searchtext>" in the search field
When click the search button
Then It should navigate to the next page and display the corresponding page

Examples: 
|searchtext|
|Mobile|
|Tv|
|Speaker|
|Shirt| 

@tc004
Scenario: To validate upto addcart functionality

Given User can move to the login link 
When User can click the flipkart plus zone 
And Mouse move to the Home&Furniture link 
And Going to click the wall lamp 
And Scroll down the page and click one particular result 
And Enter delivery pincode and click the check link 
Then Pincode should be checked and displayed and verify the titles


@tc005 @Regression
Scenario: TO get the title and price from search result

Given Enter the search text in the search field
When Click the search icon 
Then It should display the search result and get the title and price




