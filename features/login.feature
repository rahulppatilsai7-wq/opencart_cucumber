Feature: login with valid credential

#    @Sanity @Regression
#    Scenario: successful login with valid credentials
 #    Given user navigates to login page
 #    Then user enters email as "manoharpatil@gmail.com" and password as "Manohar"
#     And user clicks on the login button
#     Then user should be redirected to the Myaccount page
     
     Scenario Outline: Login data driven
     Given Launch the application and navigate to login page
     Then enter username and password as "<username>" "<password>"
     And click login button 
     Then user should be redirected to the Myaccount page
     
     Examples:
        | username | password |
        | rahul@gmail.com | rahul |
        | ratanpa@gmail.com  | patil12 |
        | manoharpatil@gmail.com  | Manohar |
     
 
