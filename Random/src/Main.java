public class Main {
    public static void main(String[] args) {

        RandomList randomList = new RandomList();
        new Thread(new FillRandomNumber(randomList)).start();
        new Thread(new SortRandomNumber(randomList)).start();

    }
}