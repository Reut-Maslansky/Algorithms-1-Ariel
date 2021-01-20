package LCS.special;

import java.util.Arrays;
import java.util.LinkedList;

public class AllSubString {
    static LinkedList<String> all;

    public static void main(String[] args) {
        AllSub("abcbdab", "bdcaba");
        System.out.println(all);
    }
    static LinkedList<String> AllSub(String x, String y){
        all= new LinkedList<>();
        int [][]help= new int[x.length()+1][y.length()+1];

        for(int i=0; i<help.length;i++){
            for (int j = 0 ; j<help[0].length; j++){
                if (i==0 || j ==0)
                    help[i][j]=0;
                else {
                    if(x.charAt(i-1)==y.charAt(j-1))
                        help[i][j]=help[i-1][j-1]+1;
                    else help[i][j]=Math.max(help[i-1][j],help[i][j-1]);
                }
            }
            System.out.println(Arrays.toString(help[i]));
        }
        System.out.println();
        findAllRec(x,y,help,x.length(),y.length(),"");

        return all;
    }

    private static void findAllRec(String x, String y, int[][] help, int i, int j, String s) {
        if (help[i][j]==0 )
            if(s.length() == help[x.length()][y.length()])
            all.add(s);
            else return;
        else if(x.charAt(i-1)==y.charAt(j-1))
        {
            s = x.charAt(i - 1) + s;
            findAllRec(x,y,help,i-1,j-1,s);
        }else {
            findAllRec(x,y,help,i-1,j,s);
            findAllRec(x,y,help,i,j-1,s);
        }
    }
}
