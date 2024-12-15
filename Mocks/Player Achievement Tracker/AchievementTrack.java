import java.util.ArrayList;
import java.util.Scanner;

class Player{
	private long playerID;
	private String playerName;
	private int levelCompleted;
	private int badgesEarned;
	public long getPlayerID() {
		return playerID;
	}
	public void setPlayerID(long playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getLevelCompleted() {
		return levelCompleted;
	}
	public void setLevelCompleted(int levelCompleted) {
		this.levelCompleted = levelCompleted;
	}
	public int getBadgesEarned() {
		return badgesEarned;
	}
	public void setBadgesEarned(int badgesEarned) {
		this.badgesEarned = badgesEarned;
	}
	public Player(long playerID, String playerName, int levelCompleted, int badgesEarned) {
		super();
		this.playerID = playerID;
		this.playerName = playerName;
		this.levelCompleted = levelCompleted;
		this.badgesEarned = badgesEarned;
	}
	
}

class AchievementTracker {

    // 1st function for level completion!
    public void completeLevel(Player player) {
        player.setLevelCompleted(player.getLevelCompleted() + 1);
        if (player.getLevelCompleted()%3 == 0) {
            player.setBadgesEarned(player.getBadgesEarned() + 1);
        }
    }

    // 2nd function to display player stats!
    public void displayPlayerStats(Player player) {
        System.out.println("Player ID: " + player.getPlayerID());
        System.out.println("Name: " + player.getPlayerName());
        System.out.println("Levels Completed: " + player.getLevelCompleted());
        System.out.println("Badges Earned: " + player.getBadgesEarned());
    }

    // 3rd function to simulate gameplay
    public void simulateGameplay(ArrayList<Player> playerList, long playerID, int lvlsToUpdate) {
        for (Player player : playerList) {
            if (player.getPlayerID() == playerID) {
                for (int i = 0; i < lvlsToUpdate; i++) {
                    completeLevel(player);
                }
                break;
            }
        }
    }
}

public class AchievementTrack {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        ArrayList<Player> playerList = new ArrayList<>();
        AchievementTracker tracker = new AchievementTracker();

        boolean option = true;
        while (option) {
            System.out.println("Enter Player ID:");
            long playerID = SC.nextLong();
            SC.nextLine(); // Consume newline
            System.out.println("Enter Player Name:");
            String playerName = SC.nextLine();
            System.out.println("Enter Levels Completed:");
            int levelCompleted = SC.nextInt();
            System.out.println("Enter Badges Earned:");
            int badgesEarned = SC.nextInt();
            playerList.add(new Player(playerID, playerName, levelCompleted, badgesEarned));

            System.out.println("Add more players? :");
            option = SC.nextBoolean();
        }

        System.out.println("Enter number of players to simulate:");
        int numberOfPlayers = SC.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter Player ID to simulate:");
            long playerID = SC.nextLong();
            System.out.println("Enter number of levels to complete:");
            int levelsToUpdate = SC.nextInt();
            tracker.simulateGameplay(playerList, playerID, levelsToUpdate);
        }

        for (Player player : playerList) {
            tracker.displayPlayerStats(player);
        }
    }
}
