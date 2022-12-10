Feature:To Perform CRUD Operation
  Scenario: To Perform the GET Operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200
    
   Scenario: To Perform the Post Operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I pass name "Amr1" , title "Test2" , salary 7000
    When I perform the Post Operation
    Then Response code should be 201
    
    
     Scenario: To Perform the Post Operation on posts DB
    Given The base URI is "http://localhost:3000/posts"
    When I pass title "Amr1" , author "Test2" 
    When I perform the Post Operation for Posts
    Then Response code should be 201