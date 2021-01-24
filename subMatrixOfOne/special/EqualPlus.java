package subMatrixOfOne.special;

import java.util.Arrays;

public class EqualPlus {
    public static void main(String[] args) {
        int[][] matrix = createMatrix2();
        int ans = plus(matrix);
        System.out.println(ans);

    }

    private static int[][] createMatrix(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (int) (Math.random() * 2);
            }
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }

    private static int[][] createMatrix2() {
        int[][] m = {
                {1,0,1,1,1,1,0,1,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {0,0,0,0,1,0,0,1,0,0},
                {1,0,0,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,0},
                {1,0,0,0,1,0,0,1,0,1},
                {1,0,1,1,1,1,0,0,1,1},
                {1,1,0,0,1,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,0,0}};
        return m;
    }

    static int plus(int[][] arr) {
        int[][] help = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1) {
                    help[i][j] = arr[i][j];
                } else {
                    int min1 = up(arr, i, j)+ down(arr, i, j)+left(arr, i, j)+right(arr, i, j);
                    int min2 = Math.min(left(arr, i, j), right(arr, i, j));
                    help[i][j] = 4 * Math.min(min1, min2) + 1;
                }
            }
        }

        //max
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (help[i][j] > max) max = help[i][j];
            }

        }
        return max;
    }

    private static int up(int[][] arr, int i, int j) {
        int count = 0;
        i--;
        while (i >= 0 && arr[i][j] != 0) {
            count++;
            i--;
        }
        return count;
    }

    private static int down(int[][] arr, int i, int j) {
        int count = 0;
        i++;
        while (i < arr.length && arr[i][j] != 0) {
            count++;
            i++;
        }
        return count;
    }

    private static int right(int[][] arr, int i, int j) {
        int count = 0;
        j++;
        while (j < arr[0].length && arr[i][j] != 0) {
            count++;
            j++;
        }
        return count;
    }

    private static int left(int[][] arr, int i, int j) {
        int count = 0;
        j--;
        while (j >= 0 && arr[i][j] != 0) {
            count++;
            j--;
        }
        return count;
    }

}
