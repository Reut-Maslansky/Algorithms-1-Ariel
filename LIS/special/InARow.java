package LIS.special;

public class InARow {
    public static void main(String[] args) {
        System.out.println(inARow("abcbdabf", "bbcbda"));
        System.out.println(inARowString("abcbdabf", "bbcbda"));
    }

    static int inARow(String x, String y) {
        int[][] help = new int[x.length() + 1][y.length() + 1];
        int max = 0;
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                if (i == 0 || j == 0) {
                    help[i][j] = 0;
                } else {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        help[i][j] = help[i - 1][j - 1] + 1;
                        if (max < help[i][j]) max = help[i][j];
                    }
                }
            }
        }
        return max;
    }

    static String inARowString(String x, String y) {

        int[][]help= new int[x.length()+1][y.length()+1];
        int max=0;
        for(int i=0; i<=x.length(); i++){
            for(int j=0; j<=y.length(); j++) {
                if(i==0||j==0) help[i][j]=0;
                else {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        help[i][j] = help[i - 1][j - 1] + 1;
                        if(max<help[i][j]) max=help[i][j];
                    }
                }
            }
        }

        String ans = "";
        while(max>0){
            ans= x.charAt(max--)+ans;
        }

        return ans;
    }
}
