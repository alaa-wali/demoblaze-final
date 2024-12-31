@regression
Feature: Login - testing that users can login successfully to their existing account

  Background: shared steps between scenarios
    Given user clicks login button in header

  @smoke @device_Windows @author_AlaaWali
  #Positive Scenario
  Scenario: user can use their email and password to login to their account
    When user enters username "alaa.wali13"
    And user enters password "P@ssword123"
    And user clicks on login button
    Then account opens successfully

  @device_Windows @author_AlaaWali
    #negative scenarios
    Scenario Outline: user cannot login with incorrect credentials
      When user enters username "<username>"
      And user enters password "<password>"
      And user clicks on login button
      Then error message "<message>" is displayed
      Examples:
        | username      | password       | message              |
        |alaa.wali9     | wrong_password | Wrong password.      |
        |incorrect.user | P@ssword123    | User does not exist. |
