Feature: Wishlist Management

Background:
  Given User is logged in
  And User is on My Learning page

Scenario: Verify course presence in wishlist when not empty
  When User navigates to Wishlist tab
  Then If wishlist has courses, user verifies course presence
  
Scenario: Add course to wishlist if empty and verify
  When User navigates to Wishlist tab
  Then If wishlist is empty, user browses for a course
  And User adds the course to wishlist using wishlist icon
  And User verifies the course is added to wishlist