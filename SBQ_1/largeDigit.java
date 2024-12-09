import java.util.Scanner;
import java.util.TreeSet;

public class largeDigit {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        System.out.println("Enter Number: ");
        int number = SC.nextInt(); SC.nextLine();

        TreeSet<Integer> digitSet = new TreeSet<>();
        //What about negative numbers? 
        int temp = Math.abs(number);
        
        while (temp > 0) {
            int digit = temp % 10;
            digitSet.add(digit);
            temp /= 10;
        }

        if (!digitSet.isEmpty()) {
            int ans = digitSet.last();
            System.out.println(ans);
        } else {
            System.out.println("NULL");
        }
    }
}
