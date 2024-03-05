Feature: Filling the form

  Scenario: Form Details
    Given the user is navigated to enterprises page
    Then the user clicks on the solutions and click on course era for campus.
    Then the user should fill the form with valid details except for mail.
    And an error msg will be displayed for the mail and user have to capture that msg and display it
    
  
