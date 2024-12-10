
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
       - Filters these dishes to include only those with more than 2 vowels in their names.
     - Output: Returns a list of dish names matching the criteria.
   - **Method 2**: `dishesOfChefs(List<Chef> chefs)`
     - Input: A list of chefs.
     - Process:
       - Groups dishes by their respective chefs in a sorted (alphabetical) order by chef names.
     - Output: Returns a `Map<String, List<Dish>>` where the key is the chef's name, and the value is a list of Dish objects.

4. **Main Class - Solution**:
   - Reads input for chefs and their respective dishes from the user.
   - Invokes the `FestivalService` methods.
   - Displays the following:
     - Dish names meeting the criteria for a given chef initial.
     - A sorted list of all chefs and their dishes details.

### Example Input/Output

#### Input:
```
Enter No of Chefs: 
3

Enter Chef ID: 
101
Enter Chef Name: 
Arjun
Enter No of Dishes: 
3
Enter Dish ID: 
1
Enter Dish Name: 
Butter Chicken
Enter Preparation Time: 
45
Enter Dish Price: 
350.0
Enter Dish ID: 
2
Enter Dish Name: 
Paneer Tikka
Enter Preparation Time: 
30
Enter Dish Price: 
300.0
Enter Dish ID: 
3
Enter Dish Name: 
Gulab Jamun
Enter Preparation Time: 
15
Enter Dish Price: 
150.0

Enter Chef ID: 
102
Enter Chef Name: 
Meera
Enter No of Dishes: 
2
Enter Dish ID: 
4
Enter Dish Name: 
Masala Dosa
Enter Preparation Time: 
20
Enter Dish Price: 
200.0
Enter Dish ID: 
5
Enter Dish Name: 
Jalebi
Enter Preparation Time: 
10
Enter Dish Price: 
100.0

Enter Chef ID: 
103
Enter Chef Name: 
Vikram
Enter No of Dishes: 
3
Enter Dish ID: 
6
Enter Dish Name: 
Biryani
Enter Preparation Time: 
60
Enter Dish Price: 
400.0
Enter Dish ID: 
7
Enter Dish Name: 
Samosa
Enter Preparation Time: 
15
Enter Dish Price: 
50.0
Enter Dish ID: 
8
Enter Dish Name: 
Rasgulla
Enter Preparation Time: 
15
Enter Dish Price: 
120.0

Enter Chef Initial to Search: 
M

```

#### Output:
```
Dishes: Masala Dosa, Jalebi
Chef: Arjun
  Dish ID: 1
  Dish Name: Butter Chicken
  Preparation Time: 45
  Price: 350.0
  Dish ID: 2
  Dish Name: Paneer Tikka
  Preparation Time: 30
  Price: 300.0
  Dish ID: 3
  Dish Name: Gulab Jamun
  Preparation Time: 15
  Price: 150.0

Chef: Meera
  Dish ID: 4
  Dish Name: Masala Dosa
  Preparation Time: 20
  Price: 200.0
  Dish ID: 5
  Dish Name: Jalebi
  Preparation Time: 10
  Price: 100.0

Chef: Vikram
  Dish ID: 6
  Dish Name: Biryani
  Preparation Time: 60
  Price: 400.0
  Dish ID: 7
  Dish Name: Samosa
  Preparation Time: 15
  Price: 50.0
  Dish ID: 8
  Dish Name: Rasgulla
  Preparation Time: 15
  Price: 120.0

```
