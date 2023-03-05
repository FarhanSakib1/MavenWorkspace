@greenKart
Feature: Verify Green Kart item Shipment
Scenario: Successfully add 2 items to cart and ship to united states
Given User go to the GreenKart Home Page
And User Verify the page title
When User capture all items from page
And Print sorted prices in descending order
And Add second and third items into cart
Then User go to cart page
And User Verify total price
And User go to next page to select country "United States"
And User verify item was successfully shipped "Thank you, your order has been placed successfully"