Feature: login to Gridizen feature


Scenario Outline: with valid username and invalid password 
Given launch the browser and open the application
When valid "<username>" is given and invalid "<password>"
And click on submit
Then verify the login "<url>"



Examples:

     | username|             password|     url|
     | ac1.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|
     | ac11.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/login|
     | ac12.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/login|
     | ac1.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|
     
     
 Scenario Outline:: only positive cases
 Given launch the browser and open the application
 When valid "<username1>" and "<password1>"are given
 And click on submit
 Then verify the login-one "<url1>"
 
 Examples:

     | username1|             password1|     url1|
     | ac1.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|
     | lalli.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|
     | aa59.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|
     | cron.go@yopmail.com|   Test@123|    https://portal.gridizen.co.uk/portal-panel/home|