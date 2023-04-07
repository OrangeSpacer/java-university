import java.util.ArrayList;
import java.util.Comparator;

public class SortRandomNumber implements Runnable {
    private RandomList randomList;

    public SortRandomNumber(RandomList randomList) {
        this.randomList = randomList;
    }

    @Override
    public void run() {
        this.randomList.sortRandomNumber();
    }
}
