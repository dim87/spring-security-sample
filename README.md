# Angular homework

## Requirements
We are building an HR system that allows us to see employees of our company, their department and position.
We should be able do CRUD operations on all 3 entities (Employee, Position, Department).
Create an angular application that works with provided backend. Angular application should contain:
1. 3 main pages (Departments, Positions, Employees) with navigation between them.
2. On each page user should see list of all records (i.e. if I open Departments page, I should see a table there that contains all the departments).
    - On Departments Page table should contain 3 columns (id, title, actions)
    - On Position Page table should contain 3 columns (id, title, actions)
    - On Employees Page table should contain 7 columns (id, firstName, lastName, email, departmentId, positionId, actions)
    - Actions column in all tables contains 2 buttons/icons/links- "Update", "Delete"
3. I must be able to create a new entry on each page, so add a "Create" button that opens a form.
4. There must be a button to delete specific table record (maybe with a trash icon).
5. Each table record must be editable (in a new page with form, or in a dialog window, or in any other way)
6. Bonus points:
    - adding a confirmation when user tries to delete something
    - adding correct validations in reactive forms
    - display employee position and department titles instead of IDs in employees table
    - displaying all employees in selected department
    - displaying all employees in selected position
    - using Bootstrap and/or Angular Material

## How to run backend

1. Find application file:
```
backend/src/main/java/com/sda/angularhomeworkbackend/AngularHomeworkBackendApplication.java
```
2. Right click and 'Debug AngularHomeworkBackendApplication'

This will run the backend and run the in-memory database with all the data that is required for our application. 
But remember that database that is used is in-memory and all the changes will be lost when you restart your backend application. 
This was to done to help you with testing you angular application.

## How to see what is in database
1. Go to url(http://localhost:8080/h2). You will see a database console window
2. In field *JDBC URL* type in ```jdbc:h2:mem:test```
3. Press connect

In the console you can browse tables, see the structure, and see the data that is in our running database.

### Importing Postman Collection
I have added a postman collection (angular-homework.postman_collection.json) that you 
can import and see all the requests that can be sent to backend. In Postman application you can press "Import" and add this file,
after that you will see a new collection with all the requests.


