Feature: login with valid credential

  @Sanity @Regression
  Scenario: successful login with valid credentials
    Given Launch the application and navigate to login page
    When user enters email as "manoharpatil@gmail.com" and password as "Manohar"
    And user clicks on the login button
    Then user should be redirected to the Myaccount page

  @dataDriven
  Scenario Outline: Login data driven
    Given Launch the application and navigate to login page
    When enter username and password as "<username>" "<password>"
    And user clicks on the login button
    Then user should be redirected to the Myaccount page

    Examples:
      | username               | password |
      | rahul@gmail.com        | rahul    |
      | ratanpa@gmail.com      | patil12  |
      | manoharpatil@gmail.com | Manohar  |

  @dataDrivenExcel
  Scenario Outline: Login data driven using excel
    Given Launch the application and navigate to login page
    When the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"
    
    Examples:
      | row_index |
      | 1        |
      | 2        |
      | 3        |
      | 4        |
      | 5        |
     
