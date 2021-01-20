package EggDroppingProblem;

public class GlassBalls {
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= 10) System.out.print("[" + arr[i][j] + "]");
                else System.out.print("[ " + arr[i][j] + "]");

            }
            System.out.println("");
        }
    }

    public static class Building {

        int numberOfFloors;
        int breakFloor;

        public Building(int numberOfFloors, int breakFloor) {
            this.breakFloor = breakFloor;
            this.numberOfFloors = numberOfFloors;
        }

        public boolean throwFrom(int FloorNumber) {
            if (FloorNumber >= breakFloor) return false;
            return true;
        }


    }

    public static int findFloor(Building x) {
        int sum = 0;
        int index = 1;
        while (sum < x.numberOfFloors) {
            index++;
            sum += index;

        }
        return


                index;
    }


    public static void findBreakFloor(Building build, int floorDivide) {
        int tryCounter = 0;
        int sum = 0;
        int preSafeFloor = 0;
        int lastFloor = 0;
        for (int i = floorDivide; i < build.numberOfFloors + 30; i = i + (--floorDivide)) {
            sum += i;
            tryCounter++;
            if (!build.throwFrom(i)) {
                break;
            }
            lastFloor = i;

        }
        // לזרוק מ 14 ואז 13 ואז 12 עד שנשבר, לאחר מכן לזרוק מהקומה לפני שנשבר עד הקומה שנשבר ולהחזיר מתי נשבר
        for (int j = lastFloor + 1; j < sum; j++) {
            tryCounter++;
            if (!build.throwFrom(j)) {
                System.out.println("The ball break after " + tryCounter + " tries");
                System.out.println("The minimum floor that the ball break from is " + j);
                return;
            }
        }
        System.out.println("The ball break after " + tryCounter + " tries");
        System.out.println("The minimum floor that the ball break from is " + sum);
        return;


    }

    public static void dynamicEgg(int k, int n) { // k = num of eggs   n = num pf floor
        int[][] help = new int[k + 1][n + 1];
        for (int i = 0; i < help.length; i++) {
            help[i][0] = 0;
            help[i][1] = 1;

        }
        for (int i = 0; i < help[0].length; i++) {
            help[0][i] = 0;
            help[1][i] = i;
        }
        for (int i = 2; i < help.length; i++) {

            for (int j = 2; j < help[i].length; j++) {
                int min = n + 1;
                for (int l = 1; l < j; l++) {
                    min = Math.min(Math.max(help[i - 1][l - 1], help[i][j - l]), min);
                }
                help[i][j] = min + 1;
            }
        }

        printArr(help);
    }


    public static void main(String[] args) {

        Building build = new Building(100,87);
        int x=findFloor(build);
        System.out.println(x);
        findBreakFloor(build,x);
        dynamicEgg(2, 100);

    }
}
