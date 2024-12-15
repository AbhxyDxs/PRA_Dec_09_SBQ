import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.LinkedHashMap;;

class Student2{
	private int studentID;
	private String studentName;
	private ArrayList<Integer> grades;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ArrayList<Integer> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<Integer> grades) {
		this.grades = grades;
	}
	public Student2(int studentID, String studentName, ArrayList<Integer> grades) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.grades = grades;
	}
}
class GradeService{
	public Map<Integer, Double> calculateAverageGrade(List<Student2> S) {
		HashMap<Integer, Double> avgGrade = new HashMap<>();
		for(Student2 St: S) {
			int total = 0;
			int n = 0;
			for(Integer g: St.getGrades()) {
				total += g;
				n++;
			}
			double avg = total/n;
			avgGrade.put(St.getStudentID(), avg);
		}
		return avgGrade;
	}
	public LinkedHashMap<Integer, Double> reverseSortedMap(Map<Integer, Double> gradeMap) {
		//// declaring TreeMap for descending order
		TreeMap<Integer, Double> sortedAvgGrade = new TreeMap<>(Collections.reverseOrder());
		////
		for(Integer ID : gradeMap.keySet()) {
			sortedAvgGrade.put(ID, gradeMap.get(ID));
		}
		LinkedHashMap<Integer, Double> sortedAvgGrade2 = new LinkedHashMap<>(sortedAvgGrade);
		return sortedAvgGrade2;
	}
	public List<String> studentsAboveThreshold(List<Student2> S, double threshold) {
		ArrayList<String> sNames = new ArrayList<String>();
		for(Student2 St: S) {
			int total = 0;
			int n = 0;
			for(Integer g: St.getGrades()) {
				total += g;
				n++;
			}
			double avg = total/n;
			if(avg>threshold) {
				sNames.add(St.getStudentName());
			}
		}
		return sNames;
	}
}
public class SGM{
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Enter No of Students: ");
		int n = SC.nextInt();SC.nextLine();
		ArrayList<Student2> S = new ArrayList<>();
		for(int i=0;i<n;i++) {
			System.out.println("Enter ID: ");
			int id = SC.nextInt();SC.nextLine();
			System.out.println("Enter Name: ");
			String name = SC.nextLine();
			System.out.println("Enter No of Grades: ");
			int nG = SC.nextInt();SC.nextLine();
			ArrayList<Integer> grades = new ArrayList<>();
			for(int j=0;j<nG;j++) {
				System.out.println("Enter Grade: ");
				int g = SC.nextInt();SC.nextLine();
				grades.add(g);
			}
			Student2 s = new Student2(id, name, grades);
			S.add(s);
		}
			
			System.out.println("Enter Grade Threshold to Search: ");
			int threshold = SC.nextInt();SC.nextLine();
			
			GradeService GS = new GradeService();
			Map<Integer, Double> res1 = GS.calculateAverageGrade(S);
			LinkedHashMap<Integer, Double> res2 = GS.reverseSortedMap(res1);
			List<String> res3 = GS.studentsAboveThreshold(S, threshold);
			
			if(!res1.isEmpty()) {
				for(Integer ID: res1.keySet()) {
					System.out.println("Student ID: "+ID);
					System.out.println("Average Grade: "+res1.get(ID));
				}
			}else {
				System.out.println("No Output");
			}
			if(!res2.isEmpty()) {
				for(Integer ID: res2.keySet()) {
					System.out.println("Student ID: "+ID);
					System.out.println("Average Grade: "+res1.get(ID));
				}
			}else {
				System.out.println("No Output");
			}
			if(!res3.isEmpty()) {
				System.out.println("Students with Grade above Threshold");
				System.out.println(String.join(", ", res3));
			}else {
				System.out.println("No Output");
			}
		}
	}

