import java.util.Scanner;
import java.util.*;


class ColletionsDemo {
    public static void main(String ... args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(computeSum(arr));


    }

    public static int computeSum(int arr[]) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int element : arr) {
            if(hm.containsKey(element)) {
                int count = hm.get(element);
                hm.replace(element, count + 1);
            }
            else 
                hm.put(element, 1);
        }

        System.out.println(hm);
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if(entry.getValue() % 2 != 0) {
                    sum += entry.getKey();

                }
            }
        return sum;
    }
}