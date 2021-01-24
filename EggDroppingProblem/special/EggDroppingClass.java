package EggDroppingProblem.special;

import java.util.Arrays;

public class EggDroppingClass {

    public static class Building {
        int breakFloor;
        int floors;

        public Building(int floors, int breakFloor) {
            this.breakFloor = breakFloor;
            this.floors = floors;
        }
    }

    public static void main(String[] args) {
        Building b = new Building(10, 8);
        System.out.println("The minimum dropping in the worse case you need is " + "\033[0;36m" + BestDropping(b.floors, 3) + "\033[0m drooping");
        HowDrop(b.floors, b.breakFloor, 3);
        Building c = new Building(100, 87);
        System.out.println("The minimum dropping in the worse case you need is " + "\033[0;36m" + BestDropping(c.floors, 2) + "\033[0m drooping");
        HowDrop(c.floors, c.breakFloor, 2);
        System.out.println(c.floors+ " floors, 2 balls: "+TwoBalls(c)+ " tries");
    }

    static void HowDrop(int floors, int breakFloor, int balls) {
        if (floors <= 0 || balls <= 0) return;
        int[][] help = new int[balls + 1][floors + 1];

        int firstFloor = 1;

        for (int i = 0; i < balls + 1; i++) {
            help[i][0] = 0;
            help[i][1] = 1;
            if (floors >= 2)
                help[i][2] = 2;
        }
        for (int j = 0; j < floors + 1; j++) {
            help[0][j] = 0;
            help[1][j] = j;
        }

        for (int i = 2; i < balls + 1; i++) {
            for (int j = 2; j < floors + 1; j++) {
                int min = floors + 1;
                for (int p = 1; p < j; p++) {
                    if (Math.max(help[i - 1][p - 1], help[i][j - p]) + 1 < min) {
                        min = Math.max(help[i - 1][p - 1], help[i][j - p]) + 1;
                        if (i == balls && j == floors) {
                            firstFloor = p;
                        }
                    }
                }
                help[i][j] = min;
            }
        }
        System.out.println("floors " + floors);
        System.out.println("first floor " + firstFloor);
        System.out.println("break floor " + breakFloor);
        if (firstFloor >= breakFloor) {
            System.out.println("\033[1;35m" + "ball " + balls + " break" + "\033[0m");
            if (firstFloor == breakFloor) {
                System.out.println("\033[0;33m" + "done!" + "\033[0m");
                return;
            }
            if (balls == 1) {
                System.out.println("\033[0;33m" + "done without winning" + "\033[0m");
                return;
            }
            floors = firstFloor - 1;

            HowDrop(floors, breakFloor, balls - 1);

        } else {
            System.out.println("\033[1;34m" + "ball " + balls + " not break" + "\033[0m");
            floors = floors - firstFloor;
            breakFloor = breakFloor - firstFloor;
            HowDrop(floors, breakFloor, balls);
        }
    }


    static int BestDropping(int floor, int balls) {

        int[][] help = new int[balls + 1][floor + 1];
        int firstFloor = 0, lastFloor = 0;

        for (int i = 0; i <= balls; i++) {
            help[i][0] = 0;
            help[i][1] = 1;
            if (floor >= 2)
                help[i][2] = 2;
        }

        for (int j = 0; j <= floor; j++) {
            help[0][j] = 0;
            help[1][j] = j;
        }

        for (int i = 2; i <= balls; i++) {
            for (int j = 2; j <= floor; j++) {
                int min = floor + 1;
                for (int p = 1; p < j; p++) {
                    if (Math.max(help[i - 1][p - 1], help[i][j - p]) + 1 <= min) {
                        if (i == balls && j == floor)
                            lastFloor = p;
                    }
                    if (Math.max(help[i - 1][p - 1], help[i][j - p]) + 1 < min) {
                        min = Math.max(help[i - 1][p - 1], help[i][j - p]) + 1;
                        if (i == balls && j == floor)
                            firstFloor = p;
                    }
                }
                help[i][j] = min;
            }
        }
        for (int i = 0; i < balls + 1; i++) {
            System.out.println(Arrays.toString(help[i]));
        }

        System.out.println("for the minimum dropping- start from: " + "\033[0;31m" + firstFloor + "-" + lastFloor + "\033[0m floors");
        return help[balls][floor];

    }


    static int TwoBalls(Building b) {
        int index = 0;
        int sum = 0;
        while (sum < b.floors) {
            sum += ++index;
        }
        int balls=2;
        int jump=0;
        int drop=0;
        while(balls>0){
            drop++;
            if(index+jump>=b.breakFloor){
                balls--;
                System.out.println("break 1 in "+ (index+jump) +" floor");
                for(int i=1+jump; i<index+jump && i<b.floors; i++){
                    drop++;
                    if(i==b.breakFloor) {
                        System.out.println("break 2 in " + i + " floor");
                        System.out.println("\033[0;33m" + "done!" + "\033[0m");
                        balls--;
                        break;
                    }
                }
            }
            else {
                jump+=index;
                index--;
            }
        }

        return drop;
    }


}

