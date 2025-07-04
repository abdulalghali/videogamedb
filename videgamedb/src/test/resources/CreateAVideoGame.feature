Feature: Create a video game
  As a user of the Videogamedb API
  I want to create a video game
  So that I can store and later retrieve information about that game.


  @Happy
  Scenario: Create a video game
    Given I am using the VideoGamedb API
    And I have a valid video game request body
    When I Create a video game
    Then I should get a 200 response code