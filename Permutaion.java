import java.util.*;

class Permutation {

    public static int length;

    public static void permute(int l, char [] arr) {
        if (l == length) {
            for(char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }

        for(int i = l; i < length; i++) {
            swap(i, l, arr);
            permute(l+1, arr);
            swap(i, l, arr);
        }
    }

    public static char[] result ;
    public static void sankalpPermute(char arr[], int l, char result[]) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char key: arr) {
            map.compute(key, (k, value)-> {
                if(value == null) {
                    return 1;
                } else 
                return value + 1;
            });
        }

        result[l] = arr[l];
        



        
    }

    public static void swap(int l, int i, char [] arr) {
        char temp = arr[i];
        arr[i] = arr[l];
        arr[l] = temp;
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the String");
            String string = scanner.next();
            char arr[] = string.toCharArray();
            System.out.println("Permutations are: ");
            length = arr.length;
            result = new char[length];
            //permute(0, arr);
            sankalpPermute(arr, 0);
        }
    }
}