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
        int firstFloor = 0, lastFloor = 0;

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
                    if (Math.max(arr[i - 1][p - 1], arr[i][j - p]) + 1 <= min) {
                        if (i == k && j == n) {
                            lastFloor = p;
                        }
                        if (Math.max(arr[i - 1][p - 1], arr[i][j - p]) + 1 < min) {
                            min = Math.max(arr[i - 1][p - 1], arr[i][j - p]) + 1;
                            if (i == k && j == n) {
                                firstFloor = p;
                            }
                        }
                    }
                }

                arr[i][j] = min;

            }
        }
        System.out.println("first floor " + firstFloor + "-" + lastFloor);
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        //  System.out.println(Arrays.toString(arr[3]));
        return arr[k][n];
    }
}
