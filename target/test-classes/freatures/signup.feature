Feature: User Signup

Scenario: User signs up with valid details
  Given User opens Udemy
  When User enters valid name and email
  And User clicks on Sign Up
  Then Verification code should be sent to registered email
  When User enters the verification code and completes the signup process
  Then User should be redirected to homepage