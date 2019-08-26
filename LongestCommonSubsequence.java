import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int getCountLCS(String s1, String s2) {
        // Swap the strings inside the matrix size or
        // swap the input in order to get same matrix
        // first input Column mai aata hai
        // second input Row mai aata hai
        
        int matrix [][] = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                }
                else {
                    matrix[i + 1][j + 1] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }

        /*
        int j = s1.length();
        //Printing the subsequence
        for(int i = s2.length(); i > 0; i--) {
            if(s1.charAt(j-1) == s2.charAt(i-1)) {
                System.out.print(s1.charAt(j-1));
                j--;
                continue;
            }
            else {
                if(matrix[i][j-1] > matrix[i-1][j]) {
                    i++;
                    j--;
                    continue;
                }
                else {
                    continue;
                }
            }
        }
`*/
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[s1.length()][s2.length()];

    }
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the first string");
            String s1 = scanner.next();

            System.out.println("Enter the second string");
            String s2 = scanner.next();

            System.out.println("The length of Common Subsequence is: " + getCountLCS(s1, s2));

        }

    }

}