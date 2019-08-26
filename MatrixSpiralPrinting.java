
public class MatrixSpiralPrinting {

    public static void printSpiralLeftToRight(int matrix[][], int n ) {
        int k = 0, l = 0, last_row = n-1, last_col = n-1;

        while((k <= last_row) && (l <= last_col)) {
            for(int i = l; i <= last_col; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;

            for(int i = k; i <= last_row; i++) {
                System.out.print(matrix[i][last_col] + " ");
            }
            last_col--;

            for(int i = last_col; i >= l; i--) {
                System.out.print(matrix[last_row][i] + " ");
            }
            last_row--;

            for(int i = last_row; i >= k; i--) {
                System.out.print(matrix[i][l] + " ");
            }
            l++;
        }
    }

    public static void printSpiralTopToBottom(int matrix[][], int n) {
        int k = 0, l = 0, last_row = n-1, last_col = n-1;

        while((k <= last_row) && (l <= last_col)) {
            for(int i = k; i <= last_row; i++) {
                System.out.print(matrix[i][l] + " ");
            }
            l++;

            for(int i = l; i <= last_col; i++) {
                System.out.print(matrix[last_row][i] + " ");
            }
            last_row--;

            for(int i = last_row; i >= k; i--) {
                System.out.print(matrix[i][last_col] + " ");
            }
            last_col--;

            for(int i = last_col; i >= l; i--) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
        }
    }


    public static void main(String[] args) {
        
        int k = 2;
        int matrix[][] = {  
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12}, 
                            {13, 14, 15, 16} 
                        };

        System.out.println("The spiral from Left to Right is: ");
        printSpiralLeftToRight(matrix, 4);

        System.out.println();
        System.out.println("The spiral from Top to Bottom is: ");
        printSpiralTopToBottom(matrix, 4);

    }
}