package Exam.roei;

public class Q1 {


    // O(n*m)
    public static int lcs(int[] X, int[] Y) {
        int m = Y.length + 1;
        int n = X.length + 1;
        int[][] help = new int[m][n];
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                if (i == 0 || j == 0)
                    help[i][j] = 0;
                else if (Y[i-1] == X[j - 1])
                    help[i][j] = help[i - 1][j - 1] + 1;
                else
                    help[i][j] = Math.max(help[i - 1][j], help[i][j - 1]);
            }
        }
        return help[m - 1][n - 1];
    }

    // O(n*m*k)
    public static int lcs3(int[] X, int[] Y, int[] Z){
        int[][][] helpTable = new int[Y.length + 1][X.length + 1][Z.length + 1];
        for (int i = 0; i < helpTable.length; i++) {
            for (int j = 0; j < helpTable[0].length; j++) {
                for (int t = 0; t < helpTable[0][0].length; t++) {
                    if (i == 0 || j == 0 || t == 0)
                        helpTable[i][j][t] = 0;
                    else if (Y[i - 1] == X[j - 1] && Y[i - 1] == Z[t - 1])
                        helpTable[i][j][t] = helpTable[i - 1][j - 1][t - 1] + 1;
                    else {
                        int temp = Math.max(helpTable[i - 1][j][t], helpTable[i][j - 1][t]);
                        helpTable[i][j][t] = Math.max(temp, helpTable[i][j][t - 1]);
                    }
                }
            }
        }

        return helpTable[Y.length][X.length][Z.length];


    }


}
