# Student Enrollment System

## Beans
1. **Student**  
   - `String name`  
   - `int rollNumber`  
   - `List<String> subjects`  

2. **Batch**  
   - `String batchName`  
   - `List<Student> students`  

## Problem
1. Dynamically create a list of `Student` objects with their enrolled subjects and assign them to a `Batch`.  
2. Write two functions:  
   - **Function 1:** Find all students enrolled in a particular subject (take the subject name dynamically).  
   - **Function 2:** Generate a report of subjects and the number of students enrolled in each (use a `Map`).  
