# Student Grade Management

### Question

Create Java classes with:

---

### **Student**:
- **Fields**:
  - `studentID` (int)
  - `studentName` (String)
  - `grades` (Integer List)

- **Methods**:
  - Constructor to initialize all fields.
  - Getter and Setter methods for each field.

---

### **GradeService Class**:
- **Method 1: `calculateAverageGrade(List<Student> students)`**
  - **Input**: A list of students.
  - **Process**:
    - Calculates the average grade for each student based on their grades list.
  - **Output**: Returns a `Map<Integer, Double>` where the key is the `studentID` and the value is the average grade.

- **Method 2: `reverseSortedMap(Map<Integer, Double> gradeMap)`**
  - **Input**: A map of student IDs and their average grades.
  - **Process**:
    - Sorts the map in descending order of average grades.
  - **Output**: Returns a reversed `LinkedHashMap<Integer, Double>`.

- **Method 3: `studentsAboveThreshold(List<Student> students, double threshold)`**
  - **Input**: A list of students and a grade threshold.
  - **Process**:
    - Finds students whose average grade is greater than or equal to the given threshold.
    - Sorts these students alphabetically by their names.
  - **Output**: Returns a list of student names.

---

### **Main Class - Solution**:
- Reads input for students and their grades from the user.
- Invokes the `GradeService` methods.
- Displays the following:
  - Average grade for each student.
  - The reversed map of student IDs and average grades (sorted in descending order).
  - List of students who scored above the given threshold, sorted alphabetically.

---

### Sample Input:

1. Input student details:
   - **Student 1**:
     - Student ID: `101`
     - Student Name: `Alice`
     - Grades: `[85, 90, 78]`
   - **Student 2**:
     - Student ID: `102`
     - Student Name: `Bob`
     - Grades: `[88, 72, 95]`
   - **Student 3**:
     - Student ID: `103`
     - Student Name: `Charlie`
     - Grades: `[65, 70, 68]`

2. Grade threshold for filtering students: `80`

---

### Sample Output:

1. **Average Grade for Each Student**:
   - Student ID: `101`, Average Grade: `84.33`
   - Student ID: `102`, Average Grade: `85.00`
   - Student ID: `103`, Average Grade: `67.67`

2. **Reversed Map (Descending Order by Average Grade)**:
   - Student ID: `102`, Average Grade: `85.00`
   - Student ID: `101`, Average Grade: `84.33`
   - Student ID: `103`, Average Grade: `67.67`

3. **Students with Average Grade ≥ 80**:
   - `Alice`
   - `Bob`
