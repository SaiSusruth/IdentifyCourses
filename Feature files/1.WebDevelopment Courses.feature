Feature: WebDevelopment Courses

  Scenario: Course Details
    Given the user is navigated to coursera home page
    When user searches for webdevelopment courses,it should display all the web development courses
    Then the user clicks on English and Beginner checkbox,it should display the courses according to the filters.
    And the user should extract the details of first two courses.
