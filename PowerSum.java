import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PowerSum {

    public static TreeSet<ArrayList<Integer>> set = new TreeSet<ArrayList<Integer>>((a, b) -> {
        if(a.size() == b.size())
            for(int i = 0; i < a.size(); i++) {
                if(a.get(i) == b.get(i))
                    return 1;
            }
        return 0;
    });
    
    public static int count = 0;
    // Complete the powerSum function below.
    static int powerSum(int X, int N) {

        int maxVal = (int)Math.pow(X, 1.0/N);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i <= maxVal; i++)
            al.add(i);
        

        System.out.println(al);
        getSum(al, X, N);
        return count;
        
    }

    static void getSum(ArrayList<Integer> al, int X, int N) {
        if(X == 0) {
            count++;
            System.out.println(al);
            set.add(al);
            return;
        }
        System.out.println(X);

        if(al.size() == 0) {
            return;
        }
        if(X < 0) {
            return;
        }
        for(int i = 0; i < al.size(); i++) {
            int ele = al.remove(i);
            getSum(al, X-(int)(Math.pow(ele,N)), N);
            al.add(i, ele);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int X = 10;

        int N = 2;

        int result = powerSum(X, N);

        System.out.println(result);
        System.out.println(set);

        scanner.close();
    }
}
