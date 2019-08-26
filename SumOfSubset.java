
import java.util.*;

public class SumOfSubset {

    public static int count = 0;

    static void subset(ArrayList<Integer> originalSet, ArrayList<Integer> mat, int sum) {
        subsetUtils(originalSet, mat, sum);
    }

    static void subsetUtils(ArrayList<Integer> originalSet, ArrayList<Integer> mat, int sum) {

        if(sum == 0) {
            count++;
            return;
        }

        if(originalSet.size() == 0)
            return;

        if(sum < 0) {
            return;
        }

        for(int i = 0; i < originalSet.size(); i++) {
            int ele = originalSet.remove(i);
            subsetUtils(originalSet, mat, sum-ele);
            originalSet.add(i, ele);
        }
    }

    public static void main(String[] args) {
        
        int sum = 6;
        ArrayList<Integer> originalSet = new ArrayList<Integer>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);
        

        ArrayList<Integer> mat = new ArrayList<Integer>();
        for(int i = 0; i < originalSet.size(); i++)  {
            mat.add(0);
        }

        //System.out.println(mat);
        //System.out.println(originalSet);
        

        subset(originalSet, mat, sum);

        System.out.println("Subsets possible: " + count);

        System.out.println(Integer.parseInt("10001", 2));


    }
}