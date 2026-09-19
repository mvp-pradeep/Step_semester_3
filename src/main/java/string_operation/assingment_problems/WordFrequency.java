import java.util.*;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Step 1: Convert to lowercase
        String text = feedback.toLowerCase();

        // Step 2: Remove punctuation
        text = text.replace(".", "");
        text = text.replace(",", "");

        // Step 3: Split into words
        String[] words = text.split("\\s+");

        // Step 4: Stop words
        HashSet<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Step 5: Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        // Step 6: Convert map entries into a list
        ArrayList<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());

        // Step 7: Sort by count in descending order
        list.sort(
            (a, b) -> b.getValue() - a.getValue()
        );

        // Step 8: Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }


    public static void main(String[] args) {

        printFilteredWordFrequency(
            "The mentor was great, the session was great and clear."
        );
    }
}