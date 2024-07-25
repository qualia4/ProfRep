class Cookies implements Priceable {
    @Override
    public double getCoefficient() {
        return 1.5;
    }

    @Override
    public double getBasePrice() {
        return 3.0;
    }
}
