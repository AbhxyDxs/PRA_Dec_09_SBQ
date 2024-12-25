import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MemberWorkout2 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();sc.nextLine();
        List<Member> members = new ArrayList<>();
        for(int i=0;i<n1;i++){
            int memberId = sc.nextInt();sc.nextLine();
            String memberName = sc.nextLine();
            int n2 = sc.nextInt();sc.nextLine();
            List<Workout> workouts = new ArrayList<>();
            for(int j=0;j<n2;j++){
                int activityCode = sc.nextInt();sc.nextLine();
                String activityName = sc.nextLine();
                double caloriesBurned = sc.nextDouble();sc.nextLine();
                workouts.add(new Workout(activityCode,activityName,caloriesBurned));
            }
            members.add(new Member(memberId,memberName,workouts));
        }
        int code = sc.nextInt();sc.nextLine();
        double threshold = sc.nextDouble();
        findMostCaloriesBurnedInActivity(members,code);
        findActivityAboveCaloriesThreshold(members,threshold);
    }
    public static void findMostCaloriesBurnedInActivity(List<Member> members, int activityCode){
        String ans1 = "";
        double max=0;
        for(Member m : members){
            for(Workout w : m.workouts){
                if(w.activityCode==activityCode){
                    if(max<w.caloriesBurned){
                        max=w.caloriesBurned;
                        ans1=m.memberName;
                    }
                }
            }
        }
        if(ans1==""){
            System.out.println("No members found for activity " + activityCode);
        }
        else{
            System.out.println("Most calories burned in activity " + activityCode + ": " + ans1);
        }
    }
    public static void findActivityAboveCaloriesThreshold(List<Member> members, double threshold){
        Set<String> ans2 = new LinkedHashSet<>();
        for(Member m : members){
            for(Workout w : m.workouts){
                if(w.caloriesBurned>threshold){
                    ans2.add(w.activityName);
                }
            }
        }
        if(ans2.size()==0){
            System.out.println("No activities found above the threshold.");
        }
        else{
            System.out.println("Activities with calories above " + threshold + ":");
            for(String s : ans2){
                System.out.println(s);
            }
        }
    }
}
class Workout{
    int activityCode;
    String activityName;
    double caloriesBurned;
    public Workout(int activityCode, String activityName, double caloriesBurned){
        this.activityCode=activityCode;
        this.activityName=activityName;
        this.caloriesBurned=caloriesBurned;
    }
}
class Member{
    int memberId;
    String memberName;
    List<Workout> workouts;
    public Member(int memberId, String memberName, List<Workout> workouts){
        this.memberId=memberId;
        this.memberName=memberName;
        this.workouts=workouts;
    }
}