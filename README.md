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
 
### Project Risk Assessment
 - [ ] Conduct a risk assessment on the factors that could delay or stop the successful completion of the projection
 
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
I expected some aspects of the challenge to be easier and other parts to be harder. The main challenge for me was the limited time to learn the material and then be able to apply it to the project as well meet other work and family commitments.  Overall, my expectation was that I would be successful to at least meet the basic requirements of the project.

### What went well?
 - [ ] Having a clear idea or scope of what the project should be and sticking to it
 - [ ] Applying Scrum using Jira
 - [ ] Using the best practices around making code readable, in a readable folder structure
 - [ ] Understanding Java to a good level
 - [ ] Creating the classes, services, repository
 - [ ] Putting into practice the 'fail fast' rule when things don't go according to plan
 

### What didn’t go as planned?
- [ ] Integration Testing and unit testing and being able to achieve the 80% test coverage
- [ ] Environment issues with getting IDE working the right version of Java 


### Possible improvements for future revisions of the project
- [ ] Building in more features such like renewing a book, limiting the books on loan to max of five
- [ ] Using Lombok
- [ ] Building a web based UI for the User to interact with
- [ ] Building more rigourous custom exceptions


## 5. Risk Assessment
The table below shows the identified risks for completing the project


<img width="479" alt="image" src="https://user-images.githubusercontent.com/91089509/190652316-bbc32e3b-e789-4eea-a238-5568e1e4ae63.png">

https://azalea999.atlassian.net/l/cp/7jwtbhCY

## 6. Database ERD of the Library app

![Library ERD Diagram final](https://user-images.githubusercontent.com/91089509/190642292-f89ef303-2cdb-4ec2-8068-c38adb74061f.jpg)

## 7. Screenshots showing your postman requests and database
### Book

***1. Create a book***

***POSTMAN***

<img width="487" text-align:left alt="image" src="https://user-images.githubusercontent.com/91089509/190163487-c999a6e6-e648-48dc-ba0f-ef242527d05e.png">

***DATABASE***

<img width="442" alt="image" src="https://user-images.githubusercontent.com/91089509/190163882-8db4635f-a457-4d25-8c84-77b966305cf8.png">

--------------------------------------------------------------------------------------------------

***2. Get all books***

***POSTMAN***

<img width="416" alt="image" src="https://user-images.githubusercontent.com/91089509/190164188-e851405e-f89e-4848-9a0f-2d91b9a03dee.png">

***DATABASE***

<img width="448" alt="image" src="https://user-images.githubusercontent.com/91089509/190164295-6aa50de3-4340-4fa1-81a5-7ca80ee9023e.png">


--------------------------------------------------------------------------------------------------

***3. Get a book by isbn***

***POSTMAN***

<img width="451" alt="image" src="https://user-images.githubusercontent.com/91089509/190164525-829d1a5e-7205-4efb-be8b-7c0fe578008f.png">

***DATABASE***

<img width="440" alt="image" src="https://user-images.githubusercontent.com/91089509/190164749-afa941dc-16bc-47c9-bfa4-b7506b89364f.png">


--------------------------------------------------------------------------------------------------

***4. Get a book by authors***

***POSTMAN***

<img width="451" alt="image" src="https://user-images.githubusercontent.com/91089509/190176284-2f5959b9-81b1-43a0-ad39-90ddebe95e87.png">


***DATABASE***

<img width="446" alt="image" src="https://user-images.githubusercontent.com/91089509/190176463-b8406df9-ef04-432d-8c20-96aa225b4215.png">


--------------------------------------------------------------------------------------------------

***5. Get a book by title***

***POSTMAN***

<img width="441" alt="image" src="https://user-images.githubusercontent.com/91089509/190175569-02a9d30a-ac1b-4bf2-a2dc-62d3e8dea6fa.png">

***DATABASE***

<img width="467" alt="image" src="https://user-images.githubusercontent.com/91089509/190176041-958734d2-f71d-409e-80de-db1dd8757070.png">


--------------------------------------------------------------------------------------------------

***6. Update a book***

***BEFORE UPDATE IN DATABASE***

<img width="452" alt="image" src="https://user-images.githubusercontent.com/91089509/190179795-4af28e00-734d-40ff-8360-481c14ba6da6.png">

***POSTMAN UPDATE REQUEST***

<img width="443" alt="image" src="https://user-images.githubusercontent.com/91089509/190180170-18a76b31-525d-4572-bcdf-c155288861f1.png">

***AFTER DATABASE IN DATABASE***

<img width="584" alt="image" src="https://user-images.githubusercontent.com/91089509/190180503-110612e0-9a5c-4f8f-a505-2d96e08bcc23.png">


--------------------------------------------------------------------------------------------------

***7. Delete a Book***

***BEFORE UPDATE IN DATABASE***

<img width="584" alt="image" src="https://user-images.githubusercontent.com/91089509/190180503-110612e0-9a5c-4f8f-a505-2d96e08bcc23.png">

***POSTMAN***

<img width="440" alt="image" src="https://user-images.githubusercontent.com/91089509/190181388-e95703f2-a09b-4d14-9755-bfd19d0e8889.png">


***AFTER DATABASE IN DATABASE***

<img width="458" alt="image" src="https://user-images.githubusercontent.com/91089509/190181503-238a9654-9aa5-4517-ae90-e7a5b26b0915.png">


--------------------------------------------------------------------------------------------------

### User

***1. Create a User***

***POSTMAN***

<img width="402" alt="image" src="https://user-images.githubusercontent.com/91089509/190183890-336c3908-4e39-44ac-b3e7-4b07ea07413c.png">


***DATABASE***

<img width="548" alt="image" src="https://user-images.githubusercontent.com/91089509/190184058-446e9a45-540c-49f2-9129-3f1ded7d19e6.png">


--------------------------------------------------------------------------------------------------

***2. Get All Users***

***POSTMAN***

<img width="436" alt="image" src="https://user-images.githubusercontent.com/91089509/190184454-aad13869-653d-4bcd-8c3b-6ef5aafb7d78.png">


***DATABASE***

<img width="707" alt="image" src="https://user-images.githubusercontent.com/91089509/190184748-20c92c6b-3a27-4a63-aadb-acc49de13d5f.png">


--------------------------------------------------------------------------------------------------

***3. Get User by Library ID***

***POSTMAN***

<img width="448" alt="image" src="https://user-images.githubusercontent.com/91089509/190184949-6daeca70-fd94-4021-b815-8ae704dfd466.png">

***DATABASE***

<img width="662" alt="image" src="https://user-images.githubusercontent.com/91089509/190185096-b261f2f8-7ffc-4487-8785-4519d86b02f8.png">

--------------------------------------------------------------------------------------------------

***4. Update email on User***

***BEFORE UPDATE IN DATABASE***

<img width="701" alt="image" src="https://user-images.githubusercontent.com/91089509/190185519-4f20f0e4-6df7-42a4-86d0-7168ac4534a7.png">


***POSTMAN***

<img width="375" alt="image" src="https://user-images.githubusercontent.com/91089509/190185686-f0ceacbd-93be-40da-b855-162fa176d1a4.png">


***AFTER UPDATE IN DATABASE***

<img width="733" alt="image" src="https://user-images.githubusercontent.com/91089509/190185933-275b872c-a423-4b49-b048-70e647d03ee5.png">


--------------------------------------------------------------------------------------------------

***5. Delete a User***

***BEFORE UPDATE IN DATABASE***

<img width="733" alt="image" src="https://user-images.githubusercontent.com/91089509/190185933-275b872c-a423-4b49-b048-70e647d03ee5.png">

***POSTMAN***

<img width="460" alt="image" src="https://user-images.githubusercontent.com/91089509/190186172-3026297a-64b1-43e8-bdaf-3bf7d1b2e68d.png">


***AFTER UPDATE IN DATABASE***

<img width="628" alt="image" src="https://user-images.githubusercontent.com/91089509/190186287-1da60df5-c203-4ebf-b090-2d721dd911cf.png">


--------------------------------------------------------------------------------------------------

### Loans

***1. Create a Book Loan ***

***POSTMAN***

<img width="458" alt="image" src="https://user-images.githubusercontent.com/91089509/190186691-6207c705-fd04-4a02-a14a-4447e2986a9c.png">


***DATABASE***


--------------------------------------------------------------------------------------------------

***2. Get All Books on Loan***

***POSTMAN***

<img width="413" alt="image" src="https://user-images.githubusercontent.com/91089509/190186976-46243dd8-e3e9-4812-89ca-14dbf25ff3d9.png">


***DATABASE***

<img width="474" alt="image" src="https://user-images.githubusercontent.com/91089509/190187131-f2c0f9f5-ebc1-4811-9481-9ba8f7c893c1.png">


--------------------------------------------------------------------------------------------------

***3. Get Loans by User***

***POSTMAN***

<img width="455" alt="image" src="https://user-images.githubusercontent.com/91089509/190189875-cf2ecd9d-51bb-4c7a-bc47-d366faba62a5.png">


***DATABASE***

<img width="470" alt="image" src="https://user-images.githubusercontent.com/91089509/190190123-6ed7c168-328d-4bba-9eb3-ef97097bea56.png">


--------------------------------------------------------------------------------------------------


***4. Return a book (update expiry date)***

***BEFORE UPDATE IN DATABASE***

<img width="297" alt="image" src="https://user-images.githubusercontent.com/91089509/190658256-6a20ec77-8ae3-4f01-9b28-cd0f89ed9970.png">


***POSTMAN***

<img width="486" alt="image" src="https://user-images.githubusercontent.com/91089509/190658510-49c0e50a-ee22-424a-9c0a-6c705029b821.png">


***AFTER UPDATE IN DATABASE***

<img width="293" alt="image" src="https://user-images.githubusercontent.com/91089509/190658684-b53a6d37-302e-4681-89ef-0d67a757f72e.png">


--------------------------------------------------------------------------------------------------

## 8. Screenshot of test results.

### Summary

<img width="480" alt="image" src="https://user-images.githubusercontent.com/91089509/190870358-f2950f5a-81ab-40fd-b854-e94720285ef0.png">

### System Integration Test

***BookController***

<img width="460" alt="image" src="https://user-images.githubusercontent.com/91089509/190870403-f0655433-b4e1-4e33-8b3f-9e2cb657094f.png">

***UserController***

<img width="460" alt="image" src="https://user-images.githubusercontent.com/91089509/190870460-ad841532-4a97-45b1-ab59-ea7ce7e4ce82.png">

### Unit Test Results

***BookService***

<img width="450" alt="image" src="https://user-images.githubusercontent.com/91089509/190870482-e907e108-d885-4363-8b3d-bd9b76405ea1.png">

***LoanService***

<img width="446" alt="image" src="https://user-images.githubusercontent.com/91089509/190870498-e2ac3759-240a-443f-8dc5-a2a4f352e832.png">

***UserService***

<img width="458" alt="image" src="https://user-images.githubusercontent.com/91089509/190870518-87f2896b-63aa-4b56-9e9c-4b410608f117.png">


### Test Coverage report

After implementing the unit and system integration tests, the test coverage report did show gaps in unit and integration tests. If I had more time, I would have set up a more robust test environment, where I was able to prepopulate the data for the integration tests, this would have made executing the tests easier.  I would also have done more unit tests for CRUD as well as included validation tests.

<img width="479" alt="image" src="https://user-images.githubusercontent.com/91089509/190987337-3efdd54a-59b5-4cbc-af4c-d5f29b84e145.png">


## 9. 	Link to Jira Board

https://azalea999.atlassian.net/jira/software/projects/QP/boards/1/backlog



