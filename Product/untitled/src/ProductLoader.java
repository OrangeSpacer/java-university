import java.io.*;

public class ProductLoader implements Runnable{
    private String path;

    public ProductLoader(String path) {
        this.path = path;
    }


    @Override
    public void run() {
        FileInputStream fis;
        if(this.path != null && new File(this.path).exists()){
            try{
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Product product = (Product)ois.readObject();
                ois.close();
                System.out.println(product.toString());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
