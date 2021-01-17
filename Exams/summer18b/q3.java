package Exams.summer18b;

public class q3 {
    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        mat[0] = new int[]{0, 0, 1, 0, 1};
        mat[1] = new int[]{0, 1, 1, 1, 1};
        mat[2] = new int[]{1, 1, 1, 1, 0};
        mat[3] = new int[]{0, 1, 1, 1, 1};
        mat[4] = new int[]{0, 0, 1, 1, 1};
        System.out.println(K_in_One(mat,2));

    }


    static int K_in_One(int mat[][], int k) {
        int[][] help = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            help[i][0] = mat[i][0];
        }
        for (int i = 0; i < mat.length; i++) {
            help[0][i] = mat[0][i];
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    help[i][j] = 0;
                } else {
                    int min = Math.min(help[i][j - 1], help[j - 1][i]);
                    min = Math.min(min, help[i - 1][j - 1]);
                    help[i][j] = min + 1;
                }
            }

        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (k <= help[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
