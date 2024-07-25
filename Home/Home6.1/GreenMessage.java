class GreenMessage implements Message {
    private final String content;
    private final int counter;

    public GreenMessage(String content, int counter) {
        this.content = content;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "GreenMessage{content='" + content + "', counter=" + counter + '}';
    }
}
