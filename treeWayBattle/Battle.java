package treeWayBattle;

import java.util.Arrays;

public class Battle {
    public static void main(String[] args) {
        int[][] arr = new int[6][3];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{1, 3, 2};
        arr[2] = new int[]{2, 1, 3};
        arr[3] = new int[]{2, 3, 1};
        arr[4] = new int[]{3, 2, 1};
        arr[5] = new int[]{3, 1, 2};
        double[] win = new double[3];
int numOfGame = 50;
        for (int i = 0; i < numOfGame; i++) {
            int res = battle(arr[(int) (Math.random() * 6)]);
            win[res - 1]++;
        }
        System.out.println(Arrays.toString(win));
        System.out.println("player 1 - "+win[0]/numOfGame*100+"%");
        System.out.println("player 2 - "+win[1]/numOfGame*100+"%");
        System.out.println("player 3 - "+win[2]/numOfGame*100+"%");


    }

    public static int battle(int[] order) {
        boolean[] arr = {true, true, true};
        int lives = arr.length;
        int count = 0;
        while (lives > 1) {
            count++;
            for (int i = 0; i < order.length; i++) {
                if (arr[order[i]-1]) {
                    if (order[i] == 1) {
                        if (arr[1])
                            arr[1] = false;
                        else arr[2] = false;
                        lives--;
                    } else if (order[i] == 2) {
                        int rand = (int) (Math.random() * 10 + 1);
                        if (rand <= 8) {
                            if (arr[0])
                                arr[0] = false;
                            else arr[2] = false;
                            lives--;
                        }
                    } else {
                        if (lives == 2) {
                            int rand = (int) (Math.random() * 10 + 1);
                            if (rand <= 5) {
                                if (arr[0])
                                    arr[0] = false;
                                else arr[1] = false;
                                lives--;
                            }
                        }
                    }
                }
            }
        }
        if (arr[0])
            return 1;
        else if (arr[1])
            return 2;
        else return 3;

    }
}
