public class power {
    public static void main(String[] args) {
        System.out.println(power(5,3));

    }
    public static int power(int x, int n){
        int result=1;
        while (n!=0){
            if(n%2!=0) result*=x;
            x*=x;
            n/=2;
        }
        return result;
    }
}
