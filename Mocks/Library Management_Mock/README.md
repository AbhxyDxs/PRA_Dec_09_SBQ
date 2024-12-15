# Library Management

### Question

Create Java classes with:

---

### **Book**:
- **Fields**:
  - `bookID` (int)
  - `title` (String)
  - `author` (String)
  - `price` (double)

- **Methods**:
  - Constructor to initialize all fields.
  - Getter and Setter methods for each field.

---

### **Library**:
- **Fields**:
  - `libraryID` (int)
  - `libraryName` (String)
  - `books` (List<Book>)

- **Methods**:
  - Constructor to initialize all fields.
  - Getter and Setter methods for each field.

---

### **LibraryService Class**:
- **Method 1: `searchBooksByAuthor(List<Library> libraries, String authorName)`**
  - **Input**: A list of libraries and an author's name.
  - **Process**:
    - Searches for all books by the given author in the libraries.
    - Filters these books to include only those priced above 500.
  - **Output**: Returns a list of book titles matching the criteria.

- **Method 2: `booksByLibrary(List<Library> libraries)`**
  - **Input**: A list of libraries.
  - **Process**:
    - Groups books by their respective libraries in a sorted (alphabetical) order by library names.
    - Outputs a map where the key is the library's name and the value is a list of Book objects.
  - **Output**: Returns a `Map<String, List<Book>>`.

---

### **Main Class - Solution**:
- Reads input for libraries and their respective books from the user.
- Invokes the `LibraryService` methods.
- Displays the following:
  - Book titles meeting the criteria for a given author.
  - A sorted list of all libraries and their book details.

---

### Sample Input:

1. Input libraries and books:
   - **Library 1**:
     - Library ID: `101`
     - Library Name: `City Library`
     - Books:
       - Book ID: `1`, Title: `Java Basics`, Author: `John Doe`, Price: `600`
       - Book ID: `2`, Title: `Python Essentials`, Author: `Jane Doe`, Price: `450`
   - **Library 2**:
     - Library ID: `102`
     - Library Name: `Central Library`
     - Books:
       - Book ID: `3`, Title: `Advanced Java`, Author: `John Doe`, Price: `750`
       - Book ID: `4`, Title: `Data Science Handbook`, Author: `Alan Smith`, Price: `800`

2. Search for books by author:  
   - Author Name: `John Doe`

---

### Sample Output:

1. **Books by Author "John Doe" with Price > 500**:
   - `Java Basics`
   - `Advanced Java`

2. **Grouped Books by Library (Sorted by Library Name)**:
   - **Central Library**:
     - `Advanced Java` (750)
     - `Data Science Handbook` (800)
   - **City Library**:
     - `Java Basics` (600)
     - `Python Essentials` (450)
