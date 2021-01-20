package NumbersGame.special;

public class Circle {
    public static void main(String[] args) {
        System.out.println( "max profit "+NumberGameCircle(new int[]{1,2,10,6}));;
    }

    static int NumberGameCircle(int [] arr){
        int [] current= new int[arr.length];
        int max=0;
        int index=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length+i; j++){
                current[j-i]=arr[j%arr.length];

            }
            int p= profit(current);
            if(max<p) {
                max = p;
                index=i;
            }
        }
        System.out.println("index "+index);
        return max;
    }

    private static int profit(int[] arr) {
        int [][] help= new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            help[i][i]=arr[i];
        }

        for(int i=arr.length-2; i>=0; i--){
            for(int j=i+1; j<arr.length; j++){
                help[i][j]=Math.max(arr[i]-help[i+1][j], arr[j]-help[i][j-1]);
            }
        }

        return help[0][arr.length-1];
    }

}
