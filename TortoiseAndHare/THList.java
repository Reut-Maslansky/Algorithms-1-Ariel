package TortoiseAndHare;

public class THList {
    private THNode head;
    private THNode tail;
    private boolean isCi;


    public THList(boolean b){
        this.head = new THNode();
        this.tail = this.head;
        this.isCi = b;

    }

    public void add(){
        this.tail.setNext(new THNode());
        this.tail = this.tail.next;
        if (this.isCi){
            this.tail.next = this.head;
        }
    }


    public THNode getHead() {
        return head;
    }

    public class THNode {
        private THNode next;

        public THNode() {
            this.next = null;
        }


        public THNode getNext() {
            return next;
        }

        public void setNext(THNode next) {
            this.next = next;
        }
    }
}





