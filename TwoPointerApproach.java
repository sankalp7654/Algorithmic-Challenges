import java.util.Random;

/*
    TODO: Find the total pairs which adds up to a number 'k'
    Given: The value of 'k' and an array.
    Condition: The Array must be SORTED in ascending order.
    Algorithm:
    1) Make use of two pointers i and j
        i points to the starting index of the array
        j points to the ending of the array
    2) find sum = (arr[i] + arr[j])
        if(sum == k)
            print the pairs
        else if(sum > k)
            decrement the the value of (j) by 1
        else 
            decrement the value of (i) by 1
*/

public class TwoPointerApproach {

    public static void main(String[] args) {
        
        int arr[] = new int[10];
        for(int i = 0; i < arr.length; i++)
            arr[i] = 10 + i + 1;

        System.out.print("The array is: ");
        for(int element:arr)
            System.out.print(element + " ");
        System.out.println();

        int k = 30;
        
        int i = 0;
        int j = arr.length-1;

        while(i < j) {
            int sum = arr[i] + arr[j];
            if(sum == k) {
                System.out.print("Pairs: " + arr[i] + " " + arr[j]);
                System.out.println();
                i++; 
                j--;
            }
            else if(sum > k) {
                j--;
            }
            else {
                i++;
            }
        }
    }
}