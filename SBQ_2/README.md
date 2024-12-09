
# Chefs and Dishes - PRA Dec 09

## Question

Create Java classes with:

1. **Dish**:
   - Fields: `dishID` (int), `dishName` (String), `preparingTime` (int), `dishPrice` (double).
   - Methods:
     - Constructor to initialize all fields.
     - Getter and Setter methods for each field.

2. **Chef**:
   - Fields: `chefID` (int), `chefName` (String), `chefDishes` (List<Dish>).
   - Methods:
     - Constructor to initialize all fields.
     - Getter and Setter methods for each field.

3. **FestivalService Class**:
   - **Method 1**: `searchDishesByChefInitial(List<Chef> chefs, char initial)`
     - Input: A list of chefs and a character representing the initial of a chef's name.
     - Process:
       - Finds dishes prepared by chefs whose names start with the given initial.
       - Filters these dishes to include only those with more than two vowels in their names.
     - Output: Returns a list of dish names matching the criteria.
   - **Method 2**: `dishesOfChefs(List<Chef> chefs)`
     - Input: A list of chefs.
     - Process:
       - Groups dishes by their respective chefs in a sorted (alphabetical) order by chef names.
     - Output: Returns a `Map<String, List<String>>` where the key is the chef's name, and the value is a list of dish names.

4. **Main Class - Solution**:
   - Reads input for chefs and their respective dishes from the user.
   - Invokes the `FestivalService` methods.
   - Displays the following:
     - Dish names meeting the criteria for a given chef initial.
     - A sorted list of all chefs and their dishes in the format: `ChefName: Dish1, Dish2, ...`.
