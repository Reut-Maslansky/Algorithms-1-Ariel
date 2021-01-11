package NumbersGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dynamic {
    public static void main(String[] args) {
//        example of the class
        int[] arr = new int[6];
        arr[0]=1;
        arr[1]=3;
        arr[2]=6;
        arr[3]=1;
        arr[4]=3;
        arr[5]=6;
        System.out.println(Arrays.toString(arr));
        int[][] help = createHelpArr(arr);
        for(int i=0; i<help[0].length; i++){
            for(int j=0; j<help.length; j++){
                if(j==0) System.out.println();
                System.out.print("  "+help[i][j]);
            }
        }
        System.out.println();
        System.out.println("the max profit is: "+help[0][arr.length-1]);

        System.out.println("=======================");
        System.out.println("        RANDOM");
        System.out.println("=======================");
        Random rd = new Random();
        int n = 1;
        while (n % 2 == 1)
            n = rd.nextInt(30);

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        int[][] helpRand = createHelpArr(array);
        for(int i=0; i<helpRand[0].length; i++){
            for(int j=0; j<helpRand.length; j++){
                if(j==0) System.out.println();
                System.out.print("  "+helpRand[i][j]);
            }
        }
        System.out.println();
        System.out.println("the max profit is: "+helpRand[0][array.length-1]);
    }

    static int[][] createHelpArr(int[] origin_arr) {
        int[][] help = new int[origin_arr.length][origin_arr.length];
        for (int i=0; i<origin_arr.length; i++)
            help[i][i]=origin_arr[i];
        for(int i=origin_arr.length-2; i>=0; i--){
            for(int j=i+1; j<origin_arr.length; j++){
                help[i][j]=Math.max(origin_arr[i]-help[i+1][j],origin_arr[j]-help[i][j-1]);
            }
        }
            return help;
    }
}
