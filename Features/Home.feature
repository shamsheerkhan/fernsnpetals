Feature: Home page BithDay Tab Smoke Testing

Scenario: Mouse over on Birthday Tab verify all Child Tabs working or not
    Given User is on HomePage
    When User mouse hover on Birthday  Tab it should Display all the child Tabs
    Then All Child Tabs Text should match with Respective child Tabs page Text
    