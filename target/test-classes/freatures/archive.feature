Feature: Archive Management

Background:
  Given User is logged in
  And User is on My Learning page

Scenario: Archive course when archive is empty
  When User navigates to Archived tab
  And Archive is empty
  Then User navigates to All Courses
  And User archives a course

Scenario: Unarchive course when archive has courses
  When User navigates to Archived tab
  And Archive has courses
  Then User unarchives a course