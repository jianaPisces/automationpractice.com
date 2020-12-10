@test1
Feature: browser item, basket item, item basket, purchase

  @regressionPurchase
  Scenario Outline: quick view and add item to basket
    Given setup Browser
    And go to home page of automationpractice.com
    When click to quick-view <itemA>
    Then edit Quantity, <sizeA>, Color for <itemA>
    And add the item to basket
    Then continue shopping
    And open another item with name <itemB>
    Then add the itemB to basket
    Then check out to shopping cart summary
    And check shopping with <TotalItemNum> items
    And check total price <priceA>, <priceB>, <shippingPrice> and got a failed assert image
    Then proceed to checkout
    And login with <email>, <password>
    Then complete checkout
    And take a screenshot

    Examples: 
      | itemA                       | sizeA | priceA | itemB  | sizeB | priceB | TotalItemNum | shippingPrice | email                 | password |
      | Faded Short Sleeve T-shirts | M     |  16.51 | Blouse | S     |  27.00 |            2 |          2.00 | jianatest@yahoo.co.uk | BJSSTest |
