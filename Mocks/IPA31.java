import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Music{
	private int playListNo;
	private String type;
	private int count;
	private double duration;
	public int getPlayListNo() {
		return playListNo;
	}
	public void setPlayListNo(int playListNo) {
		this.playListNo = playListNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Music(int playListNo, String type, int count, double duration) {
		super();
		this.playListNo = playListNo;
		this.type = type;
		this.count = count;
		this.duration = duration;
	}
	
}
public class IPA31 {
	public static int findAvgOfCount(Music[] M, int sCount) {
		int sum=0;
		int n=0;
		for(Music Mu: M) {
			if(Mu.getCount()>sCount) {
				sum+=Mu.getCount();
				n++;
			}
		}
		if(sum>0) {
			return sum/n;
		}else {
			return 0;
		}	
	}
	public static Music[] sortTypeByDuration(Music[] M, int sDuration) {
		Music[] Res = new Music[0];
		for(Music Mu: M) {
			if(Mu.getDuration()>sDuration) {
				Res = Arrays.copyOf(Res, Res.length+1);
				Res[Res.length-1] = Mu;
			}
		}
		Arrays.sort(Res, Comparator.comparingDouble(Music::getDuration));
		return Res;
	}
	public static void main(String atgs[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Ente No of Playlists: ");
		int n = SC.nextInt();SC.nextLine();
		Music[] M = new Music[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter Playlist ID: ");
			int id = SC.nextInt();SC.nextLine();
			System.out.println("Enter Playlist Type: ");
			String type = SC.nextLine();
			System.out.println("Enter Count: ");
			int count = SC.nextInt();SC.nextLine();
			System.out.println("Enter Duration: ");
			double duration = SC.nextDouble();SC.nextLine();
			
			Music m = new Music(id, type, count, duration);
			M[i] = m;
		}
		System.out.println("Enter Search Count: ");
		int sCount = SC.nextInt();SC.nextLine();
		System.out.println("Enter Search Duration: ");
		int sDuration = SC.nextInt(); SC.nextLine();
		
		int res1 = findAvgOfCount(M, sCount);
		Music[] res2 = sortTypeByDuration(M, sDuration);
		
		if(res1!=0) {
			System.out.println("Average of Count : "+res1);
		}else {
			System.out.println("No playlist found");
		}
		if(res2.length!=0) {
			String res = "";
			for(Music m: res2) {
				System.out.println(m.getType());
			}
		}else {
			System.out.println("No playlist found with mentioned attribute");
		}
	}
}
