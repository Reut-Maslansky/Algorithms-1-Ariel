package LIS.special;

import java.util.Arrays;

public class UpAndDown {
    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 4, 1, 7, 10, 13, 0};
        System.out.println(getLBSLengthLogn(arr));
    }


    //- function to reverse an array
    static void revereseArr(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

//  - Returns length of longest Bitonic
//  ~ subsequence in O(n Log n) time.
    static int getLBSLengthLogn(int arr[]) {
        int n = arr.length;

//      Base Case:
        if (n == 0)
            return 0;

//      > Aux array storing the input array
//      > in same order to calculate LIS:
        int increasing[] = new int[n];

//      > to store lengths of IS
        int tail1[] = new int[n];

//      Aux array storing the input array
//      in reverse order to calculate LIS:
//      This will calculate Longest Decreasing
//      Subsequence which is required for
//      Longest Bitonic Subsequence*/
        int decreasing[] = new int[n];

        // To store lengths of DS
        int tail2[] = new int[n];

        // initializing first index same as
        // original array:
        increasing[0] = arr[0];

        // index in initialized as 1 from where
        // the remaining computations will be done
        int in = 1;

        // tail1 stores Longest Increasing
        // subsequence length values till index in
        tail1[0] = 0;

        // remaining computations to get the
        // LIS length for increasing
        for (int i = 1; i < n; i++) {
            if (arr[i] < increasing[0]) {
                increasing[0] = arr[i];
                tail1[i] = 0;
            } else if (arr[i] > increasing[in - 1]) {
                increasing[in++] = arr[i];
                tail1[i] = in - 1;
            } else {
                int getIndex1 = Arrays.binarySearch(increasing, 0, in, arr[i]);
                //? if the arr[i] not in increasing do nothing.
                if (getIndex1 <= -1)
                    continue;

                increasing[getIndex1] = arr[i];
                tail1[i] = getIndex1;
            }
        }

        // reinitializing the index to 1
        in = 1;

        // reversing the array to get the Longest
        // Decreasing Subsequence Length:
        revereseArr(arr);
        decreasing[0] = arr[0];
        tail2[0] = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < decreasing[0]) {
                decreasing[0] = arr[i];
                tail2[i] = 0;
            } else if (arr[i] > decreasing[in - 1]) {
                decreasing[in++] = arr[i];
                tail2[i] = in - 1;
            } else {
                int getIndex2 = Arrays.binarySearch(decreasing,0, in, arr[i]);
                if (getIndex2 <= -1)
                    continue;

                decreasing[getIndex2] = arr[i];
                tail2[i] = getIndex2;

            }
        }

        revereseArr(arr);
        revereseArr(tail2);

        // Longest Bitonic Subsequence length is
        // maximum of tail1[i] + tail2[i] + 1:
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < (tail1[i] + tail2[i] + 1))
                ans = (tail1[i] + tail2[i] + 1);
        }
        return ans;
    }
}
