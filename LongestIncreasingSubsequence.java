import java.util.Arrays;
import java.util.stream.*;
public class LongestIncreasingSubsequence {

    public static void lis(int [] arr) {
        int temp[] = new int[arr.length];
        Arrays.fill(temp, 1);

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(arr[j] < arr[i]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
                if(i == j) {
                    break;
                }
            }
        }

        for(int element : temp) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("The longest increasing subsequence is of length: " + temp[temp.length - 1]);
    }

    public static void main(String[] args) {
    
        int array[] = {3, 1, 2, 7, 3, 9};
        lis(array);
        
    }
}