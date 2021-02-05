Feature:  functional testing for  join page

Scenario: verify the page with some mandatory fields
Given launch the firefox browser and open the application
When click on join
And fill some of the mandatory values
Then verify submit button