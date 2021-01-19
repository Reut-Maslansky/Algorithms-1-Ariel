package AirplaneProblem.special;

class NodeDouble {
    private double right, down, value;

    public NodeDouble(double r, double d) {
        this.right = r;
        this.down = d;
        this.value=0;
    }

    public double getDown() {
        return down;
    }

    public double getRight() {
        return right;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+ value ;
    }
}
