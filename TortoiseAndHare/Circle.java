package TortoiseAndHare;


import java.util.ArrayList;

public class Circle {

    private static THList initCircle(int len) {
        THList myList = new THList(true);
        for (int i = 0; i < len; i++) {
            myList.add();
        }
        return myList;
    }


    private static THList initList(int len) {
        THList myList = new THList(false);
        for (int i = 0; i < len; i++) {
            myList.add();
        }
        return myList;
    }

    static boolean isCircle(THList circle) {

        THList.THNode t = circle.getHead(); //tortoise
        THList.THNode h = circle.getHead(); //hare

        while(h.getNext() !=null && h.getNext().getNext() !=null){
            t = t.getNext();
            h =  h.getNext().getNext();
            if (h == t)
                return true;
        }



        return false;
    }


    public static void main(String[] args) {
        THList myList = initList(8);
        System.out.println(isCircle(myList));
        THList myCircle = initCircle(8);
        System.out.println(isCircle(myCircle));
    }


}
