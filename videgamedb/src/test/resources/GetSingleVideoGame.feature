Feature: Videocode Id Lookup
  As a user of the videogame API
  I want to look up videogame information
  So that I can get videogame details for any videogame ID


  @Happy
  Scenario: Look up a valid Video game id
    Given I am using the VideoGame API
    When I look up the ID "3"
    Then I should get a 200 response code
    And the returned name should be "Tetris"
    And the rating should be "Universal"
    And the reviewScore should be 88