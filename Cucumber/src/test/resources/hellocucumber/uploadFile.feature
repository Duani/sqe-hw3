Feature: A set of scenarios for testing the "upload file" module

 Scenario: Successful users logout
    Given successful 'Teacher' Login
    And 'Teacher' successfully navigate to 'My First Course Page'
    And 'Administrator' successfully navigate to 'My First Course Page'
    And successfully entered 'News Forum'
    When 'Teacher' add a 'New Discussion topic
    And 'Administrator' enter 'My First Course Page'
    And enter Subject
    And enter 'News Forum Settings'
    And entered the body of the discussion
    And navigate to attachments and word count
    And navigate in the page to 'Attachment' box
    And change the 'Maximum attachment size' to 10 MB
    And upload the file
    And save at 'Saved and return to Course'
    And saved the changes
    Then getting error for can not upload the file
    And  get the course page 


  Scenario: Teacher uploads a file in the News forum with size of 256 MB
    Given successful 'Teacher' Login
    And 'Teacher' successfully navigate to 'My First Course Page'
    And successfully entered 'News Forum'
    When 'Teacher' add a 'New Discussion topic
    And enter Subject
    And entered the body of the discussion
    And navigate in the page to 'Attachment' box
    And upload the file
    And saved the changes
    Then receive a successful upload message


  Scenario: Administrator changes the maximum file size to a 10 MB
    Given successful 'Administrator' Login
    And 'Administrator' successfully navigate to 'My First Course Page'
    And successfully entered 'News Forum'
    When 'Administrator' enter 'My First Course Page'
    And enter 'News Forum Settings'
    And navigate to attachments and word count
    And change the 'Maximum attachment size' to 10 MB
    And save at 'Saved and return to Course'
    Then get the course page
