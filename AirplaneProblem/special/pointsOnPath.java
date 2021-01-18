package AirplaneProblem.special;

import java.util.Arrays;

public class pointsOnPath {

    private static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }


    private static Node2[][] InitMat1() {
        Node2[][] mat = new Node2[4][5];

        mat[0][0] = new Node2(8, 1);
        mat[0][1] = new Node2(8, 8);
        mat[0][2] = new Node2(8, 8);
        mat[0][3] = new Node2(8, 9);
        mat[0][4] = new Node2(0, 8);

        mat[1][0] = new Node2(1, 1);
        mat[1][1] = new Node2(8, 1);
        mat[1][2] = new Node2(8, 8);
        mat[1][3] = new Node2(8, 8);
        mat[1][4] = new Node2(0, 8);

        mat[2][0] = new Node2(8, 1);
        mat[2][1] = new Node2(1, 8);
        mat[2][2] = new Node2(1, 8);
        mat[2][3] = new Node2(8, 0);
        mat[2][4] = new Node2(0, 8);

        mat[3][0] = new Node2(1, 0);
        mat[3][1] = new Node2(2, 0);
        mat[3][2] = new Node2(0, 0);
        mat[3][3] = new Node2(0, 0);
        mat[3][4] = new Node2(0, 0);


        return mat;
    }

    public static void main(String[] args) {
        Point[] arr = {new Point(0, 0), new Point(2, 2), new Point(3, 2)};

        System.out.println(areOnPath(arr, InitMat1()));
    }

    static boolean areOnPath(Point[] arr, Node2[][] help) {
        Arrays.sort(arr, (o1, o2) -> o1.y - o2.y);
        Arrays.sort(arr, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1)
                if (arr[i].x > arr[i + 1].x || arr[i].y > arr[i + 1].y) return false;
            if (arr[i].x > help.length - 1 || arr[i].x < 0) return false;
            if (arr[i].y > help[0].length - 1 || arr[i].y < 0) return false;
        }

        int sumWay = cheapRouteAToB(help, 0, 0, arr[0].x, arr[0].y);
        for (int i = 0; i < arr.length - 1; i++) {
            sumWay += cheapRouteAToB(help, arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y);
        }
        sumWay += cheapRouteAToB(help, arr[arr.length - 1].x, arr[arr.length - 1].y, help.length - 1, help[0].length - 1);
        return cheapRouteAToB(help, 0, 0, help.length - 1, help[0].length - 1) == sumWay;
    }


    private static int cheapRouteAToB(Node2[][] mat, int r, int c, int x, int y) {
        {
            int n = mat.length;
            int m = mat[0].length;

            mat[r][c].setMin1(0);

            for (int i = r + 1; i < n; i++) {
                mat[i][c].setMin1(mat[i - 1][c].getMin1() + mat[i - 1][c].getDown());
            }
            for (int j = c + 1; j < m; j++) {
                mat[r][j].setMin1(mat[r][j - 1].getMin1() + mat[r][j - 1].getRight());
            }

            for (int i = r + 1; i < n; i++) {
                for (int j = c + 1; j < m; j++) {
                    int min = Math.min((mat[i][j - 1].getMin1() + mat[i][j - 1].getRight()), (mat[i - 1][j].getMin1() + mat[i - 1][j].getDown()));
                    mat[i][j].setMin1(min);
                }
            }


            return mat[x][y].getMin1();
        }
    }
}

