package LIS;

import java.util.Arrays;

public class LISDynamic {
    public static void main(String[] args) {
        int[] x = {1, 7, 9, 50, 2, 3, 4, 5};
        int lenPath = dynamicLen(x);
        int [] ans = LISDynamic(x);
        System.out.println(lenPath);
        System.out.println(Arrays.toString(ans));

    }


    public static int[] LISDynamic(int[] arr) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(mat,len,arr[i]);
            mat[index][index] = arr[i];
            if(index == len) len++;
            copy(mat,index);
        }
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[len-1][i];
        }
        return ans;
    }

    private static void copy(int[][] mat, int index) {
        for (int i = 0; i < index; i++) {
            mat[index][i] = mat[index-1][i];
        }
    }

    private static int binarySearchBetween(int[][] mat, int end, int v) {
        if(v > mat[end-1][end-1]) return end;
        if(v < mat[0][0]) return 0;
        int high = end, low = 0;
        while(low <= high) {
            if(low == high)return low;
            int mid = (low + high)/2;
            if(mat[mid][mid] == v) return mid;
            if(mat[mid][mid] > v) high = mid;
            else low = mid+1;
        }
        return -1;
    }


    private static int dynamicLen(int[] x) {
        int index = 0;
        int[] help = new int[x.length];

        for (int j : x) {
            if (j > help[index]) {
                help[++index] = j;
            } else {
                help[binarySearchLen(help, j, index)] = j;
            }
        }


        return index;
    }

    private static int binarySearchLen(int[] help, int key, int index) {

        int low = 0;
        int high = index;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (help[middle] > key && middle>0 && help[middle-1] < key) {
                return middle;

            }
            if (help[middle] < key) {
                low = middle + 1;

            }
            if (help[middle] > key) {
                high = middle - 1;

            }

        }
        return index;

    }

}

