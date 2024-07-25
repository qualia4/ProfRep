public class Main {
    public static void main(String[] args) {
        PricePresenter<Milk, Cookies> presenter1 = new PricePresenter<>(2);
        PricePresenter<Cookies, Pineapple> presenter2 = new PricePresenter<>(3);
        PricePresenter<Pineapple, Milk> presenter3 = new PricePresenter<>(1);

        Milk milk = new Milk();
        Cookies cookies = new Cookies();
        Pineapple pineapple = new Pineapple();

        System.out.println("Milk and Cookies:");
        presenter1.printTotalPrice(milk, cookies);

        System.out.println("Cookies and Pineapple:");
        presenter2.printTotalPrice(cookies, pineapple);

        System.out.println("Pineapple and Milk:");
        presenter3.printTotalPrice(pineapple, milk);
    }
}