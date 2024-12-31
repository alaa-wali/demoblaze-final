@regression
Feature: Sign Up - testing that users can sign up successfully

  Background: shared steps between scenarios
    Given user clicks sign up button in header

  @smoke @device_Windows @author_AlaaWali
  #Positive Scenario
  Scenario: user can sign up using valid email and password
    When user fills in username "alaa.wali13"
    And user fills in password "P@ssword123"
    And user clicks on sign up button
    Then success message should be displayed

#Negative Scenario
  Scenario: user cannot sign up with existing email and password
    When user fills in username "alaa.wali9"
    And user fills in password "P@ssword123"
    And user clicks on sign up button
    Then error message is displayed

