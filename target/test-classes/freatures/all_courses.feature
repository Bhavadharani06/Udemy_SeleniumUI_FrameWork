Feature: My Learning - All Courses

Background:
  Given User is logged in
  And User is on my Learning page
  
Scenario: Play course when courses are available
  When Courses are available
  Then User clicks on the first course
  And User plays the video
  And User validates video playback controls

Scenario: Browse and play course when no courses are available
  When No courses are available
  Then User searches for a course with keyword "Java"
  And User applies the Free filter and enrolls in a course
  And User is redirected to My Learning page
  And User clicks on the first course
  And User plays the video
  And User validates video playback controls