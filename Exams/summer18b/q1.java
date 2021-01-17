package Exams.summer18b;

public class q1 {

    public static void main(String[] args) {
        String x = "abcbdab";
        String y = "bdcaba";
        String z = "bdab";
        int wordLen = LCS(x, y, z);
        String myWord = LCSString(x, y, z);
        System.out.println(wordLen + " " + myWord);
    }

    public static String LCSString(String x, String y, String z) {
        int[][][] helpTable = new int[y.length() + 1][x.length() + 1][z.length() + 1];
        for (int i = 0; i < helpTable.length; i++) {
            for (int j = 0; j < helpTable[0].length; j++) {
                for (int t = 0; t < helpTable[0][0].length; t++) {
                    if (i == 0 || j == 0 || t == 0)
                        helpTable[i][j][t] = 0;
                    else if (y.charAt(i - 1) == x.charAt(j - 1) && y.charAt(i - 1) == z.charAt(t - 1))
                        helpTable[i][j][t] = helpTable[i - 1][j - 1][t - 1] + 1;
                    else {
                        int temp = Math.max(helpTable[i - 1][j][t], helpTable[i][j - 1][t]);
                        helpTable[i][j][t] = Math.max(temp, helpTable[i][j][t - 1]);
                    }
                }
            }
        }

        String myWord = "";
        int i = helpTable.length - 1;
        int j = helpTable[0].length - 1;
        int t = helpTable[0][0].length - 1;

        while (helpTable[i][j][t] > 0) {

            if (y.charAt(i - 1) == x.charAt(j - 1) && y.charAt(i - 1) == z.charAt(t - 1)) {
                myWord = y.charAt(i - 1) + myWord;
                i--;
                j--;
                t--;
            } else {

                int temp = Math.max(helpTable[i - 1][j][t], helpTable[i][j - 1][t]);
                temp = Math.max(temp, helpTable[i][j][t - 1]);
                if (temp == helpTable[i - 1][j][t])
                    i--;
                else if (temp == helpTable[i][j - 1][t])
                    j--;
                else
                    t--;


            }
        }


        return myWord;


    }

    public static int LCS(String x, String y, String z) {
        int[][][] helpTable = new int[y.length() + 1][x.length() + 1][z.length() + 1];
        for (int i = 0; i < helpTable.length; i++) {
            for (int j = 0; j < helpTable[0].length; j++) {
                for (int t = 0; t < helpTable[0][0].length; t++) {
                    if (i == 0 || j == 0 || t == 0)
                        helpTable[i][j][t] = 0;
                    else if (y.charAt(i - 1) == x.charAt(j - 1) && y.charAt(i - 1) == z.charAt(t - 1))
                        helpTable[i][j][t] = helpTable[i - 1][j - 1][t - 1] + 1;
                    else {
                        int temp = Math.max(helpTable[i - 1][j][t], helpTable[i][j - 1][t]);
                        helpTable[i][j][t] = Math.max(temp, helpTable[i][j][t - 1]);
                    }
                }
            }
        }

        return helpTable[y.length()][x.length()][z.length()];


    }


}


