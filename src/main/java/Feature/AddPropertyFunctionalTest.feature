Feature: verify all the feilds are mandatory or not


Scenario: Verify Property title is mandatory Field

Given launch the browser open the application
Given enter the credentials
And click on properties 
When fill all the Feild values except property title
|anusha| hani|
Then Submit button should be in disable mode
