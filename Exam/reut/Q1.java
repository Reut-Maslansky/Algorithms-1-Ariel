package Exam.reut;

public class Q1 {

    public static int lcs(int[] x, int[] y) {
        int[][] help = new int[x.length + 1][y.length + 1];

        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[i].length; j++) {
                if (i == 0 || j == 0) {
                    help[i][j] = 0;
                } else {
                    if (x[i - 1] == y[j - 1]) {
                        help[i][j] = help[i - 1][j - 1] + 1;
                    } else if (help[i - 1][j] > help[i][j - 1]) {
                        help[i][j] = help[i - 1][j];
                    } else help[i][j] = help[i][j - 1];
                }
            }
        }
        return help[x.length][y.length];
    }

    public static int lcs3(int[] x, int[] y, int[] z) {
        int[][][] help = new int[x.length + 1][y.length + 1][z.length + 1];

        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[i].length; j++) {
                for (int t = 0; t < help[i][j].length; t++) {
                    if (i == 0 || j == 0 || t == 0) {
                        help[i][j][t] = 0;
                    } else {
                        if (x[i - 1] == y[j - 1] && y[j - 1] == z[t - 1]) {
                            help[i][j][t] = help[i - 1][j - 1][t - 1] + 1;
                        } else if (help[i - 1][j][t] > help[i][j - 1][t - 1]) {
                            help[i][j][t] = help[i - 1][j][t];
                        } else if (help[i][j - 1][t] > help[i - 1][j][t - 1])
                            help[i][j][t] = help[i][j - 1][t];
                        else help[i][j][t] = help[i][j][t - 1];
                    }
                }
            }
        }
        return help[x.length][y.length][z.length];
    }
}