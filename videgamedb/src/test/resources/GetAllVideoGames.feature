Feature: Video game Lookup
  As a user of video game API,
  I want to look up all video games
  So that I can get video game information


  @Happy
  Scenario: Look up all video games
    Given I am using the video game API
    When I look up the all video games
    Then I should get a 200 response code

