import java.util.*;

public class MergeSort {

    public static void mergeSort(int arr[], int start, int end) {
        if(start == end) {
            return;
        }

        int mid = (start + end) /2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int arr[], int start, int mid, int end) {

        int i = start, j = mid+1, k = start;
        int temp[] = new int[end + 1];

        while((i <= mid) && (j <= end)) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= end) {
            temp[k++] = arr[j++];
        }

        for(int c = start; c < end+1; c++) {
            arr[c] = temp[c];
        }
    }
    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of elements");
            int n = scanner.nextInt();

            int arr[] = new int[n];
            System.out.print("Enter " + n + " elements: ");
            for(int i = 0; i < n; i++) 
                arr[i] = scanner.nextInt();
    

            mergeSort(arr, 0, n-1);

            for(int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}