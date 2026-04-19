Feature: Learning Reminder Management

Background:
  Given User is logged in
  And User is on My Learning page

Scenario: Add reminder when no reminder exists
  When User navigates to Learning Tools
  And No reminder exists
  Then User creates a new reminder with valid details

Scenario: Add another reminder when reminder already exists
  When User navigates to Learning Tools
  And Reminder already exists
  Then User adds another reminder