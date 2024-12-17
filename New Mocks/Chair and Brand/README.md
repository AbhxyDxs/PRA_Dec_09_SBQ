### Chair and Brand

#### Classes:

1. **Chair**
   - Attributes:
     - `int chairID`
     - `String chairType`
     - `double chairPrice`
     - `Brand chairBrand`

2. **Brand**
   - Attributes:
     - `int brandID`
     - `String brandName`
     - `double brandRating`

#### Task:

Create a business class and implement the following functionalities:

1. **findMostExpensiveChairDetails()**
   - Input: A list of `Chair` objects and a `Brand` to search.
   - Description: Find the most expensive chair that matches the given brand.
   - Output: Return the `Chair` object that is the most expensive among the chairs matching the brand.

2. **calculateDiscountPrice()**
   - Input: A list of `Chair` objects, a `Brand`, and a discount percentage.
   - Description: Find all chairs matching the given brand and apply the discount percentage to their prices.
   - Output: Return an updated list of matching chairs with the discounted prices.

