import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PowerSet p = new PowerSet();
        Scanner sc = new Scanner(System.in);
        String setString = sc.next().replaceAll("\\[|\\]", "");
        String[] rawSet = setString.split(",");
        String[] set = p.checkRepetition(rawSet);
        if (set[0] == "")
        {
            System.out.println("Power Set: [{}]");
        }
        else
        {
            System.out.print("Power Set: [");
            p.powerSet(set, 0, new String[set.length]);
            System.out.print("]");
        }
    }
}