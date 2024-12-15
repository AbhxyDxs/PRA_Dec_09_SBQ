# Game Achievement Tracker

## Problem Statement

You are tasked with creating a **Game Achievement Tracker** that monitors and updates player progress based on levels completed in a game. Each player earns badges as they progress through levels. Your goal is to implement a system that dynamically tracks multiple players, simulates gameplay, and updates their statistics.

---

## Requirements

### 1. Player Class

Create a `Player` class with the following attributes:
- **long `playerID`**: Unique player ID.
- **String `playerName`**: Name of the player.
- **int `levelCompleted`**: Number of levels the player has completed.
- **int `badgesEarned`**: Number of badges earned by the player.

The `Player` class should include:
- A **constructor** to initialize these attributes.
- **Getters and Setters** for all the attributes.

---

### 2. Achievement Tracker Class

Create an `AchievementTracker` class with the following methods:

- **`completeLevel(Player player)`**
  - This method increments the `levelCompleted` attribute of the `Player` object by 1.
  - For every 3 levels completed, the player earns 1 badge. The badge count is updated accordingly.

- **`displayPlayerStats(Player player)`**
  - This method displays the current statistics of the player, including:
    - `playerID`
    - `playerName`
    - `levelCompleted`
    - `badgesEarned`

- **`simulateGameplay(ArrayList<Player> playerList, long playerID, int levelsToUpdate)`**
  - This method simulates a player completing a certain number of levels.
  - It identifies the player based on the `playerID` and calls the `completeLevel()` method `n` times, where `n` is the number of levels to be completed (`levelsToUpdate`).

---

### 3. Input and Simulation (`main` method)

The program dynamically accepts input for multiple players until the user chooses to stop. The input consists of:
- **long `playerID`**: Unique ID of the player.
- **String `playerName`**: Name of the player.
- **int `levelCompleted`**: Initial number of levels completed by the player.
- **int `badgesEarned`**: Initial number of badges earned by the player.
- A **boolean flag** to determine whether to add more players (`true` to continue adding, `false` to stop).

Once all players are added, the user provides the number of levels that each player will complete during the simulation:
- Take the values for each player completing the number of levels and save them in the `levelsToSimulate` array.

---

### 4. Simulation

After the input, the program simulates each player completing the given number of levels. The gameplay simulation updates the player's `levelCompleted` and `badgesEarned` attributes based on the rules defined above.

---

### 5. Output

The program displays the updated statistics for each player after the simulation of gameplay.

---

## Example Input and Output

### Input:

```plaintext
Input player details (loop until false):
1001  // Player ID
Alice // Player Name
2     // Levels Completed
0     // Badges Earned
true  // Continue

1002  // Player ID
Bob   // Player Name
5     // Levels Completed
1     // Badges Earned
false // Continue

2     // Input number of players to simulate:
5     // Input number of levels to complete for player 1001
4     // Input number of levels to complete for player 1002
```
### Output:

```
Player ID: 1001
Name: Alice
Levels Completed: 7
Badges Earned: 2

Player ID: 1002
Name: Bob
Levels Completed: 9
Badges Earned: 3
```
