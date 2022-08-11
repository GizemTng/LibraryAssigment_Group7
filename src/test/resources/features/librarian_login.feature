Feature: Librarian Login

	#Then verify that there are 3 models on the page
  @B26G7-53 @B26G7-52 @LibraryCT
  Scenario Outline: TC1:Librarian verify 3 models on page
    Given librarian is on the loginPage
    Then verify that the title is "Login - Library"
    When librarian enters valid "<email>" address and "<password>"
    And librarian click sign in button
    Then verify that there are three models on the page

    Examples:
      | email              | password |
      | librarian1@library | qU9mrvur |