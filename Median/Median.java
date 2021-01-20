package Median;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        double [] arr= new double[200];
        for(int i=0; i<arr.length; i++){
            arr[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(findBiggerThanMedian(arr));
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);
    }

    static double findBiggerThanMedian(double [] arr){
        int n=arr.length;
        int count=0;
        while(n>=2){
            n/=2;
            count++;
        }
        double max=Double.NEGATIVE_INFINITY;
        for(int i=0; i<count; i++){
            if(max<arr[i]) max=arr[i];
        }
        return max;
    }
}
