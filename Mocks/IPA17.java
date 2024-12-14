import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student{
	private int rollNo;
	private String sName;
	private String sSubject;
	private char sGrade;
	private String sDate;
	
	public Student (int rollno, String name, String sub, char grade, String date) {
		rollNo = rollno;
		sName = name;
		sSubject = sub;
		sGrade = grade;
		sDate = date;
	}
	public int getRollno() {
		return rollNo;
	}
	public String getName() {
		return sName;
	}
	public String getSubject() {
		return sSubject;
	}
	public char getGrade() {
		return sGrade;
	}
	public String getDate() {
		return sDate;
	}
}
public class IPA17 {
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.print("Enter No of Students: ");
		int n = SC.nextInt(); SC.nextLine();
		Student[] S = new Student[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter RollNo: ");
			int roll = SC.nextInt(); SC.nextLine();
			System.out.print("Enter Name: ");
			String name = SC.nextLine();
			System.out.print("Enter Subject: ");
			String sub = SC.nextLine();
			System.out.print("Enter Grade: ");
			char grade = SC.nextLine().charAt(0);
			System.out.print("Enter Date: ");
			String date = SC.nextLine();
			
			S[i] = new Student(roll,name,sub,grade,date);
		}
		System.out.print("Enter Grade to Search: ");
		char g = SC.nextLine().charAt(0);
		System.out.print("Enter Month to Search: ");
		int m = SC.nextInt(); SC.nextLine();
		Student[] res = findStudentByGradeAndMonth(S, g, m);
		if(res.length>0) {
			for(int i=0;i<res.length;i++) {
				System.out.println("Name: "+res[i].getName());
				System.out.println("Subject: "+res[i].getSubject());
			}
			System.out.println("Total Students: "+res.length);
		}else {
			System.out.println("No Student Found!");
		}
	}
	
	public static Student[] findStudentByGradeAndMonth(Student[] S, char g, int month) {
		ArrayList<Integer> date = new ArrayList<>();
		Student[] S2 = new Student[0];
		for(int i=0;i<S.length;i++) {
			for(String str : S[i].getDate().split("/")) {
				date.add(Integer.parseInt(str));
			}
			if(S[i].getGrade()==g && date.get(1)==month) {
				S2 = Arrays.copyOf(S2, S2.length+1);
				S2[S2.length-1] = S[i];
			}
		}
		if(S2.length>1) {
			Arrays.sort(S2,Comparator.comparingInt(Student::getRollno));
//			Arrays.sort(S2,Comparator.comparingInt(s -> s.getRollno()));
		}	
		return S2;
		}
	}
