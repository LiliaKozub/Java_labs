package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceWordCounter {
    public static void countWordOccurrencesInSentences(StringBuilder[] words, StringBuilder text) {
        StringBuilder[] sentences = splitTextIntoSentences(text);
        Map<StringBuilder, Integer> wordCountMap = initializeWordCountMap(words);

        for (StringBuilder sentence : sentences)
            countWordsInSentence(sentence, words, wordCountMap);

        displayResults(words, wordCountMap);
    }

    public static StringBuilder[] splitTextIntoSentences(StringBuilder text) {
        List<StringBuilder> sentencesList = new ArrayList<StringBuilder>();

        int sentenceStart = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                sentencesList.add(new StringBuilder(text.substring(sentenceStart, i).trim()));
                sentenceStart = i + 1;
            }
        }

        StringBuilder[] sentences = new StringBuilder[sentencesList.size()];
        return sentencesList.toArray(sentences);
    }

    public static Map<StringBuilder, Integer> initializeWordCountMap(StringBuilder[] words) {
        Map<StringBuilder, Integer> wordCountMap = new HashMap<>();
        for (StringBuilder word : words)
            wordCountMap.put(word, 0);

        return wordCountMap;
    }

    public static void countWordsInSentence(StringBuilder sentence, StringBuilder[] words, Map<StringBuilder, Integer> wordCountMap) {
        StringBuilder trimmedSentence = toLowerCase(sentence);

        for (StringBuilder word : words){
            if (containsIgnoreCase(trimmedSentence, word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            }

        }
    }

    public static StringBuilder toLowerCase(StringBuilder str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.append(Character.toLowerCase(c));
        }
        return result;
    }

    public static boolean containsIgnoreCase(StringBuilder sentence, StringBuilder word) {
    StringBuilder lowerCaseSentence = toLowerCase(sentence);
    StringBuilder lowerCaseWord = toLowerCase(word);
    String lowerCaseWordStr = lowerCaseWord.toString();

    for (int i = 0; i <= lowerCaseSentence.length() - lowerCaseWord.length(); i++) {
        if (lowerCaseSentence.substring(i, i + lowerCaseWord.length()).equals(lowerCaseWordStr)) {
            boolean isWordBoundaryStart = (i == 0 || !Character.isLetter(lowerCaseSentence.charAt(i - 1)));
            boolean isWordBoundaryEnd = (i + lowerCaseWord.length() == lowerCaseSentence.length() || !Character.isLetter(lowerCaseSentence.charAt(i + lowerCaseWord.length())));

            if (isWordBoundaryStart && isWordBoundaryEnd) {
                return true;
            }
        }
    }
    return false;
}

    public static void displayResults(StringBuilder[] words, Map<StringBuilder, Integer> wordCountMap) {
        for (StringBuilder word : words)
            System.out.println("Word '" + word + "' occurs in " + wordCountMap.get(word) + " sentences.");
    }
}
