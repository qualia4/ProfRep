class PricePresenter<T extends Priceable, U extends Priceable> {
    private final int PRIORITY;

    public PricePresenter(int priority) {
        this.PRIORITY = priority;
    }

    public void printTotalPrice(T obj1, U obj2) {
        double totalPrice = PRIORITY * obj1.getCoefficient() * obj1.getBasePrice() +
                obj2.getCoefficient() * obj2.getBasePrice();
        System.out.printf("Total price: %.2f%n", totalPrice);
    }
}
