Feature: Registration

  Scenario Outline: validate registration operation
    Given launch site using "<bn>"
    When click on create account
    And click on for myself
    And fill fields with "<fn>","<ln>","<uid>","<pwd>" and click next
    And do otp verification if required for "<country>" with "<phone>"
    And fill fields with "<recovery>","<month>","<day>","<year>","<gender>" and click final next
    Then validate output message

    Examples: 
      | bn     | fn    | ln    | uid         | pwd          | country       | phone      | recovery             | month | day | year | gender |
      | chrome | abdul | kalam | jhdfbjbg.67 | q1w2e3r4@123 | United States | 8104075295 | magnitiait@gmail.com | May   |  20 | 2000 | Male   |
