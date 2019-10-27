package lesson3;

import java.util.HashMap;
import java.util.Random;

public class Words {

    public static String[] createRandomArray(String[] words, int length){
        String[] result = new String[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(words.length);
            result[i] = words[randomIndex];
        }

        return result;
    }

    public static HashMap<String, Integer> uniqueWords(String[] array){
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String str: array)
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);

        return hashMap;
    }
}
