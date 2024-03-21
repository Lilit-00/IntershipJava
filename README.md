Homework: Java and MongoDB Integration Project
Objective:
Develop a Java application that interfaces with MongoDB to perform various CRUD operations, manage indexes, execute complex queries, and demonstrate an understanding of data modeling in MongoDB.
Requirements:
Environment Setup
Install MongoDB and set it up on your local machine.
Set up a Java project using Maven for dependency management.
Include the MongoDB Java driver in your project.
Database and Collection Setup
Create a new MongoDB database named SchoolDB.
Within SchoolDB, create two collections: Students and Courses.
CRUD Operations
Implement Java methods to perform the following operations on the Students collection:
Create: Add new student documents. Each student should have a name, age, studentId, and enrolledCourses (an array of course IDs).
Read: Retrieve student documents based on various criteria (e.g., find all students enrolled in a specific course).
Update: Update student details (e.g., add a new course to a student’s enrolledCourses).
Delete: Remove students from the collection.
Indexing and Performance
Create an index on studentId in the Students collection.
Complex Queries and Aggregation
Implement a query to find the number of students enrolled in each course.
Use the aggregation framework to calculate the average age of students in each course.
Data Modeling
For the Courses collection, each document should have a courseId, courseName, and department.
Implement a method to display all courses a student is enrolled in, using either embedding or referencing. Justify your choice of embedding vs. referencing in this scenario.
Error Handling and Input Validation
Implement error handling and input validation for all CRUD operations.
Ensure your application handles exceptions gracefully and provides meaningful error messages.
Documentation and Code Quality
Include comments explaining the purpose and functionality of your code.
Follow Java coding conventions and best practices.
