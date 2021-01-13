import java.util.Stack;

public class binaryNum {
    public static void main(String[] args) {
       int x=castNum(0);
        System.out.println(x);
    }

    public static int castNum(int n){
        Stack<Integer> s=new Stack<>();
        int num=n;
        while(num>0){
            s.add(n%2);
            n/=2;
            num=n;
        }
        int x=0;
        while(!s.isEmpty()){
            x*=10;
            x+=s.pop();
        }
        return x;
    }
}
