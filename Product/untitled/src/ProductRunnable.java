import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProductRunnable implements Runnable {
    private Product product;
    private String path;

    public ProductRunnable(Product product, String path) {
        this.product = product;
        this.path = path;
    }

    @Override
    public void run() {
        if(this.path != null && product != null) {
            FileOutputStream fos;
            try{
                fos = new FileOutputStream(this.path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(product);
                oos.close();
                System.out.println("Success serialization obj Product");
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
