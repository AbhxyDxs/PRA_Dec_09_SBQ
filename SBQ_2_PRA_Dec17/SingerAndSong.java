import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

class Song{
	String soID;
	String soName;
	String soGenre;
	int audSize;
	float perfBudget;
	Song(String id, String n, String g, int as, float pb){
		soID = id;
		soName = n;
		soGenre = g;
		audSize = as;
		perfBudget = pb;
	}
}
class Singer{
	String siID;
	String siName;
	List<Song> concerts;
	Singer(String id, String n, List<Song> c){
		siID = id;
		siName = n;
		concerts = c;
	}
}
class Service{
	public Song getSongWithMaxAudience(List<Singer> singers) {
		Song maxAud = null;
		Singer maxSongs = null;
		for(Singer S: singers) {
			if(maxSongs==null || S.concerts.size()>maxSongs.concerts.size()) {
				maxSongs = S;
			}
		}
		for(Song SO: maxSongs.concerts) {
			if(maxAud==null || SO.audSize>maxAud.audSize) {
				maxAud = SO;
			}
		}
		return maxAud;
	}
	public Map<String,List<Song>> getSongsWithBudgetMoreThanGiven(List<Singer> singers, double minBudget) {
		HashMap<String,List<Song>> singerSongs = new HashMap<String, List<Song>>();
		for(Singer S: singers) {
			ArrayList<Song> newSongs = new ArrayList<Song>();
			for(Song SO: S.concerts) {
				if(SO.perfBudget>minBudget) {
						newSongs.add(SO);
				}
			}
			singerSongs.put(S.siName, newSongs);
		}
		return singerSongs;
	}
}
public class SingerAndSong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Singer> singers = new ArrayList<>();

        System.out.print("Enter Number of Singers: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Singer ID: ");
            String singerId = scanner.nextLine();
            System.out.print("Enter Singer Name: ");
            String singerName = scanner.nextLine();

            System.out.print("Enter number of songs: ");
            int sN = scanner.nextInt();
            scanner.nextLine();

            List<Song> songs = new ArrayList<>();
            for (int j = 0; j < sN; j++) {
                System.out.print("Enter Song ID: ");
                String songId = scanner.nextLine();
                System.out.print("Enter Song Name: ");
                String songName = scanner.nextLine();
                System.out.print("Enter Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter Audience Size: ");
                int audienceSize = scanner.nextInt();
                System.out.print("Enter Performance Budget: ");
                float performanceBudget = scanner.nextFloat();
                scanner.nextLine();

                songs.add(new Song(songId, songName, genre, audienceSize, performanceBudget));
            }
            singers.add(new Singer(singerId, singerName, songs));
        }
        
        System.out.print("\nEnter Min Budget: ");
        double minBudget = scanner.nextDouble();
        
        Service service = new Service();
 
        Song res1 = service.getSongWithMaxAudience(singers);
        System.out.println("\nSong with Maximum Audience: ");
        if (res1 != null) {
            System.out.println("Song: "+res1.soName+", Audience: "+res1.audSize);
        } else {
            System.out.println("No Songs Found.");
        }

        
        Map<String, List<Song>> songsByBudget = service.getSongsWithBudgetMoreThanGiven(singers, minBudget);

        System.out.println("\nSongs with Budget More Than " + minBudget + ":");
        for (Map.Entry<String, List<Song>> entry : songsByBudget.entrySet()) {
            System.out.println(entry.getKey() + ":");
            if (entry.getValue().isEmpty()) {
                System.out.println("  No Songs");
            } else {
                for (Song song : entry.getValue()) {
                    System.out.println("  - " + song.soName + " (Budget: " + song.perfBudget + ")");
                }
            }
        }
    }
}
