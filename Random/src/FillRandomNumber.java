public class FillRandomNumber implements Runnable {
    private RandomList randomList;

    public FillRandomNumber(RandomList randomList) {
        this.randomList = randomList;
    }
    @Override
    public void run() {
        this.randomList.fillRandomNumber();
    }
}
