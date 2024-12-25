# Member and Workout

## Classes

### Workout
 - int `activityCode`
 - String `activityName`
 - double `caloriesBurned` 

### Member
 - int `memberID`
 - String `memberName`
 - List&lt;Workout&gt; `memberWorkouts`


## Methods

1. **Find Most Calories Burned for a Specific Activity Code**:
   - Input : `List<Member> Members, String activityCode`
   - Output : `Member Object`
   - Identify the member who burned the most calories for a given activity code.
   - Display : `Most calories burned in activity <activityCode>: <memberName>`
   - If no member performed the activity, print an appropriate message : `No members found for activity <activityCode>`

2. **Find Activities with Calories Burned Above a Threshold**:
   - Input : `List<Member> Members, double threshold`
   - Output : `List<Workout> Workouts`
   - List all unique activity names where the calories burned is greater than a given threshold. 
   - Display : `Activities with calories above <threshold>: <activityName1>,<activityName2>,<activityName3>,...`
   - If no such activities exist, print an appropriate message : `No activities found above the threshold.`

---

## Input Format

1. **Number of Members (n1)**: An integer representing the number of members.
2. **Member Details** (repeated for each member):
   - **Member ID**: An integer.
   - **Member Name**: A string.
   - **Number of Workouts (n2)**: An integer.
   - **Workout Details** (repeated for each workout):
     - **Activity Code**: An integer.
     - **Activity Name**: A string.
     - **Calories Burned**: A double.
3. **Activity Code**: An integer to search for the member who burned the most calories in that activity.
4. **Calories Threshold**: A double to filter activities with calories burned above this threshold.

---

## Sample Test Cases

### Test Case 1
**Input**:
```
2
1
John
2
101
Cycling
500.5
102
Running
300.0
2
Jane
1
101
Cycling
600.0
102
Swimming
400.0
101
450.0
```
**Output**:
```
Most calories burned in activity 101: Jane
Activities with calories above 450.0:
Cycling
Swimming
```
### Test Case 2
**Input**:
```
1
1
Alice
2
201
Yoga
200.0
202
Walking
150.0
202
100.0
```
**Output**:
```
No members found for activity 202
No activities found above the threshold.
```
