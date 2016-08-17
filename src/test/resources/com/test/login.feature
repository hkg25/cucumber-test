#Feature: Login to gmail with different users
#
  #Scenario Outline: Login Gmail
    #Given I go to "loginUrl"
    #And I enter "LoginUserName" as  "username"
    #And I enter "LoginPassword" as  "password"
    #Then I logged in username should be "UserLoggedInName"
    #And I click on "LogoutLink" link
#
    #Examples: 
      #| LoginUserName | LoginPassword | UserLoggedInName |
      #| hgarg         | abc           | success          |
      #| name2         |             7 | Fail             |
