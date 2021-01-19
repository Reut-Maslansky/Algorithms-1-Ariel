package LIS.special;

import java.util.Arrays;

public class Circle {
    public static void main(String[] args) {
        int [] temp = {6,58,2,3,4,61,1,60};
       System.out.println(Circle(temp));
    }

    static int Circle(int [] arr){
        int max=0;
        int index=0;
        for(int i=0; i<arr.length; i++){
            int temp=LISIndex(arr, i, i+arr.length);
            if(temp>max) {
                max=temp;
                index=i;
            }
        }
        System.out.println("index "+index);
        return max;
    }

    static int LISIndex(int [] arr, int start , int end){
        int [] temp = new int[arr.length];
        int index = 0;
        temp[0]=arr[start];
        for (int i = start+1;i<end;i++){
            if (arr[i%arr.length]>temp[index])
                temp[++index]=arr[i%arr.length];
            else {
                int newIndex = Arrays.binarySearch(temp,0,index,arr[i%arr.length]);
                if (newIndex<0)newIndex= -newIndex-1;
                temp[newIndex]=arr[i%arr.length];
            }
        }
        return index+1;
    }
}
