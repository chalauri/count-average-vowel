import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Created by G.Chalauri on 3/11/2017.
 */
public class VowelCounter {
    public String averageVowel(String file) throws IOException {
        String input = readFile(file);
        input = input.toLowerCase();
        String[] splited = splitInWords(input);

        Map<Set<Character>, List<String>> wordsByVowel = groupByVowels(splited);

        StringBuilder result = new StringBuilder();
        for (Set<Character> key : wordsByVowel.keySet()) {
            Map<Integer, List<String>> tempWordsByLength = wordsByLength(wordsByVowel.get(key));
            for (Integer wordSize : tempWordsByLength.keySet()) {
                List<String> words = tempWordsByLength.get(wordSize);
                int vowelsSize = countVowel(words);
                double average = ((double) vowelsSize / words.size());
                result.append(convertToOutputFormat(key, wordSize, average));
                result.append(System.lineSeparator());
            }
        }

        writeToFile(result.toString());

        return result.toString();
    }


    private Set<Character> vowelsInWord(String word) {
        String onlyVowels = word.replaceAll("[^aeiou]", "");

        Set<Character> result = onlyVowels.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        return result;
    }

    private Map<Set<Character>, List<String>> groupByVowels(String[] words) {
        Map<Set<Character>, List<String>> wordsByVowel = new HashMap<>();

        for (String word : words) {
            Set<Character> vowelsInWord = vowelsInWord(word);
            List<String> tempWords = wordsByVowel.get(vowelsInWord);
            if (tempWords == null) {
                List<String> tmp = new ArrayList<>();
                tmp.add(word);
                wordsByVowel.put(vowelsInWord, tmp);
            } else {
                tempWords.add(word);
            }
        }

        return wordsByVowel;
    }

    private Map<Integer, List<String>> wordsByLength(List<String> words) {
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        for (String word : words) {
            int wordSize = word.length();
            List<String> tempWords = wordsByLength.get(wordSize);
            if (tempWords == null) {
                wordsByLength.put(wordSize, new ArrayList<>(Arrays.asList(word)));
            } else {
                tempWords.add(word);
            }
        }

        return wordsByLength;
    }


    private int countVowel(List<String> words) {

        int result = 0;


        for (String word : words) {
            int count = word.replaceAll("[^aeiouAEIOU]","").length();
            result += count;
        }

        return result;
    }

    private String[] splitInWords(String text) {

        String[] result = text.replace(".", "").replace("'", "").replace(",", "").replace("?", "").replace("!", "").split("\\s+");

        return result;
    }

    private String readFile(String file) throws IOException {

        Path path = Paths.get(file);
        StringBuilder builder = new StringBuilder();
        try {
            List<String> contents = Files.readAllLines(path);

            for (String content : contents) {
                builder.append(content + " ");
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }

        return builder.toString();
    }

    private void writeToFile(String data) throws IOException {

        Files.write(Paths.get("OUTPUT.txt"), data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    private String convertToOutputFormat(Set<Character> vowels, int wordSize, double average) {
        StringBuilder builder = new StringBuilder("({");

        String prefix = "";
        for (Character c : vowels) {
            builder.append(prefix);
            builder.append(c);
            prefix = ", ";
        }

        builder.append("}, ");
        builder.append(wordSize);
        builder.append(")");
        builder.append(" -> ");
        builder.append(average);

        return builder.toString();
    }

}
