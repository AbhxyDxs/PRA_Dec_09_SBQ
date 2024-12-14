import java.util.Scanner;

class Institution{
	private int institutionID;
	private String institutionName;
	private int noOfStudentsPlaced;
	private int noOfStudentsCleared;
	private String location;
	private String grade;
	
	public int getID() {
		return institutionID;
	}
	public String getName() {
		return institutionName;
	}
	public int getPlaced() {
		return noOfStudentsPlaced;
	}
	public int getCleared() {
		return noOfStudentsCleared;
	}
	public String getLocation() {
		return location;
	}
	public String getGrade() {
		return grade;
	}
	public void setID(int institutionID) {
		this.institutionID = institutionID;
	}
	public void setName(String institutionName) {
		this.institutionName = institutionName;
	}
	public void setPlaced(int noOfStudentsPlaced) {
		this.noOfStudentsPlaced = noOfStudentsPlaced;
	}
	public void setCleared(int noOfStudentsCleared) {
		this.noOfStudentsCleared = noOfStudentsCleared;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Institution(int id, String name, int placed, int cleared, String loc) {
		institutionID = id;
		institutionName = name;
		noOfStudentsPlaced = placed;
		noOfStudentsCleared = cleared;
		location = loc;
	}
	
}
public class IPA23 {
	public static int FindNumClearancedByLoc(Institution[] I, String loc) {
		int sum = 0;
		for(Institution In : I) {
			if(In.getLocation().equalsIgnoreCase(loc)) {
				sum += In.getCleared();
			}
		}
		return sum;
	}
	public static Institution UpdateInstitutionGrade(String institutionName, Institution[] I) {
		for(Institution In : I) {
			if(In.getName().equalsIgnoreCase(institutionName)) {
				Institution IN = new Institution(In.getID(),In.getName(),In.getPlaced(),In.getCleared(),In.getLocation());
				int rating = (In.getPlaced()*100)/In.getCleared();
				if(rating>=80) {
					IN.setGrade("A");
				}else {
					IN.setGrade("B");
				}
				return IN;
			}
			break;
		}
		return null;
	}
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Enter No of Institutions: ");
		int n = SC.nextInt(); SC.nextLine();
		Institution[] I = new Institution[n];
		for (int i =0;i<n;i++) {
			System.out.println("Enter ID: ");
			int id = SC.nextInt(); SC.nextLine();
			System.out.println("Enter Name: ");
			String name = SC.nextLine();
			System.out.println("Enter Students Placed: ");
			int placed = SC.nextInt();SC.nextLine();
			System.out.println("Enter Students Cleared: ");
			int cleared = SC.nextInt(); SC.nextLine();
			System.out.println("Enter Location: ");
			String loc = SC.nextLine();
			
			Institution In = new Institution(id, name, placed, cleared, loc);
			I[i] = In;
		}
		System.out.println("Enter Location to Search: ");
		String searchLoc = SC.nextLine();
		System.out.println("Enter Institution to Search: ");
		String searchInst = SC.nextLine();
		
		int res1 = FindNumClearancedByLoc(I, searchLoc);
		Institution res2 = UpdateInstitutionGrade(searchInst, I);
		
		if(res1!=0) {
			System.out.println("No of Clearance: "+res1);
		}else {
			System.out.println("There are no cleared students in this particular location");
		}
		if(res2!=null) {
			System.out.println(res2.getName()+"::"+res2.getGrade());
		}else {
			System.out.println("No Institute is available with the specified name");
		}
	}
}
