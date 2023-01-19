# Testing Moodle software using Cucumber
This directory contains the cucumber files for testing the uploading files to Forum module of the Moodle application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/Moodle](resources/Moodle) directory. See the files for a detailed description of the tests.

## Step files
The step files in the [src/test/java/Moodle](src/test/java/Moodle) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
