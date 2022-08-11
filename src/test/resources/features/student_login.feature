Feature: Student Login

	#Then verify that there are 2 models on the page
  @B26G7-54 @B26G7-52 @LibraryCT
  Scenario Outline: TC2:Students verify 2 models on page
    Given student is on the loginPage
    Then verify that the URL is "https://library2.cydeo.com/login.html"
    When student enters valid "<emailAddress>" and "<studentPassword>"
    And student click sign in button
    Then verify that there are two models on the page

    Examples:
      | emailAddress      | studentPassword |
      | student2@library | zyxa10vg        |
