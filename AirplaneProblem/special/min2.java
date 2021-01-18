package AirplaneProblem.special;

import java.util.Arrays;

public class min2 {
    public static void main(String[] args) {
        Node2[][] mat = InitMat1();
        System.out.println(min2(mat));
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

    static int min2(Node2[][] help) {
        for (int i = 1; i < help[0].length; i++) {
            help[0][i].setMin1(help[0][i - 1].getMin1() + help[0][i - 1].getRight());
            help[0][i].setMin2(help[0][i - 1].getMin2() + help[0][i - 1].getRight());
        }
        for (int i = 1; i < help.length; i++) {
            help[i][0].setMin1(help[i - 1][0].getMin1() + help[i - 1][0].getDown());
            help[i][0].setMin2(help[i - 1][0].getMin1() + help[i - 1][0].getDown());
        }

        for (int i = 1; i < help.length; i++) {
            for (int j = 1; j < help[0].length; j++) {
                int x1= help[i-1][j].getMin1()+help[i-1][j].getDown();
                int x2= help[i-1][j].getMin2()+help[i-1][j].getDown();
                int x3= help[i][j-1].getMin1()+help[i][j-1].getRight();
                int x4= help[i][j-1].getMin2()+help[i][j-1].getRight();
                help[i][j].setMin1(min4(x1,x2,x3,x4)[0]);
                help[i][j].setMin2(min4(x1,x2,x3,x4)[1]);
            }
        }
        return help[help.length-1][help[0].length-1].getMin2();
    }

    static int[] min4(int x1, int x2, int x3, int x4){
        int[] ans={x1,x2,x3,x4};
        Arrays.sort(ans);
        if(ans[0]==ans[1])
        {
            if(ans[0]==ans[2])
                ans[1]=ans[3];
            else
                ans[1]=ans[2];
        }
        return ans;
    }
}