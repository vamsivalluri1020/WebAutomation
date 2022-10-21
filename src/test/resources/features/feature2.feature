Feature: Gmail Login

  @smoketest
  Scenario Outline: Validate password in login page
    Given launch site using "<bn>"
    When enter userid as "magnitiait"
    And click userid next button
    And enter password as "<pwd>"
    And click password next button
    Then validate outcome related to given password criteria like "<pwdcriteria>"
    When close site

    Examples: 
      | pwd         | pwdcriteria | bn      |
      | Magnitia@05 | valid       | chrome  |
      | Magnitia@05 | valid       | firefox |
      | Magnitia@05 | valid       | opera   |
      | Magnitia@06 | invalid     | chrome  |
      | Magnitia@06 | invalid     | firefox |
      | Magnitia@06 | invalid     | opera   |
      |             | blank       | chrome  |
      |             | blank       | firefox |
      |             | blank       | opera   |
