package PowAndFib;

public class power {
    public static void main(String[] args) {
        System.out.println(powerLoop(3,4));
        System.out.println(powerRec(3,4));

    }

    public static int powerRec(int x, int n) {
        if(n==0) return 1;
        if (n%2==0) return powerRec(x*x, n/2);
        return x*powerRec(x*x, (n-1)/2);
    }

    public static int powerLoop(int x, int n){
        int result=1;
        while (n!=0){
            if(n%2!=0) result*=x;
            x*=x;
            n/=2;
        }
        return result;
    }
}
