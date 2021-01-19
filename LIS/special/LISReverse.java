package LIS.special;

import java.util.Arrays;

public class LISReverse {

    public static void main(String[] args) {
        int[] x = {1, 7, 9, 50, 2, 3, 4, 5};
        System.out.println(ReverseLen(reverse(x)));
    }

    private static int ReverseLen(int[] x) {
        int [] help= new int[x.length];
        int [] rev= reverse(x);
        int index=1;
        help[0]=x[0];
        for(int i=1; i<x.length; i++){
            if(rev[i]>help[index])
                help[++index]=rev[i];
            else{
                int temp= Arrays.binarySearch(help, 0, index, rev[i]);
                if(temp<0) temp=-temp-1;
                help[temp]=rev[i];
            }
        }
        return index;
    }

    private static int[] reverse(int[] x) {
        int [] rev= new int[x.length];
        for(int i=0; i<x.length; i++){
            rev[x.length-1-i]=x[i];
        }
        return rev;
    }


}
