# University Course Management

## Beans
1. **Course**  
   - `String courseName`  
   - `int courseCode`  
   - `String instructorName`  

2. **University**  
   - `String universityName`  
   - `Map<String, List<Course>> coursesByDepartment`  

## Problem
1. Dynamically create `Course` objects and organize them into a `University` by their department (e.g., "Computer Science", "Mathematics", etc.).  
2. Write two functions:  
   - **Function 1:** Find all courses offered by a particular department (take the department name dynamically).  
   - **Function 2:** Display the total number of courses taught by each instructor (use a `Map` to group by instructor name).  
