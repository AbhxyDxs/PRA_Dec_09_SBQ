# Company Employee Management

## Beans
1. **Employee**  
   - `String name`  
   - `int employeeId`  
   - `double salary`  

2. **Department**  
   - `String departmentName`  
   - `TreeSet<Employee> employees`  

## Problem
1. Dynamically create `Employee` objects and add them to `Department` objects. Ensure that `TreeSet` maintains employees in ascending order of their salary.  
2. Write two functions:  
   - **Function 1:** Display the highest-paid employee in a given department.  
   - **Function 2:** Remove all employees in a department earning below a given salary threshold (take the threshold dynamically) and display the updated list.  
