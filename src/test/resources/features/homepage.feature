Feature: Homepage scenarios

  Background:
    Given The user is on the home page

    Scenario: Check elements presence after clicking Home Button
    When The user navigates to the Home button
    Then All elements should be present