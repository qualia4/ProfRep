class OrangeMessage implements Message {
    private final String string1;
    private final String string2;
    private final int intValue;
    private final double doubleValue;

    public OrangeMessage(String string1, String string2, int intValue, double doubleValue) {
        this.string1 = string1;
        this.string2 = string2;
        this.intValue = intValue;
        this.doubleValue = doubleValue;
    }

    @Override
    public String toString() {
        return "OrangeMessage{string1='" + string1 + "', string2='" + string2 +
                "', intValue=" + intValue + ", doubleValue=" + doubleValue + '}';
    }
}
