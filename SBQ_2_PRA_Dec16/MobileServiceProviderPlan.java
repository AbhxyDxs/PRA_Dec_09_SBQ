import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

class Plan{
	int planID;
	String planName;
	double planPrice;
	Plan(int id, String name,double price){
		planID = id;
		planName = name;
		planPrice = price;
	}
}
class ServiceProvider{
	int spID;
	String spName;
	List<Plan> spPlans;
	public ServiceProvider(int id, String name, List<Plan> plans) {
		spID = id;
		spName = name;
		spPlans = plans;
	}
}
class Mobile {
	int mobileID;
	String mobileBrand;
	double mobilePrice;
	List<ServiceProvider> mobileSP;
	Mobile(int id, String b, double p, List<ServiceProvider> sp){
		mobileID = id;
		mobileBrand = b;
		mobilePrice = p;
		mobileSP = sp;
	}
}
class MobileService{
	public List<String> getMobileBrandWithPlansGreaterThanNThreshold(List<Mobile> M,int t) {
//		ArrayList<String> brands = new ArrayList<String>();
		//used set, so even if multiple service providers meets the threshold brands won't be added multiple times!
		Set<String> brands = new HashSet<>();
		for (Mobile Mob : M) {
		    for (ServiceProvider ServP : Mob.mobileSP) {
		        if (ServP.spPlans.size() >= t) {
		            brands.add(Mob.mobileBrand);
		            break;
		        }
		    }
		}
		return new ArrayList<>(brands);
	}
	public Map<String, List<Plan>> groupPlansBasedOnServiceProvider(List<Mobile> M) {
        LinkedHashMap<String, List<Plan>> grpPlans = new LinkedHashMap<>();
        for (Mobile Mob : M) {
            for (ServiceProvider ServP : Mob.mobileSP) {
                if (!grpPlans.containsKey(ServP.spName)) {
                    grpPlans.put(ServP.spName, new ArrayList<>(ServP.spPlans));
                } else {
                    for (Plan plan : ServP.spPlans) {
                        if (!grpPlans.get(ServP.spName).contains(plan)) {
                            grpPlans.get(ServP.spName).add(plan);
                        }
                    }
                }
            }
        }
        return grpPlans;
	}
}
public class MobileServiceProviderPlan {
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Enter No of Mobiles: ");
		int n = SC.nextInt();SC.nextLine();
		List<Mobile> M = new ArrayList<Mobile>();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Mobile ID: ");
			int mID = SC.nextInt();SC.nextLine();
			System.out.println("Enter Mobile Brand: ");
			String mB = SC.nextLine();
			System.out.println("Enter Mobile Price: ");
			double mP = SC.nextDouble();SC.nextLine();
			System.out.println("Enter No of Service Providers: ");
			int nSP = SC.nextInt();SC.nextLine();
			ArrayList<ServiceProvider> SP = new ArrayList<ServiceProvider>();
			for(int j=0;j<nSP;j++) {
				System.out.println("Enter Service Provider ID: ");
				int spID = SC.nextInt();SC.nextLine();
				System.out.println("Enter Service Provider Name: ");
				String spN = SC.nextLine();
				System.out.println("Enter No of Plans: ");
				int nP = SC.nextInt();SC.nextLine();
				ArrayList<Plan> P = new ArrayList<Plan>();
				for(int k=0;k<nP;k++) {
					System.out.println("Enter Plan ID: ");
					int pID = SC.nextInt();SC.nextLine();
					System.out.println("Enter Plan Name: ");
					String pN = SC.nextLine();
					System.out.println("Enter Plan Price: ");
					double pP = SC.nextDouble();SC.nextLine();
					Plan p = new Plan(pID, pN, pP);
					P.add(p);
				}
				ServiceProvider sp = new ServiceProvider(spID, spN, P);
				SP.add(sp);
			}
			Mobile m = new Mobile(mID, mB, mP, SP);
			M.add(m);
			System.out.println("Enter Threshold for Plans: ");
			int t = SC.nextInt();SC.nextLine();
			
			MobileService MS = new MobileService();
			List<String> res1 = MS.getMobileBrandWithPlansGreaterThanNThreshold(M, t);
			Map<String, List<Plan>> res2 = MS.groupPlansBasedOnServiceProvider(M);
			
			if(!res1.isEmpty()) {
				System.out.println("Brands with Plans >= "+t);
				System.out.println(String.join(", ", res1));
			}else {
				System.out.println("No Brands for the Plan Threshold!");
			}
			if(!res2.isEmpty()) {
				res2.forEach((servP,plan) -> {
					System.out.println("Service Provider: "+servP);
					for(Plan p:plan) {
						System.out.println("--"+p.planName+" : "+p.planPrice+" Rs");
					}
				});
			}else {
				System.out.println("No Plans and Service Providers!");
			}
		}
	}
}
