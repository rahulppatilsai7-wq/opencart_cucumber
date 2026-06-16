Feature: Account registration of a user

  Scenario: Account registration of a user
  Given User launches the application and navigates to  Account registration page
  When Enter the below details in the given field
     |First name | Rahul        |
     |Last name  | patil        |
     |Telephone  | 1234561      |
     |password   | hello123     |
   And User selects privacy policy
   And User clicks on continue button   
   Then Account will be created
