import java.util.Arrays;
import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Side 1: ");
        int a = sc.nextInt();
        System.out.print("Enter Side 2: ");
        int b = sc.nextInt();
        System.out.print("Enter Side 3: ");
        int c = sc.nextInt();

        int[] sides = {a, b, c};
        Arrays.sort(sides);

        if (sides[0] > 0 && sides[1] > 0 && sides[2] > 0) {
            if (sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2]) {
                System.out.println("Right Angled Triangle!");
            } else {
                System.out.println("Not a Right-Angled Triangle!");
            }
        } else {
            System.out.println("Not a valid triangle!");
        }
    }
}