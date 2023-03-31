import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Product p = new Product(2L,"test", "testType", true,new ArrayList<String>(),123345);
//        ProductRunnable pr = new ProductRunnable(p,"d:\\javaTest\\product.ser");
        ProductLoader pl = new ProductLoader("d:\\javaTest\\product.ser");
        Thread th = new Thread(pl);
        th.start();
    }
}