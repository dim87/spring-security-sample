# Angular homework

### How to run backend

1. Find application file:
```
backend/src/main/java/com/sda/angularhomeworkbackend/AngularHomeworkBackendApplication.java
```
2. Right click and 'Debug AngularHomeworkBackendApplication'

This will run the backend and run the in-memory database with all the data that is required for our application. 
But remember that database that is used is in-memory and all the changes will be lost when you restart your backend application. 
This was to done to help you with testing you angular application.

### How to see what is in database
1. Go to url(http://localhost:8080/h2). You will see a database console window
2. In field *JDBC URL* type in ```jdbc:h2:mem:test```
3. Press connect

In the console you can browse tables, see the structure, and see the data that is in our running database.


