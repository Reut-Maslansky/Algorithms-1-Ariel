package EggDroppingProblem;

import java.util.Arrays;

public class k_n {

    public static void main(String[] args) {
        System.out.println(numberOfCheckingK(100, 2));
    }

    /**
     * מקרה כללי כאשר מספר הכדורים K<=n
     */
    static int numberOfCheckingK(int n, int k) {
        int[][] arr = new int[k + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            arr[0][j] = 0;
            arr[1][j] = j;
        }

        for (int i = 2; i <= k; i++) {
            arr[i][0] = 0;
            arr[i][1] = 1;
            if (n >= 2) {
                arr[i][2] = 2;
            }


            for (int j = 2; j <= n; j++) {
                int min = n + 1;
                for (int p = 1; p < j; p++) {
                    min = Math.min(Math.max(arr[i - 1][p - 1], arr[i][j - p]), min);
                }
                arr[i][j] = min + 1;

            }
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        return arr[k][n];
    }
}
