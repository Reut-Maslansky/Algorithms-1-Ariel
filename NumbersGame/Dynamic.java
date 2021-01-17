package NumbersGame;

import java.util.Arrays;
import java.util.Random;

public class Dynamic {
    public static void main(String[] args) {
//        example of the class
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 6;
        arr[3] = 1;
        arr[4] = 3;
        arr[5] = 6;
        System.out.println(Arrays.toString(arr));
        int[][] help = createHelpArr(arr);
        for (int i = 0; i < help[0].length; i++) {
            System.out.println(Arrays.toString(help[i]));
        }
        System.out.println();
        System.out.println("the max profit is: " + help[0][arr.length - 1]);
        printGame(help);

        int[] array = createRandomArr(6);
        System.out.print(Arrays.toString(array) + "\n");

        int[][] helpRand = createHelpArr(array);
        for (int i = 0; i < helpRand[0].length; i++) {
            for (int j = 0; j < helpRand.length; j++) {
                if (j == 0) System.out.println();
            }
            System.out.print(Arrays.toString(helpRand[i]));
        }
        System.out.println();
        System.out.println("\nthe max profit is: " + helpRand[0][array.length - 1]);

        printGame(helpRand);
    }

    private static void printGame(int[][] help) {
        int i = 0, j = help.length - 1;
        String who = "";
        while (i != j) {
            if ((i+j)%2==1)
                who = "i take ";
            else who = "client take ";
            if (help[i][j] == help[i][i] - help[i + 1][j]) {

                System.out.println(who+help[i][i]);
                i++;
            } else {
                System.out.println(who+help[j][j]);
                j--;
            }
        }
        System.out.println("client take "+help[j][j]);

    }

    private static int[] createRandomArr(int n) {
        System.out.println("=======================");
        System.out.println("        RANDOM");
        System.out.println("=======================");
        Random rd = new Random();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(20);
        }
        return array;
    }

    static int[][] createHelpArr(int[] origin_arr) {
        int[][] help = new int[origin_arr.length][origin_arr.length];
        for (int i = 0; i < origin_arr.length; i++)
            help[i][i] = origin_arr[i];
        for (int i = origin_arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < origin_arr.length; j++) {
                help[i][j] = Math.max(origin_arr[i] - help[i + 1][j], origin_arr[j] - help[i][j - 1]);
            }
        }
        return help;
    }


}
