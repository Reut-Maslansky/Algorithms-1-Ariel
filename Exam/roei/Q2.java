package Exam.roei;

public class Q2 {


    //O(n)
    public static int longestOfOne(int[] arr) {
        int ans = 0;
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                help[i] = arr[i];
            else if (arr[i] == 0)
                help[i] = 0;
            else {
                help[i] = help[i - 1] + 1;
                if (help[i] > ans)
                    ans = help[i];
            }

        }

        return ans;
    }

    //O(n*m)
    public static int imaginaryPlus(int[][] arr) {
        int[][] help = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1) {
                    help[i][j] = arr[i][j];
                } else {
                    int temp = up(arr, i, j) + down(arr, i, j) + left(arr, i, j) + right(arr, i, j);
                    help[i][j] = temp + 1;
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


