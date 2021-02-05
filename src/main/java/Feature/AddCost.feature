Feature: Adding cost to the wallet


Scenario Outline: Adding cost to the wallet By selecting card from the dropdown

Given launch the browser open the application
Given enter the credentials
And click on finance 
And click on add
When  enter the "<Add_Money>" "<Select_Card>" "<cvv>" 
When click on topup
Then Amount should be added in the wallet "<bal>" "<add_mon>"

Examples:

|Add_Money|    Select_Card|         cvv|     bal| add_mon|
|20|			497248XXXXXX0049|  123| 	30|		20|
|10|			497248XXXXXX0049|  123|		40|		10|