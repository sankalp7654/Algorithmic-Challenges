
public class MatrixLayerRotation {

    public static void rotateLayer(int matrix[][], int m, int n, int times) {
        int temp [][] = new int [m][n];

        while(--times >= 0) {
            int k = 0, l = 0, last_row = m-1, last_col = n-1;

            while((k <= last_row) && (l <= last_col)) {

                for(int i = l; i <= last_col; i++) {
                    if(i == last_col)
                        temp[k+1][l] = matrix[k][(i + l + 1)%(last_col+1)];
                    else 
                        temp[k][i] = matrix[k][(i + 1)%(last_col+ 1)];
                }
                k++;
    
                for(int i = k; i <= last_row; i++) {
                    temp[i-1][last_col] = matrix[i][last_col];
                }
                last_col--;
    
                for(int i = last_col; i >= l; i--) {
                    temp[last_row][i+1] = matrix[last_row][i];
                }
                last_row--;
    
                for(int i = last_row; i >= k; i--) {
                    temp[i+1][l] = matrix[i][l];
                }
                l++;

            }


            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = temp[i][j];
                }
            }
       }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        
    }


    public static void main(String[] args) {
        
        int k = 2;
        int matrix[][] = {  
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12}, 
                            {13, 14, 15, 16},
                            {17, 18, 19, 20}
                        };
        int m = matrix.length;
        int n = matrix[0].length;

        rotateLayer(matrix, m, n, k);

        

    }
}