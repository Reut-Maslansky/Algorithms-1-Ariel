package Exams.summer18b;

public class q4 {
    public static void main(String[] args) {

        int[] arr= {1,3,6,1,3,6};
        int profit= numberGame(arr);
        System.out.println(profit);
    }

    private static int numberGame(int[] arr) {
        int[][] help= new int[arr.length][arr.length];
        for (int i = 0 ;i< arr.length;i++){
            help[i][i]=arr[i];
        }
        for (int i = arr.length-2;i>=0;i--){
            for (int j =i+1;j<arr.length;j++){
                help[i][j] = Math.max(arr[i]-help[i+1][j],arr[j]-help[i][j-1]);
            }
        }
        return help[0][arr.length-1];
    }
}
