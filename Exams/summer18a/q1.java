package Exams.summer18a;

import java.util.Arrays;

public class q1 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 3, 15, 9};
        int max = LIS(arr);
        int[] maxArr = LISArray(arr);
        System.out.println(max);
        System.out.println(Arrays.toString(maxArr));
        int[] array = {1, 4, 3, 5, 7, 10, 8, 13, 16};
    }

    private static int[] LISArray(int[] arr) {
        int n = arr.length;
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);

        int[][] help = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    help[i][j] = 0;
                else {
                    if (arr[i - 1] == sorted[j - 1])
                        help[i][j] = help[i - 1][j - 1] + 1;
                    else help[i][j] = Math.max(help[i][j - 1], help[i - 1][j]);
                }
            }
        }

        int[] ans = new int[help[n][n]];
        int i = n, j = n, index = help[n][n] - 1;

        while (help[i][j] > 0) {
            if (arr[i - 1] == sorted[j - 1]) {
                ans[index--] = arr[i - 1];
                i--;
                j--;
            } else if (help[i - 1][j] > help[i][j - 1])
                i--;
            else j--;
        }

        return ans;
    }

    private static int LIS(int[] arr) {
        int[] help = new int[arr.length];
        int index = 0;
        help[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > help[index]) help[++index] = arr[i];
            else {
                int temp = Arrays.binarySearch(help, 0, index, arr[i]);
                if (temp < 0) {
                    temp = -temp - 1;
                    help[temp] = arr[i];
                }

            }
        }

        return index + 1;
    }
}