Feature: Register
  As a user
  I want to be able to register for an account
  so that I can access content for registered users

  Scenario Outline: Register in nopcommerce.com
    When I click on Register button in the top menu
    Then a form must to be shown
    Then I select "<gender>" as gender
    And I write my name: "<firstname>" "<lastname>"
    Then I choose my date of birth: day "<day>", month "<month>", year "<year>"
    And I enter my email "<email>"
    And I set and confirm my password "<password>"
    Then I click on Register button
    Then I should be redirect to a message "Your registration completed" and click on Continue button
    And return logged to the homepage

    Examples:
      | gender | firstname | lastname | day | month  | year | email             | password |
      | Female | Elsa      | Brozo    | 15  | August | 1986 | ebrozo@correo.com | 123456   |

