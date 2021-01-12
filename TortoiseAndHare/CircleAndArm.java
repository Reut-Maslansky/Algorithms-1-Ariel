package TortoiseAndHare;

public class CircleAndArm {

    private static THList initCircleWithArm(int lenC, int lenA) {
        THList myA = new THList(false);
        for (int i = 1; i < lenA; i++) {
            myA.add(i);
        }


        THList myC = new THList(true);
        myC.getHead().setData(lenA);
        myA.getTail().setNext(myC.getHead());
        for (int i = 1; i < lenC; i++) {
            myC.add(i + lenA);
        }

        myA.setTail(myC.getTail());

        return myA;
    }

    static int meetNode(THList circle) {

        THList.THNode t = circle.getHead(); //tortoise
        THList.THNode h = circle.getHead(); //hare

        while (true) {
            t = t.getNext();
            h = h.getNext().getNext();
            if (h == t)
                return h.getData();
        }
    }

    public static void main(String[] args) {
        THList myList = initCircleWithArm(20, 10);
        System.out.println(myList);
        System.out.println(meetNode(myList));

    }

}
