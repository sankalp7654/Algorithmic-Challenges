import java.util.*;

public class MatrixRecursion {

    public static int computeRowSum(int mat[], int sum, int index) {
        if(mat.length == 0) {
            return sum;
        }
        int newSum = mat[0] + sum;
        if(index > mat.length)
            return 0;
        return computeRowSum(Arrays.copyOfRange(mat, index+1, mat.length), newSum, index);
    }

    public static void main(String[] args) {
    
        int mat[][] = {{1, 2, 3},
                       {4, 5, 6}, 
                       {7, 8, 9}};

        System.out.println("The sum of the row1 is : " + computeRowSum(mat[0], 0, 0));

        int col1[] = new int[mat.length];
        for(int k = 0; k < col1.length; k++) {
            col1[k] = mat[k][0];
        }

        System.out.println("The sum of col1 is: " + computeRowSum(col1, 0, 0));

        
        int sum = 0;
        int j = mat.length-1;
        for(int i = 0; i < mat.length; i++) {
                sum += mat[i][j--];
        }
        System.out.println("The sum of right diagonal is: " + sum);

    }
}