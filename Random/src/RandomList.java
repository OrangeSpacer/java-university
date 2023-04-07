import java.util.ArrayList;
import java.util.Comparator;

public class RandomList extends java.util.Random {
    private ArrayList<Integer> listRandom = new ArrayList<>();

    public synchronized void fillRandomNumber() {
        while(this.listRandom.size() == 100){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        RandomList randomList = new RandomList();
        for(int i = 0;i < 100;i++){
            this.listRandom.add(i, randomList.nextInt(100));
        }
        System.out.println(this.listRandom);
        notify();
    }

    public synchronized void sortRandomNumber() {
        while(this.listRandom.size() < 100) {
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.listRandom.sort(Comparator.naturalOrder());
        System.out.println(this.listRandom);
        notify();
    }
}
