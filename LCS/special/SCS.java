package LCS.special;

import java.util.Arrays;

public class SCS {
    public static void main(String[] args) {
        System.out.println(lenSCS("abcbdab", "bdcaba"));
        System.out.println(SubStringSCS("abcbdab", "bdcaba"));
    }

    static int lenSCS(String x, String y) {
        return x.length() + y.length() - LCSLen(x, y);
    }

    static int LCSLen(String x, String y) {
        int[][] help = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                if (i == 0 || j == 0) {
                    help[i][j] = 0;
                } else {
                    if (x.charAt(i - 1) == y.charAt(j - 1))
                        help[i][j] = help[i - 1][j - 1] + 1;
                    else {
                        help[i][j] = Math.max(help[i - 1][j], help[i][j - 1]);
                    }
                }
            }
        }
        return help[help.length - 1][help[0].length - 1];
    }


    static String SubStringSCS(String x, String y) {
        String lcs = LCSSub(x, y);
        int len = x.length() + y.length() - lcs.length();
        int pX = 0, pY = 0, pS = 0;
        String ans = "";

        while (pS < lcs.length()) {
            while (x.charAt(pX) != lcs.charAt(pS)) {
                ans += x.charAt(pX);
                pX++;
            }
            while (y.charAt(pY) != lcs.charAt(pS)) {
                ans += y.charAt(pY);
                pY++;
            }
            ans += lcs.charAt(pS);
            pX++; pY++; pS++;
        }

        while(pX<x.length()){
            ans += x.charAt(pX);
            pX++;
        }
        while(pY<y.length()){
            ans += y.charAt(pY);
            pY++;
        }

        return ans;
    }

    static String LCSSub(String x, String y) {

        int[][] help = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                if (i == 0 || j == 0) {
                    help[i][j] = 0;
                } else {
                    if (x.charAt(i - 1) == y.charAt(j - 1))
                        help[i][j] = help[i - 1][j - 1] + 1;
                    else {
                        help[i][j] = Math.max(help[i - 1][j], help[i][j - 1]);
                    }
                }
            }
        }

        String sub = "";
        int i = x.length(), j = y.length();
        while (help[i][j] > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sub = y.charAt(j - 1) + sub;
                i--;
                j--;
            } else {
                if (help[i - 1][j] > help[i][j - 1])
                    i--;
                else j--;
            }
        }
        return sub;
    }
}
