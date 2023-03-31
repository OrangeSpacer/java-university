import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private long code;
    private String name;
    private String type;
    private boolean isDiscount;
    private ArrayList<String> ingredients;
    private double price;

    private static final long serialVersionUID = -3536693998646060163L;

    public Product(long code, String name, String type, boolean isDiscount, ArrayList<String> ingredients, double price) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.isDiscount = isDiscount;
        this.ingredients = ingredients;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isDiscount=" + isDiscount +
                ", ingredients=" + ingredients +
                ", price=" + price +
                '}';
    }

}
