Feature: User login on the page and redirection

  Background:
    Given The user is on the login page

  Scenario Outline: Checking user login with different credentials

    And The user enters "<username>" and "<password>"
    When The user clicks submit button
    Then The user should be logged in

    Examples:
      | username                   | password |
      | nelejakovljevic@gmail.com  | 1234567  |
      | nelejakovljevic1@gmail.com | 1234568  |
      | nelejakovljevic2@gmail.com | 1234569  |
      | nelejakovljevic3@gmail.com | 1234563  |
      | nelejakovljevic4@gmail.com | 1234564  |
      | nelejakovljevic5@gmail.com | 1234562  |

  Scenario: Checking redirection from Login to Home page
    When The user click on the Home button
    Then The user should be redirected to the Home page
