@regression
Feature: Puffy Lux Page

  Scenario: The company logo can be seen on the puffy lux page
    Given user opens the landing page
    Then the company logo can be seen
    And product's page name is correct

  Scenario: The reviews button redirects to see all reviews
    Given user opens the landing page
    When clicking on reviews
    Then user is redirected to all reviews

  Scenario:
    Given user opens the landing page
    When clicking on FAQs
    Then user is redirected to all FAQs

  Scenario: The mattress's size and prices are correctly displayed
    Given user opens the landing page
    Then the size matches the price
      | size        | price    |
      | Twin        | $1,749   |
      | Twin-XL     | $1,799   |
      | Full        | $2,049   |
      | Queen       | $2,249   |
      | King        | $2,449   |
      | Cal-King    | $2,449   |
      | Split-King  | $3,598   |

    Scenario: User is able to add review
      Given user opens the landing page
      When we click on write review
      Then review form is displayed

  Scenario: User is able to ask a question
    Given user opens the landing page
    When we click on ask question
    Then question form is displayed