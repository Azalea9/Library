## 1. Introduction
As part of my learning on the QA Software developer	bootcamp, I am creating a digital library app to demonstrate the skills I have acquired on the bootcamp. This is to showcase the techniques, tools, and languages I have learned as a Software developer during my bootcamp.

## 2. Digital Library app 
The Digital Library app has the following functions:
 - Allow a book to be added to the Library
 - Allow a book's ISBN, title and author to be updated
 - Allow a book to be removed from the Library
 - Allow searches on books by isbn, title or author or return all books
 - Allow a User to create a Library subscription
 - Allow a User to update their email address on their account
 - Allow a User to remove their Library subscription
 - Allow a User to loan a book from the Library
 - Allow a User to return a book to the Library
 - Allow the Librarian to search for loans by library id
 - Allow the Librarian to search for all loans
 
The final product will be a n-tiered architecture (MVC) of an Web based backend application with RESTful APIs
 - Model (MySQL - Prod / H2 - Test)
 - Controller (Java and Springboot)
 - View (Postman)

## 2. Stack & Tools used

### Languages
 - Java
 - MySQL

### Tools
 - Jira (Scrum)
 - Maven (Build)
 - JUnit (Test)
 - GitHub (Repository)
 - Visual Studio Code (IDE)
 - Postman
 - MySQL Workbench
 
### Framework
 - Springboot

### Techniques
 - Scrum 

## 3. Approach

### Definition
 - [ ] Write up user stories using Jira with priority using **Moscow** and Story point sizing
### Design
 - [ ] Create tasks in Jira with **Story point sizing**
 - [ ] Create ERD diagram to help visualise the data storage
### Implementation
 - [ ] Create a springboot project with the required dependencies
 - [ ] Set up folder structure in Visual studio code
 - [ ] Setup the environment - application properties, profiles, configuration (for test and prod)
 - [ ] Creation of code (classes, repository, controller, services)
 - [ ] Creation of Unit Tests
 - [ ] Creation of Integration Tests including prepopulate data for testing
 
 ### Continuous integration
 - [ ] During the Implementation push code to GitHub repository at frequent intervals
 - [ ] Final project merge all branches to master branch
 - [ ] Final push to the GitHub respository with jar file
 
 ### Build
 - [ ] Create Build (package) when tests are successful
 
 ### Documentation
 - [ ] Write up results in readme file

## 4. How I expected the challenge to go?
I expected some aspects of the challenge to be easier and other parts to be harder. The main success factor for me on this challenge was the limited time to learn the material and then be able to apply it to the project.  Overall, my expectation was that I would be successful to at least meet the basic requirements of the project.

### What went well?
 - [ ] Having a clear idea or scope of what the project should be and sticking to it
 - [ ] Applying Scrum using Jira
 - [ ] Using the best practices around making code readable, in a readable folder structure
 - [ ] Understanding Java to a good level
 - [ ] Creating the classes, services, repository
 - [ ] Putting into practice the 'fail fast' rule when things don't go according to plan
 

### What didn’t go as planned?
- [ ] Integration Testing
- [ ] Environment issues with getting IDE working the right version of Java 


### Possible improvements for future revisions of the project
- [ ] Building in more features such like renewing a book, limiting the books on loan to max of five
- [ ] Using Lombok
- [ ] Building a web based UI for the User to interact with
- [ ] Building more rigourous custom exceptions

### Screenshots showing your postman requests and database
#### Book
***1. Create a book***
***POSTMAN***
<img width="487" text-align:left alt="image" src="https://user-images.githubusercontent.com/91089509/190163487-c999a6e6-e648-48dc-ba0f-ef242527d05e.png">
***DATABASE***
<img width="442" alt="image" src="https://user-images.githubusercontent.com/91089509/190163882-8db4635f-a457-4d25-8c84-77b966305cf8.png">

***2. Get all books***
***POSTMAN***
<img width="416" alt="image" src="https://user-images.githubusercontent.com/91089509/190164188-e851405e-f89e-4848-9a0f-2d91b9a03dee.png">
***DATABASE***
<img width="448" alt="image" src="https://user-images.githubusercontent.com/91089509/190164295-6aa50de3-4340-4fa1-81a5-7ca80ee9023e.png">

***3. Get a book by isbn***
***POSTMAN***
<img width="451" alt="image" src="https://user-images.githubusercontent.com/91089509/190164525-829d1a5e-7205-4efb-be8b-7c0fe578008f.png">
***DATABASE***
<img width="440" alt="image" src="https://user-images.githubusercontent.com/91089509/190164749-afa941dc-16bc-47c9-bfa4-b7506b89364f.png">

***4. Get a book by authors***
***POSTMAN***

***DATABASE***


***5. Get a book by title***
***POSTMAN***

***DATABASE***

***6. Delete a Book***
***POSTMAN***

***DATABASE***



### Screenshots of your database to prove that data is being persisted.


### Screenshot of your test results, including coverage report.


### 	Link to Jira Board - You must add your trainer(s) as collaborators also.

https://azalea999.atlassian.net/jira/software/projects/QP/boards/1/backlog



