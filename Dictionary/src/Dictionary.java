import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Dictionary {
    private String word;
    private String translate;

    HashMap<String,String> dictionary = new HashMap<>();
    LinkedList<String> dictionaryArray = new LinkedList<>();

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public void addWord(String word,String translate) {
        if(dictionary.containsKey(word)){
            String dictionaryTranslate = dictionary.get(word);
            dictionaryTranslate += "; " + translate;
            dictionary.replace(word,dictionaryTranslate);
        } else{
            dictionary.put(word,translate);
        }
    }

    public void deleteWordOnDictionary(String word) {
        if(dictionary.containsKey(word)){
            dictionary.remove(word);
        } else{
            System.out.println("Данного слова не существует");
        }
    }

    private void addWordOnDictionary(){
        LinkedList<String> updateDictionaryArray = new LinkedList<>();
        TreeMap<String,String> sortedDictionary = new TreeMap<>(dictionary);
        for(String key: sortedDictionary.keySet()){
            String value = sortedDictionary.get(key);
            sortedDictionary.put(key,value);
            updateDictionaryArray.add(key + " - " + value);
        }

        System.out.println(updateDictionaryArray.size());
        dictionaryArray = updateDictionaryArray;
    }

    public void checkDictionary(){
        addWordOnDictionary();
        for (int i = 0;i < dictionaryArray.size(); i++) {
            System.out.println(dictionaryArray.get(i));
        }
    }


}
