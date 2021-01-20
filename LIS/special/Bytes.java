package LIS.special;

import java.util.Arrays;

public class Bytes {
    public static void main(String[] args) {
        int[] arr={0,5,8,3,11,7,9,61};
        int[] brr={1,1,1,1,0,0,1,1};
        System.out.println(bytes(arr,brr));
    }
    static int bytes(int[]arr, int[]brr){

        int[] ans=new int[arr.length];
        int index=0;
        for(int i=0; i<arr.length;i++){
            if(brr[i]!=0){
                if(arr[i]>ans[index]){
                    ans[index++]=arr[i];
                }
                else{
                    int temp= Arrays.binarySearch(ans,0,index, arr[i]);
                    if(temp<0) temp=-temp-1;
                    ans[temp]=arr[i];
                }
            }
        }
        return index;
    }
}
