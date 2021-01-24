package Exam.reut;

public class Q2 {

    public static int longestOfOne(int[] arr) {

        int[] help = new int[arr.length];
        int max = 0;
        if (arr[0] == 0) help[0] = 0;
        else {
            help[0] = 1;
            max = 1;
        }
        for (int i = 1; i < help.length; i++) {
            if (arr[i] == 0) help[i] = 0;
            else {
                help[i] = help[i - 1] + 1;
                if (max < help[i]) max = help[i];
            }
        }
        return max;
    }

    public static int imaginaryPlus(int[][] arr) {
        int[][] help = new int[arr.length][arr[0].length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) help[i][j] = 0;
                else {
                    help[i][j] = up(arr, i, j) + down(arr, i, j) + right(arr, i, j) + left(arr, i, j) + 1;
                    if (max < help[i][j]) max = help[i][j];
                }
            }
        }
        return max;
    }

    private static int up(int[][] arr, int i, int j) {
        int sum = 0;
        i--;
        while (i >= 0 && arr[i][j] != 0) {
            sum++;
            i--;
        }
        return sum;
    }

    private static int down(int[][] arr, int i, int j) {
        int sum = 0;
        i++;
        while (i < arr.length && arr[i][j] != 0) {
            sum++;
            i++;
        }
        return sum;
    }

    private static int right(int[][] arr, int i, int j) {
        int sum = 0;
        j++;
        while (j < arr[i].length && arr[i][j] != 0) {
            sum++;
            j++;
        }
        return sum;
    }

    private static int left(int[][] arr, int i, int j) {
        int sum = 0;
        j--;
        while (j >= 0 && arr[i][j] != 0) {
            sum++;
            j--;
        }
        return sum;
    }
}