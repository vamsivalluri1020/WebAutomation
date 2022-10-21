Feature: Gmail compose

  Scenario: Validate mail compose
    Given launch site using "chrome"
    When enter userid as "magnitiait"
    And click userid next button
    And enter password as "Magnitia@05"
    And click password next button
    And send mail and test by taking data from excel
    When do logout
    And quit site
