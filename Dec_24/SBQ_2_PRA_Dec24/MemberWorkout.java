import java.util.*;

class Workout{
    int wCode;
    String wName;
    double calBurned;
    Workout(int id,String n,double cal){
        wCode=id;
        wName=n;
        calBurned=cal;
    }
}
class Member{
    int mCode;
    String mName;
    List<Workout> mWorkouts;
    Member(int id, String n, List<Workout> w){
        mCode=id;
        mName=n;
        mWorkouts=w;
    }
}
public class MemberWorkout {
    public static Member f1(List<Member> Members,int actCode){
        Member tmp = null;
        double maxCal = 0;
        for(Member M: Members){
            for(Workout W: M.mWorkouts){
                if(W.wCode==actCode){
                    if(tmp==null || W.calBurned>maxCal){
                        maxCal = W.calBurned;
                        tmp = M;
                    }
                }
            }
        }
        return tmp;
    }
    public static List<String> f2(List<Member> Members, double thresh){
        Set<String> res = new LinkedHashSet<>();
        for(Member M : Members){
            for(Workout W: M.mWorkouts){
                if(W.calBurned>thresh){
                    res.add(W.wName);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        List<Member> Members = new ArrayList<>();
        int n = SC.nextInt();SC.nextLine();
        for(int i=0;i<n;i++){
            int mid = SC.nextInt();SC.nextLine();
            String mN = SC.nextLine();
            int nW = SC.nextInt();SC.nextLine();
            List<Workout> mW = new ArrayList<>();
            for(int j=0;j<nW;j++){
                int wC = SC.nextInt();SC.nextLine();
                String wN = SC.nextLine();
                int cal = SC.nextInt();SC.nextLine();
                mW.add(new Workout(wC,wN,cal));
            }
            Members.add(new Member(mid,mN,mW));
        }
        int sActCode = SC.nextInt();SC.nextLine();
        double threshold = SC.nextDouble();

        Member res1 = f1(Members, sActCode);
        List<String> res2 = f2(Members, threshold);

        if(res1!=null){
            System.out.println("Most calories burned in activity "+sActCode+" : "+res1.mName);
        }else{
            System.out.println("No members found for activity "+sActCode);
        }

        if(!res2.isEmpty()){
            System.out.println("Activities with calories above "+threshold+" : ");
            for(String s : res2){
                System.out.println(s);
            }
        }else{
            System.out.println("No activities found above the threshold.");
        }
    }
}
