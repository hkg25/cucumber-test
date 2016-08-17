Feature: Login to gmail with different users

  @Gmail_Login
  Scenario Outline: Login Gmail
    Given I go to "loginUrl"
    When I enter username as "<username>"
    And I enter password as "<password>"
    Then I logged in username should be "<title>"
    And I click on "LogoutLink" link

    Examples: 
      | username       | password | title   |
      | harrygenius99  | abc      | success |
      | harrygenius099 | def      | Fail    |
