Feature: Gmail Login

  Background: 
    Given launch site using "chrome"

  @smoketest
  Scenario: Vaidate Gmail home page title
    Then title should be "Gmail"
    When close site

  Scenario Outline: Validate Userid in home page
    When enter userid as "<uid>"
    And click userid next button
    Then validate outcome related to given userid criteria like "<uidcriteria>"
    When close site

    Examples: 
      | uid           | uidcriteria |
      | magnitiait    | valid       |
      | magnitianonit | invalid     |
      |               | blank       |
