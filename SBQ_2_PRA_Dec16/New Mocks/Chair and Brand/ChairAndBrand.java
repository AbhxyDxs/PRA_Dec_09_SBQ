import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Brand{
	int brandID;
	String brandName;
	double brandRating;
	Brand(int id, String name, double r){
		brandID = id;
		brandName = name;
		brandRating = r;
	}
}
class Chair{
	int chairID;
	String chairType;
	double chairPrice;
	Brand chairBrand;
	Chair(int id, String type, double p, Brand b){
		chairID = id;
		chairType = type;
		chairPrice = p;
		chairBrand = b;
	}
}
public class ChairAndBrand {
	public static Chair findMostExpensiveChairDetails(List<Chair> C, String sBrand) {
		//We just want Chair with highest price, so no need to sort
//		ArrayList<Chair> expChairs = new ArrayList<Chair>();
//		for(Chair c:C) {
//			if(c.chairBrand.brandName.equalsIgnoreCase(sBrand)) {
//				expChairs.add(c);
//			}
//		}
//		expChairs.sort((O1,O2)-> Double.compare(O1.chairPrice, O2.chairPrice));
//		return expChairs.get(expChairs.size()-1);
		Chair xChair = null;
        for (Chair c : C) {
            if (c.chairBrand.brandName.equalsIgnoreCase(sBrand)) {
                if (xChair == null || c.chairPrice > xChair.chairPrice) {
                	xChair = c;
                }
            }
        }
        return xChair;
	}
	public static ArrayList<Chair> calculateDiscountPrice(List<Chair> C,String b,double percentage) {
		ArrayList<Chair> newChairs = new ArrayList<Chair>();
		for(Chair c:C) {
			if(c.chairBrand.brandName.equalsIgnoreCase(b)) {
				Chair cNew = c;
				double price = ((100-percentage)*c.chairPrice)/100;
				cNew.chairPrice = price;
				newChairs.add(cNew);
			}
		}
		return newChairs;
	}
	
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Enter No of Chairs: ");
		int n = SC.nextInt();SC.nextLine();
		ArrayList<Chair> C = new ArrayList<Chair>();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Chair ID: ");
			int cid = SC.nextInt();SC.nextLine();
			System.out.println("Enter Chair Type: ");
			String cT = SC.nextLine();
			System.out.println("Enter Chair Price: ");
			double cP = SC.nextDouble();SC.nextLine();
			System.out.println("Enter Brand ID: ");
			int bid = SC.nextInt();SC.nextLine();
			System.out.println("Enter Brand Name: ");
			String bN = SC.nextLine();
			System.out.println("Enter Brand Rating: ");
			double bR = SC.nextDouble();SC.nextLine();
			Brand b = new Brand(bid, bN, bR);
			Chair c = new Chair(cid, cT, cP, b);
			C.add(c);
		}
		System.out.println("Enter Brand to Search: ");
		String sB1 = SC.nextLine();
		System.out.println("Enter Brand to Give Discount: ");
		String sB2 = SC.nextLine();
		System.out.println("Enter Discount Percentage: ");
		double dP = SC.nextDouble();SC.nextLine();
		Chair res1 = findMostExpensiveChairDetails(C, sB1);
		ArrayList<Chair> res2 = calculateDiscountPrice(C, sB2, dP);
		if(res1!=null) {
			System.out.println("Most Expensive Chair: "+res1.chairType+" (Rs. "+res1.chairPrice+") by Brand: "+res1.chairBrand.brandName);;
		}else {
			System.out.println("matching brand is not available in the list!");
		}
		if(!res2.isEmpty()) {
			System.out.println("Discounted "+sB2+" Chairs: ");
			for(Chair ch: res2) {
				System.out.println("Brand Name: "+ch.chairBrand.brandName+", Type: "+ch.chairType+", Updated Price: "+ch.chairPrice);
			}
		}else {
			System.out.println("Discounted chairs are unavailable in the given brand!");
		}
	}
}
