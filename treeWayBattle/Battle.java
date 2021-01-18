package treeWayBattle;

public class Battle {
    public static void main(String[] args) {
        int [][] arr = new int[6][3];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{1, 3, 2};
        arr[2] = new int[]{2, 1, 3};
        arr[3] = new int[]{2, 3, 1};
        arr[4] = new int[]{3, 2, 1};
        arr[5] = new int[]{3, 1, 2};


        int res = battle(arr[(int)(Math.random()*6)]);
        int [] win = new int[3];
        win[res]++;
    }

    public static int battle(int [] order){




        return 0;

    }
}
