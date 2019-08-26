import java.util.*;

public class Subarray {

    // This function does not print the duplicate values
    // because I've used temporary variable (l)
    // when this variable reaches the end of the input
    // the function() gets terminate
    // since there is a base case
    public static void subarray(ArrayList<Integer> al, int l) {
        System.out.println(al);
        if(1 == al.size()) 
        return;

        if(l > al.size())
            return;

        for(int i = l; i < al.size(); i++) {
            int ele = al.remove(i);
            subarray(al, i);
            al.add(i, ele);
        }
    }

    public static void sub(ArrayList<Integer> al) {
        System.out.println(al);
        if(0 == al.size()) 
        return;


        for(int i = 0; i < al.size(); i++) {
            int ele = al.remove(i);
            sub(al);
            al.add(i, ele);
        }
    }
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(1);
            al.add(2);
            al.add(3);

            //subarray(al, 0);
            //sub(al);
            
            
            
            
            /*  In this approach start with an empty list
             *  Traverse each element of the set from Left to Right
             *  While traversing add it to the list
             *  and after traversing remove the element from the list
             *  This strategy will remove the occurence of duplicate elements
                        
            */
            ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();
            computeSubset(subSets, new ArrayList<Integer>(), al, 0);
            System.out.println(subSets);

        }
    }

    // This is the Best Approach to compute the subset of any set
    public static void computeSubset(ArrayList<ArrayList<Integer>> subSets, ArrayList<Integer> result, ArrayList<Integer> al, int start) {
        
        if(start == result.size()-1)
            return ;

        subSets.add(new ArrayList<Integer>(result));
        System.out.println(result);
        

        for(int i = start; i < al.size(); i++) {
            result.add(al.get(i));
            computeSubset(subSets, result, al, i+1);
            result.remove(result.size()-1);
        }
    }
}