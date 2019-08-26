import java.util.Arrays;

public class NextGreaterNumber {

    public static String nextGreaterNumber(char [] number) {

        int i;
        
        /*
         *  LOGIC:
         *  1) Traverse the array from the right to left
         *       untill (left number > right number)
         *       (ASCII value of character at left < right)
         *  2) Swap the left character with the last character
         *  3) Sort the character lexicographically fromleft+1 to right
         * 
         */

        for(i = number.length-1; i > 0 ; i--) {
            
            if(number[i] < number[i-1]) {
                continue;
            }
            char ch = number[i];
            number[i] = number[number.length-1];
            number[number.length-1] = ch;
            break;
        }
        Arrays.sort(number, i, number.length);

        return new String(number);
    }

    public static void main(String[] args) {
        
        String original = "4876";
        char[] number = original.toCharArray();

        String value = nextGreaterNumber(number);

        System.out.println("Next greater number for the number " + original + " is " + value);
    }
}