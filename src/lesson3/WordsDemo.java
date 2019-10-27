package lesson3;

public class WordsDemo {
    public static void main(String[] args) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String[] testArray = Words.createRandomArray(words, 20);

        System.out.print("Test array: { ");
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i]+ " ");
        }
        System.out.println("}.");

        System.out.println("Unique words repeat: " + Words.uniqueWords(testArray));
    }
}
