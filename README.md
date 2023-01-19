# Assignment 3: Software Quality Engineering
This is a repository for assignment 3 of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called Moodle. 
Moodle is a free and open-source learning management system (LMS) that is widely used by educators and trainers to create and manage online learning environments. It provides a range of tools and features that enable users to create and organize content, deliver assessments and quizzes, facilitate communication and collaboration, and track student progress.

## Installation
$$*TODO* Write instructions on how to install the software and prepare the testing environment$$

## What we tested
We tested the forum module that allows for creating a disscusion and upload and attach a file. We chose to test the following user stories:

User story 1: A teacher adds a new disscusion to the course forum and attach a file of size ~900 KB. 

Preconditions: There is a course with a teacher and a forum.

Expected outcome: The new disscusion with the uploaded file is added to the course forum.


User story 2: The Admin changes the maximal upload file size to 10 KB.

Preconditions: There is a course with a forum.

Expected outcome: The maximal upload file size is changed to 10 KB.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a BDD testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 
