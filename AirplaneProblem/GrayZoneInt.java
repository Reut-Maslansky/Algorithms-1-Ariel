package AirplaneProblem;


import java.awt.*;

public class GrayZoneInt {
    public static void main(String[] args) {
        System.out.println(grayZone(InitMat1(), new Point(2, 0), new Point(3, 2)));
    }

    private static Node[][] InitMat1() {
        Node[][] mat = new Node[4][4];

        mat[0][0] = new Node(1, 2);
        mat[0][1] = new Node(5, 4);
        mat[0][2] = new Node(3, 9);
        mat[0][3] = new Node(0, 9);

        mat[1][0] = new Node(5, 4);
        mat[1][1] = new Node(4, 4);
        mat[1][2] = new Node(7, 4);
        mat[1][3] = new Node(0, 2);

        mat[2][0] = new Node(8, 3);
        mat[2][1] = new Node(5, 6);
        mat[2][2] = new Node(8, 0);
        mat[2][3] = new Node(0, 0);

        mat[3][0] = new Node(2, 0);
        mat[3][1] = new Node(4, 0);
        mat[3][2] = new Node(5, 0);
        mat[3][3] = new Node(0, 0);
        return mat;
    }

    static int grayZone(Node[][] mat, Point start, Point end) {

        int minX = Math.min(start.x, end.x);
        int maxX = Math.max(start.x, end.x);
        int minY = Math.min(start.y, end.y);
        int maxY = Math.max(start.y, end.y);

        if (minX < 0 || minY < 0 || maxX > mat[0].length || maxY > mat.length)
            return -1;
        Node[][] temp = new Node[mat.length][mat[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = new Node(mat[i][j].getRight(), mat[i][j].getDown());
            }

        }


        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                temp[i][j].setValue(Integer.MAX_VALUE);
            }
        }


        for(int i=1; i<mat.length; i++){
            if (temp[i][0].getValue() != Integer.MAX_VALUE)
            temp[i][0].setValue(temp[i-1][0].getValue()+temp[i-1][0].getDown());}
        for(int j=1; j<mat[0].length; j++){
            if (temp[0][j].getValue() != Integer.MAX_VALUE)
            temp[0][j].setValue(temp[0][j-1].getValue()+temp[0][j-1].getRight());}



        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                if (temp[i][j].getValue() != Integer.MAX_VALUE)
                temp[i][j].setValue(Math.min(temp[i][j-1].getValue()+temp[i][j-1].getRight(), temp[i-1][j].getValue()+temp[i-1][j].getDown()));
            }

        }

        if ( temp[mat.length - 1][mat[0].length - 1].getValue() ==Integer.MAX_VALUE)
            return -1;

        return temp[mat.length - 1][mat[0].length - 1].getValue();
    }
}
