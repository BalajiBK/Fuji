Feature: Purchase Items
#  Add to cart one “Men’s Outwear” of your choice with Size XL and Quantity 2
#  2. View Cart item is added successfully
#  3. Click on Shop to go back to Home Page
#  4. Add to cart one “Ladies Outwear” of your choice with Size XS and Quantity 3
#  5. View Cart item is added successfully
#  6. View the basket and confirm that the items are of the size you selected, that their prices are correct, that Total
#  7. Change the “Ladies Outwear” selected quantity to 1 and confirm the prices is calculated correctly.
#  8. Click on Checkout
#  9. Complete the checkout by providing following data reading from Excel using Apache POI and Java HashMap table
#  a. Account Information
#  i. Email – abc@abc.com
#  ii. Phone-1111111111
#  b. Shipping Address
#  i. Address- 1 abc street
#  ii. City- abc
#  iii. State-abc
#  iv. Zip-123456
#  v. Country-Canada
#  c. Payment Method
#
#  Test Innovation Practice Service (TIPS)
#  An opportunity for the candidate to show case their technical skills and demostrate understanding
#  of the test automation process.
#
#  Hints
#  Be original (do not copy)
#  Be innovative in your approach
#
#  TIPS Assessment [2024]
#
#  Page 2 of 2 TIPS Assessment
#  Contact
#  FUJITSU
#  HR Contact or Hiring Manager
#
#  i. Cardholder Name – ABC ABC
#  ii. Card Number - 1111111111111111
#  iii. Expiry – Feb 2026
#  iv. CVV- 123
#  10. Click on Place Order
#  11. Confirm Thankyou Message
#  12. Click on Finish

  Background:
    Given User is on home page "https://shop.polymer-project.org/"


  Scenario: Purchase Items

#  2. View Cart item is added successfully
#  3. Click on Shop to go back to Home Page
#  4. Add to cart one “Ladies Outwear” of your choice with Size XS and Quantity 3
#  5. View Cart item is added successfully
#  6. View the basket and confirm that the items are of the size you selected, that their prices are correct, that Total
#  7. Change the “Ladies Outwear” selected quantity to 1 and confirm the prices is calculated correctly.
#  8. Click on Checkout
#  9. Complete the checkout by providing following data reading from Excel using Apache POI and Java HashMap table
#  a. Account Information
#  i. Email – abc@abc.com
#  ii. Phone-1111111111
#  b. Shipping Address
#  i. Address- 1 abc street
#  ii. City- abc
#  iii. State-abc
#  iv. Zip-123456
#  v. Country-Canada
#  c. Payment Method
    When User Adds following item to the cart
      |item Name|Size|Quantity|Total|Category|
      |Men's Tech Shell Full-Zip|XL|2|50.20|Men's Outerwear|
    Then User should be able to view 2 Quantity of “Men's Tech Shell Full-Zip” of size "XL" in the cart
    When User Adds 3 Quantity of size "XS" of “Ladies Modern Stretch Full Zip” from category "Ladies Outerwear"
    Then User should be able to view 3 Quantity of “Ladies Modern Stretch Full Zip” of size "XS" in the cart
    And Verify the cart for the following
    |item Name|Size|Quantity|Total|
    |Men's Tech Shell Full-Zip|XL|2|50.20|
    |Ladies Modern Stretch Full Zip|XS|3|41.60|
    When the user checksout the cart
    And fill the account and payment information of "User A"
    And place order
    Then Thank You message is seen
    And click on Finish Button

