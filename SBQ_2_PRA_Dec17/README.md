## Singers and Songs

Create a Java application that models **Songs**, **Singers**, and a **Service Class** to perform specific operations. Below are the details for the classes, methods, and requirements.

---

## Classes and Attributes

1. **Song**:
   - `String songId`
   - `String songName`
   - `String genre`
   - `int audienceSize`
   - `float performanceBudget`

2. **Singer**:
   - `String singerId`
   - `String singerName`
   - `List<Song> concerts` (List of songs performed by the singer)

---

## Service Class Methods

1. **`getSongWithMaxAudience(List<Singer> singers)`**
   - Accepts a list of singers.
   - Finds the singer who has the **maximum number of songs**.
   - From that singer's songs, determines the song with the **highest audience size**.
   - Return that **Song** object.

2. **`getSongsWithBudgetMoreThanGiven(List<Singer> singers, double minBudget)`**
   - Accepts a list of singers and a double value `minBudget`.
   - Returns a map where:
     - The **key** is the singer's name (`String`).
     - The **value** is a list of `Song` objects where the `performanceBudget` is greater than the given `minBudget`.

---

## Input/Output Requirements

1. The **Solution Class** should:
   - Accept inputs for singers and songs.
   - Call the service methods.
   - Display the outputs.

---

### Input Example:

```
Number of singers: 2

Singer 1:

Singer ID: S1
Singer Name: John
Number of Songs: 2 Song 1: {ID: Song1, Name: Melody1, Genre: Rock, Audience Size: 15000, Budget: 12000.5} Song 2: {ID: Song2, Name: Harmony1, Genre: Pop, Audience Size: 20000, Budget: 18000.75}
Singer 2:

Singer ID: S2
Singer Name: Alice
Number of Songs: 1 Song 1: {ID: Song3, Name: Rhythm1, Genre: Jazz, Audience Size: 10000, Budget: 9500.25}
```

### Output Example:
```
Song with Maximum Audience from the Singer with Most Songs:

Song ID: Song2, Name: Harmony1, Genre: Pop, Audience Size: 20000, Budget: 18000.75
Songs with Budget More Than 10000: John:

Harmony1 (Budget: 18000.75) Alice:
No Songs
```