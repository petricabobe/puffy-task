@manual, @mobile, @ignore
Feature: Mobile Puffy Lux

  Scenario Outline: outline: Check page responsiveness
  Given user opens landing page
  When user scrolls through the page
  Then page should align to new size of "<height>" x "<width>"
  And the functionality of the page shouldn't be impacted

  Examples:
  |height| width|
  |844|390|
  |915|412|
  |653|280|
  |1180|820|