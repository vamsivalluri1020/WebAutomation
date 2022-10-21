Feature: Gmail compose

  Scenario: Validate mail compose
    Given launch site using "chrome"
    When enter userid as "magnitiait"
    And click userid next button
    And enter password as "Magnitia@05"
    And click password next button
    And send mail and test
      | to                 | subject | body   | attachment                                               |
      | apj@abdulkalam.com | wishes  | hi sir | C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg |
      | info@magnitia.com  | wishes  | hi all | C:\\Users\\Public\\Pictures\\Sample Pictures\\desert.jpg |
    When do logout
    And quit site
