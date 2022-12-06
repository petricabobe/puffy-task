@manual, @ignore
  Feature: User Experience

  Scenario: Image slide show is properly displayed
  Given user opens landing page
  When user scrolls between pictures
  Then left right arrows are functional
  And pictures are shown

  Scenario: All reviews and questions are shown
  Given user opens landing page
  When user clicks on next page
  Then reviews on next page are shown
      |reviews|questions|