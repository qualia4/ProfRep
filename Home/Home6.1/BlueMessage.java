class BlueMessage implements Message {
    private final double value1;
    private final double value2;

    public BlueMessage(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "BlueMessage{value1=" + value1 + ", value2=" + value2 + '}';
    }
}
