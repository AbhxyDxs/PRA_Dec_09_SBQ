# Student and Mark 

## Class Definitions

### Class `Mark`:
- **Fields**:
  - `int subjectCode`
  - `String subjectName`
  - `double mark`

---

### Class `Student`:
- **Fields**:
  - `int studentID`
  - `String studentName`
  - `List<Mark> marks`

---

## Methods to Implement

### Service Class Methods:
1. **`findStudentWithInitial(List<Student> students, char initial)`**
   - **Description**: Finds the names of students whose names start with the given initial (lowercase).
   - **Input**:
     - `List<Student> students`: A list of students.
     - `char initial`: The first letter to filter student names.
   - **Output**:
     - Returns a `List<String>` containing the names of students whose names start with the given initial.

2. **`findStudentWithMaxMarkForGivenSubject(List<Student> students, String subject)`**
   - **Description**: Finds the student who scored the highest mark in the given subject.
   - **Input**:
     - `List<Student> students`: A list of students.
     - `String subject`: The subject name for which the highest mark is to be found.
   - **Output**:
     - Returns the `Student` object of the student with the highest mark in the subject.

3. **`findStudentsBetweenMarkRange(List<Student> students, String subject, double minMark, double maxMark)`**
   - **Description**: Finds students who scored marks within the given range for the specified subject.
   - **Input**:
     - `List<Student> students`: A list of students.
     - `String subject`: The subject name to filter marks.
     - `double minMark`: The minimum mark of the range.
     - `double maxMark`: The maximum mark of the range.
   - **Output**:
     - Returns a `List<Student>` of students who scored marks within the specified range.

---

