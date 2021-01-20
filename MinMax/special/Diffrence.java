package MinMax.special;

public class Diffrence {

    public static void main(String[] args) {

        int[] A = {1, 3, -3, 5, -2, 100, 10};
        System.out.print("The maximum difference is " + diff(A));
    }

    // Function to calculate maximum difference between two elements in the
    // array such that smaller element appears before the larger element
    public static int diff(int[] A) {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
        int max_so_far = A[n - 1];
        int indexMax = -1, indexMin = -1;

        // traverse the array from right and keep track the maximum element
        for (int i = n - 2; i >= 0; i--) {
            // update max if current element is greater than the max element
            if (A[i] > max_so_far) {
                max_so_far = A[i];
                indexMax = i;
            }
            // if the current element is less than the maximum element,
            // then update the difference if required
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
                if (diff == max_so_far - A[i]) indexMin = i;
            }
        }
        System.out.println("min " + indexMin + " max " + indexMax);

        // return difference
        return diff;
    }
}

