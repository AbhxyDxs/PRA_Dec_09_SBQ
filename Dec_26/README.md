# Book and Author 

## Classes

1. **Author**:
     - int `authorID`
     - String `authorName`

2. **Book**:
     - int `bookID`
     - String `bookTitle`
     - String `bookGenre`
     - double `bookPrice`
     - `Author` object `bookAuthor`

3. **Solution Class**:
   - Methods:
     - **`getBooksByGenre(List<Book> books, String searchGenre)`**:
       - Input: A list of books and the genre to search for.
       - Output: A list of books belonging to the specified genre.
     - **`discountPriceforBooks(List<Book> books, String searchGenre, double discount)`**:
       - Input: A list of books, the genre to search for, and a discount percentage.
       - Output: A list of books with updated prices for the specified genre.
       - Discounts are applied as a percentage (e.g., 10% means subtract 10% of the original price).

---

## Input Format

1. **Number of Authors**: An integer representing the total number of authors.
2. **Author Details** (repeated for each author):
   - **Author ID**: An integer.
   - **Author Name**: A string.
   - **Book Details**:
     - **Book ID**: An integer.
     - **Book Title**: A string.
     - **Book Genre**: A string.
     - **Book Price**: A double.

3. **Genre to Search**: A string 
4. **Discount Percentage**: A double 

---


## Output Format

1. **Books by Genre**:
   - Print the list of books belonging to the specified genre.
     `AuthorName: <authorName1>, Title: <bookTitle1>`
     `AuthorName: <authorName2>, Title: <bookTitle2>`
   - If no books are found for the genre, print:  
     `Genre is not available in the list`.

2. **Books with Discounted Prices**:
   - Print the list of books with updated prices for the specified genre.
     `AuthorName: <authorName1>, Title: <bookTitle1>, Updated Price: <updatedPrice1>`
     `AuthorName: <authorName2>, Title: <bookTitle2>, Updated Price: <updatedPrice2>`
   - If no books are found for the genre, print:  
     `Discounted books are unavailable in the given genre.`.

---

## Sample Test Cases

### Test Case 1

**Input**:
```
5
101
Agatha Christie
11
Murder on the Orient Express
Crime
20.00
102
Arthur Conan Doyle
12
The Hound of the Baskervilles
Crime
25.00
103
Stephen Edwin King
13
A Memoir of the Craft
Horror
40.00
104
Clayton Emery
14
The Burning Goddess
Fantasy
30.00
105
Trisha Ashley
15
Wedding Tiers
Fantasy
35.00
Crime
Fantasy
20
```


**Expected Output**:
```
AuthorName: Agatha Christie, Title: Murder on the Orient Express
AuthorName: Arthur Conan Doyle, Title: The Hound of the Baskervilles
Discounted Fantasy Books:
AuthorName: Clayton Emery, Title: The Burning Goddess, Updated Price: 24.0
AuthorName: Trisha Ashley, Title: Wedding Tiers, Updated Price: 28.0
```