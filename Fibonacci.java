import java.util.Scanner;
import java.util.Arrays;

public class Fibonacci {
   
    /*
        Most important functions
        Arrays.sort()
        Arrays.fill(myArray, value)
        Arrays.copyOfRange(myArray, start, end)
    */

    public static long[] memoizedArray;
    public static long computeFib(int number) {
        if(number <= 1) {
            return number;
        }
        if(memoizedArray[number] > 0)
            return memoizedArray[number];

        long value = computeFib(number-1) + computeFib(number-2);
        memoizedArray[number] = value;
        return value;
    }
    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number");
            int number = scanner.nextInt();
        
            memoizedArray = new long[number+1];
            Arrays.fill(memoizedArray, -1l);

            System.out.println("The fibonacci number is: " + computeFib(number));
        }
    }
}