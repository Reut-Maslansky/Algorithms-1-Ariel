package LIS;

import java.util.Arrays;

public class LISDynamicBinarySearchJava {

    public static void main(String[] args) {
        int[] x = {1, 7, 9, 50, 2, 3, 4, 5};
        System.out.println(Arrays.toString(LIS(x)));
    }

    static int[] LIS(int [] arr){
        int[] diagonal= new int[arr.length];
        int [][]help= new int[arr.length][arr.length];
        diagonal[0]=arr[0];
        help[0][0]=arr[0];
        int index=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]> diagonal[index]){
                index++;
                diagonal[index]=arr[i];
                help[index][index]=arr[i];
                for(int j=0; j<index; j++)
                help[index][j]=help[index-1][j];
            }
            else {
                int temp= Arrays.binarySearch(diagonal, 0, index, arr[i]);
                if(temp<0) temp=-temp-1;
                diagonal[temp]=arr[i];
                help[temp][temp]=arr[i];
                for(int j=1; j<temp; j++)
                    help[temp][j]=help[temp-1][j];
            }
        }
        return Arrays.copyOf(help[index], index+1);
    }

}
