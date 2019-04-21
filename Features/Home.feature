Feature: Home page BithDay Tab Smoke Testing

Scenario: Mouse over on Birthday Tab verify all Child Tabs working or not
    Given User is on HomePage
    When User mouse hover on Birthday  Tab it should Display all the child Tabs
    When User click  on child tabs they should navigate the Respective child  tab pages
    Then All Child Tabs Text should match with Respective child Tabs page Text
    