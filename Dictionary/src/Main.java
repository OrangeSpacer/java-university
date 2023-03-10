public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        dictionary.addWord("Mead","мёд");
        dictionary.addWord("Abdication","отречение");
        dictionary.addWord("Aperitif","аперитив");
        dictionary.addWord("Zizz","жужжание");
        dictionary.addWord("Abdication","отказ");
        dictionary.checkDictionary();
        dictionary.deleteWordOnDictionary("Zizz");
        dictionary.checkDictionary();

    }
}