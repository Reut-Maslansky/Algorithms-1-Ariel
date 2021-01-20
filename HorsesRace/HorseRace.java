package HorsesRace;

import java.util.Arrays;

public class HorseRace {
    public static void main(String[] args) {
        int [] arr= new int[25];
        for(int i=0; i<25; i++){
            arr[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(Winners(arr)));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] Winners(int [] arr){
        int [] win= new int[3];

        int[][]race=new int[5][5];
        int index=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                race[i][j]=arr[index++];
            }
        }

        for(int i=0; i<5; i++){
            Arrays.sort(race[i]);
        }
        Arrays.sort(race,(o1, o2) -> o2[4]-o1[4]);
        System.out.println(Arrays.toString(race[0]));
        System.out.println(Arrays.toString(race[1]));
        System.out.println(Arrays.toString(race[2]));
        System.out.println(Arrays.toString(race[3]));
        System.out.println(Arrays.toString(race[4]));

        int [] finalFive= new int[5];
        finalFive[0]=race[0][2];
        finalFive[1]=race[0][3];
        finalFive[2]=race[1][3];
        finalFive[3]=race[1][4];
        finalFive[4]=race[2][4];

        Arrays.sort(finalFive);

        win[0]=race[0][4];
        win[1]=finalFive[4];
        win[2]=finalFive[3];

        return win;
    }
}
