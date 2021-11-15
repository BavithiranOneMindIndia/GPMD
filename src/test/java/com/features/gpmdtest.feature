Feature: Dashboard login & confirms the user

    Verifing Scenarios for Dashboard User login

    Scenario: Dashboard Login

    @googlelogin
    Scenario Outline: Dashboard login
        Given Access WebdriverManager
        Then Launch chrome "<Live>" browser
        Then Enter mobile number
        Then click on continue button
        Then confirm the mobile number
        Then validate the user name
        Then assert login
        Then display all dashboard names
        
        
        
        Examples:
            | Live     |
            | Live.url |

    