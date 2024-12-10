import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Dish {
    private int dishID;
    private String dishName;
    private int preparingTime;
    private double dishPrice;

    public Dish(int dishID, String dishName, int preparingTime, double dishPrice) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.preparingTime = preparingTime;
        this.dishPrice = dishPrice;
    }

    public int getDishID() {
        return dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public int getPreparingTime() {
        return preparingTime;
    }

    public double getDishPrice() {
        return dishPrice;
    }
}

class Chef {
    private int chefID;
    private String chefName;
    private List<Dish> chefDishes;

    public Chef(int chefID, String chefName, List<Dish> chefDishes) {
        this.chefID = chefID;
        this.chefName = chefName;
        this.chefDishes = chefDishes;
    }

    public String getChefName() {
        return chefName;
    }

    public List<Dish> getChefDishes() {
        return chefDishes;
    }
}

class FestivalService {
    public List<String> searchDishesByChefInitial(List<Chef> chefs, char initial) {
        List<String> dishesByChef = new ArrayList<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (Chef C : chefs) {
            if (C.getChefName().charAt(0) == initial) {
                for (Dish tmpDish : C.getChefDishes()) {
                    int vCount = 0;
                    for (char x : tmpDish.getDishName().toCharArray()) {
                        if (vowels.contains(Character.toLowerCase(x))) {
                            vCount++;
                        }
                    }
                    if (vCount > 2) {
                        dishesByChef.add(tmpDish.getDishName());
                    }
                }
            }
        }
        return dishesByChef;
    }

    public Map<String, List<Dish>> dishesOfChefs(List<Chef> chefs) {
        Map<String, List<Dish>> chefsAndDishes = new TreeMap<>();
        for (Chef C : chefs) {
            chefsAndDishes.put(C.getChefName(), C.getChefDishes());
        }
        return chefsAndDishes;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        System.out.println("Enter No of Chefs: ");
        int n = SC.nextInt();
        SC.nextLine();
        List<Chef> Chefs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Chef ID: ");
            int cID = SC.nextInt();
            SC.nextLine();
            System.out.println("Enter Chef Name: ");
            String cName = SC.nextLine();
            System.out.println("Enter No of Dishes: ");
            int nDishes = SC.nextInt();
            SC.nextLine();

            List<Dish> Dishes = new ArrayList<>();
            for (int j = 0; j < nDishes; j++) {
                System.out.println("Enter Dish ID: ");
                int dID = SC.nextInt();
                SC.nextLine();
                System.out.println("Enter Dish Name: ");
                String dName = SC.nextLine();
                System.out.println("Enter Preparation Time: ");
                int pTime = SC.nextInt();
                SC.nextLine();
                System.out.println("Enter Dish Price: ");
                double dishPrice = SC.nextDouble();
                SC.nextLine();

                Dishes.add(new Dish(dID, dName, pTime, dishPrice));
            }
            Chefs.add(new Chef(cID, cName, Dishes));
        }

        System.out.println("Enter Chef Initial to Search: ");
        char sInitial = SC.next().charAt(0);

        FestivalService FS = new FestivalService();
        List<String> res1 = FS.searchDishesByChefInitial(Chefs, sInitial);
        Map<String, List<Dish>> res2 = FS.dishesOfChefs(Chefs);

        if (res1.isEmpty()) {
            System.out.println("No such dishes with more than 2 vowels in name for given chef initial.");
        } else {
            System.out.println("Dishes: " + String.join(", ", res1));
        }

        res2.forEach((chefName, dishes) -> {
            System.out.println("Chef: " + chefName);
            for (Dish dish : dishes) {
                System.out.println("  Dish ID: " + dish.getDishID());
                System.out.println("  Dish Name: " + dish.getDishName());
                System.out.println("  Preparation Time: " + dish.getPreparingTime());
                System.out.println("  Price: " + dish.getDishPrice());
            }
        });

        SC.close();
    }
}
