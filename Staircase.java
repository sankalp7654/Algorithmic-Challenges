import java.util.*;

public class Staircase {

    public static ArrayList<Integer> track = new ArrayList<>();

    public static int getSteps(int n, int[] stepsVariation) {
        if(n == 0)
            return 1;

        if(stepsVariation.length == 0)
            return 0;
        
        if(n < 0) {
            return 0;
        }

        int op1 = getSteps(n - stepsVariation[0], stepsVariation);
        int op2 = getSteps(n, Arrays.copyOfRange(stepsVariation, 1, stepsVariation.length));
        return op1 + op2;
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            //System.out.println("Enter the steps in staircase");
            int steps = 12;

           // System.out.println("Enter the variety of steps");
            int variety = 3;

            int stepsVariation[] = {1, 2, 3};

            // for(int i = 0; i < variety; i++) {
            //     stepsVariation[i] = scanner.nextInt();
            // }

        
            System.out.println("The possiblities are: " + getSteps(steps, stepsVariation));

            

        }
        
    }

}