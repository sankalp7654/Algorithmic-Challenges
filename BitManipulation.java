import java.util.*;

public class BitManipulation {

    public static ArrayList<Integer> convertToBinary(int number) {

        if(number == 0) {
            System.out.println("Can't be converted");
            return new ArrayList<>();
        }

        int temp = number;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(temp != 0) {
            result.add(temp%2);
            temp = temp/2;
        }
        Collections.reverse(result);
        return result;
    }

    public static boolean checkIsPowerOfTwo(ArrayList<Integer> bits) {

        // if the LSB bit is 1 then number is not the power of 2
        if(bits.size() == 1) {
            return false;
        }

        int count = 0;
        for(int i = 0; i < bits.size(); i++) {
            if(bits.get(i) == 1) {
                count ++;

                if(count > 1)
                    return false;
            }
        }
        return true;
    }

    // to check whether the ith bit is set in number or not
    // just perform an AND operation with the number and the 2 to the power of i
    public static void checkIthBitIsSet(int number, int iBit) {
        if(number == 7) {
            System.out.println("ith bit is set");
            return ;
        }
        System.out.println("ith bit is set");
    }

    public static void main(String[] args) {
        
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        ArrayList<Integer> bits = convertToBinary(number);
        System.out.println(bits);

        System.out.println("Power of 2: " + checkIsPowerOfTwo(bits));

        System.out.println(Integer.toBinaryString(5));

        System.out.println(Integer.parseInt("A", 16));

    }
}