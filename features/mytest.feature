Feature: Test case hotel dominic parks

  @test0
  Scenario: Register account
    Given Open the chrome and launch the application
    And Click Login
    When Input email address
      | email | resanirmaya21@gmail.com |
    And Click create an account
    And user fill data
    And user click button register
    Then Verify page url

  @test0
  Scenario: Login account
    Given Open the chrome and launch the app
    And click header login
    When user fill email dan password
    Then click button sign in
    And click add my first address
    And fill a new address

  @test0
  Scenario: User booking Date
    Given Open the chrome and launch website
    And user fill booking date
    When click button search now
    And system direct to page search room
    And user choose one of rooms
    And fill data guest information
    And click button submit
    Then Process payment booking room


#  @test0
#  Scenario: user display profil Page
#    Given user at registration page
#    When user fill data
#      | FirstName | Resa   |
#      | LastName  | NS     |
#      | Password  | 123456 |
#    And user click button register
#    Then system display profil page









