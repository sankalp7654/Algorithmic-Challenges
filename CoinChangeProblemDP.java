

public class CoinChangeProblemDP {

    public static void getNumberOfChanges(int [] coins, int change) {

        int m = coins.length+1;
        int n = change+1;

        int matrix[][] = new int [m][n];

        int count = 1;
        for(int i = 1; i < m; i++)
            matrix[0][i] = count;


        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(j > coins[i-1]) {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-coins[i-1]]+1);
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                    
                }
            }
        }

        for(int ma[]: matrix) {
            for(int v: ma) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        System.out.println(matrix[m-1][n-1]);
    }
    public static void main(String[] args) {
        
        int coins[] = {1, 2, 3};
        int change = 4;

        getNumberOfChanges(coins, change);
    }
}