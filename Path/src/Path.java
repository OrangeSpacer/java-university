import java.io.File;
import java.nio.file.Files;

public class Path {
    public void init(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            if(file.isDirectory()) {
                System.out.println(file.getPath());
                init(file.getPath());
                continue;
            } else {
                System.out.println(file.getPath() + " " + file.getUsableSpace()/8/1024/1024);
            }
        }
    }
}
