@regression
Feature: Add Products - user can add products to the cart, checkout and place order successfully


@smoke @device_Windows @author_AlaaWali
  #Positive Scenario:
  Scenario: Purchasing products successfully
    #step 1: login
    Given user clicks login button in header
    When user enters username "alaa.wali13"
    And user enters password "P@ssword123"
    And user clicks on login button
    Then account opens successfully

    #step 2: add first product
    Given user clicks on Laptops in categories list
    When user chooses product 1
    And user clicks on add to cart
    Then product is successfully added to cart

    #step 3: add second product
    Given user goes to home page
    And user clicks on Laptops in categories list
    When user chooses product 2
    And user clicks on add to cart
    Then product is successfully added to cart

    #step 4: validate cart
    Given user clicks on cart button in header
    Then user finds both products displayed in the cart with respective titles and prices
    And total amount is calculated correctly

    #step 5: verify total amount calculation
    When user clicks on place order button
    Then total amount is calculated correctly on the place order page

    #step 6: proceed to checkout
    When user fills out name "Alaa", country "Egypt", city "Giza", credit card number "1234567890", month "03" and year "27"
    And user clicks on purchase button
    Then order is placed successfully and a success message is displayed

  @device_Windows @author_AlaaWali
  #Bonus Scenario
  Scenario: Adding the same product twice and verifying that quantity updates correctly
    #step 1: login
    Given user clicks login button in header
    When user enters username "alaa.wali9"
    And user enters password "P@ssword123"
    And user clicks on login button
    Then account opens successfully

    #step 2: add product
    Given user clicks on Laptops in categories list
    When user chooses product 1
    And user clicks on add to cart
    Then product is successfully added to cart

    #step3: add product again
    When user clicks on add to cart
    Then product is successfully added to cart

    #step4: verifying product is added twice in cart
    When user clicks on cart button in header
    Then product is added in cart twice


