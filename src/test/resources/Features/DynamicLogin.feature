Feature: SauceDemo Login

  Scenario Outline: Login with multiple credentials
    Given I am on the SauceDemo login page
    When I login with username "<username>" and password "<password>"
    Then I should see the product page if "<status>" is "valid"

    Examples:
      | username        | password       | status  |
      | standard_user   | secret_sauce   | valid   |
      | locked_out_user | secret_sauce   | invalid |
