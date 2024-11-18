Feature: Purchase Items

  Background:
    Given User is on home page "https://shop.polymer-project.org/"


  Scenario: Purchase Items

    When User Adds following item to the cart
      |item Name|Size|Quantity|Total|Category|
      |Men's Tech Shell Full-Zip|XL|2|50.20|Men's Outerwear|
      |Ladies Modern Stretch Full Zip|XS|3|41.60|Ladies Outerwear|
    And Verify the cart for the following
    |item Name|Size|Quantity|Total|
    |Men's Tech Shell Full-Zip|XL|2|50.20|
    |Ladies Modern Stretch Full Zip|XS|3|41.60|
    When the user checksout the cart
    And fill the account and payment information of "UserA" and place order
    Then verify Thank You message
    And finish the order

