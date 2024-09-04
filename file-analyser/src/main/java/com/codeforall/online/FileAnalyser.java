package com.codeforall.online;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class provides methods to analyze text files including counting lines, words, unique words,
 * occurrences of specific words, finding lines containing specific words, calculating average line length,
 * average word length, finding shortest and longest lines, finding top n longest words,
 * finding the first word with more than n characters, finding common words between two files,
 * getting word frequency, finding lines containing numbers, finding lines matching a regex pattern,
 * and collecting palindromic words.
 */
public class FileAnalyser {

    private static String ROOT_DIR = "file-analyser/src/main/resources/";


    /**
     * Prompts the user to enter the path to the first file to analyze and returns the path.
     *
     * @return The path to the first file.
     */
    public static String getFirstFileToAnalyse() {
        Scanner scanner = new Scanner(System.in);
        String file1;
        while (true) {
            System.out.println("Please enter path to the first file:");
            file1 = ROOT_DIR + scanner.nextLine();
            if (Files.exists(Paths.get(file1))) {
                System.out.println(file1);
                System.out.println("--------");
                break;
            } else
                System.out.println("File does not exist");
        }
        return file1;
    }


    /**
     * Prompts the user to enter the path to the second file to analyze and returns the path.
     *
     * @return The path to the second file.
     */
    public static String getSecondFileToAnalyse() {
        Scanner scanner = new Scanner(System.in);
        String file2;
        while (true) {
            System.out.println("Please enter path to the Second file:");
            file2 = ROOT_DIR + scanner.nextLine();
            if (Files.exists(Paths.get(file2))) {
                System.out.println(file2);
                System.out.println("--------");
                break;
            } else
                System.out.println("File does not exist");
        }
        return file2;
    }


    /**
     * Counts the number of lines in the specified file.
     *
     * @param filename The path to the file.
     * @return The number of lines in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static long countLines(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.count();
        }
    }


    /**
     * Counts the number of words in the specified file.
     *
     * @param filename The path to the file.
     * @return The number of words in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static long countWords(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> !word.isEmpty())
                    .count();
        }
    }


    /**
     * Counts the number of non-empty lines in the specified file.
     *
     * @param filename The path to the file.
     * @return The number of non-empty lines in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static long countNonEmptyLines(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream
                    .filter(line -> !line.trim().isEmpty())
                    .count();
        }
    }


    /**
     * Counts the number of unique words in the specified file.
     *
     * @param filename The path to the file.
     * @return The number of unique words in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static long countUniqueWords(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::toLowerCase)
                    .distinct()
                    .count();
        }
    }


    /**
     * Counts the number of occurrences of a specific word in the specified file.
     *
     * @param filename The path to the file.
     * @param word     The word to search for.
     * @return The number of occurrences of the word in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static long countWordOccurrences(String filename, String word) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .filter(w -> w.equals(word.toLowerCase()))
                    .count();
        }
    }


    /**
     * Finds lines in the specified file that contain a specific word.
     *
     * @param filename The path to the file.
     * @param word     The word to search for.
     * @return A list of lines containing the word.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> findLinesContainingWord(String filename, String word) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream
                    .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
                    .collect(Collectors.toList());
        }
    }


    /**
     * Calculates the average length of lines in the specified file.
     *
     * @param filename The path to the file.
     * @return The average length of lines in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static double averageLineLength(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.collect(Collectors.averagingInt(String::length));
        }
    }


    /**
     * Calculates the average length of words in the specified file.
     *
     * @param filename The path to the file.
     * @return The average length of words in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static double averageWordLength(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.averagingInt(String::length));
        }
    }


    /**
     * Finds the shortest line in the specified file.
     *
     * @param filename The path to the file.
     * @return An optional containing the shortest line, or empty if the file is empty.
     * @throws IOException If an I/O error occurs.
     */
    public static Optional<String> findShortestLine(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.min(Comparator.comparingInt(String::length));
        }
    }


    /**
     * Finds the longest line in the specified file.
     *
     * @param filename The path to the file.
     * @return An optional containing the longest line, or empty if the file is empty.
     * @throws IOException If an I/O error occurs.
     */
    public static Optional<String> findLongestLine(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.max(Comparator.comparingInt(String::length));
        }
    }


    /**
     * Finds the top n longest words in the specified file.
     *
     * @param filename The path to the file.
     * @param n        The number of longest words to find.
     * @return A list containing the top n longest words.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> findTopNLongestWord(String filename, int n) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(n)
                    .collect(Collectors.toList());
        }
    }


    /**
     * Finds the first word in the specified file with more than n characters.
     *
     * @param filename The path to the file.
     * @param n        The minimum number of characters for the word.
     * @return An optional containing the first word with more than n characters, or empty if no such word is found.
     * @throws IOException If an I/O error occurs.
     */
    public static Optional<String> getFirstWordWithMoreThanNCharacters(String filename, int n) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> word.length() > n)
                    .findFirst();
        }
    }


    /**
     * Finds common words between two files.
     *
     * @param filename1 The path to the first file.
     * @param filename2 The path to the second file.
     * @return A set containing the common words between the two files.
     * @throws IOException If an I/O error occurs.
     */
    public static Set<String> findCommonWordsBetweenFiles (String filename1, String filename2) throws IOException {
        try (Stream<String> lines1 = Files.lines(Paths.get(filename1));
             Stream<String> lines2 = Files.lines(Paths.get(filename2))) {

            Set<String> wordsInFile1 = lines1.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());

            return lines2.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .filter(wordsInFile1::contains)
                    .collect(Collectors.toSet());
        }

    }


    /**
     * Gets the frequency of each word in the specified file.
     *
     * @param filename The path to the file.
     * @return A map containing each word and its frequency in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static Map<String, Long> getWordFrequency(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        }
    }


    /**
     * Finds lines containing numbers in the specified file.
     *
     * @param filename The path to the file.
     * @return A list of lines containing numbers.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> findLinesContainingNumbers(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.filter(line -> line.matches(".*\\d+.*"))
                    .collect(Collectors.toList());
        }
    }


    /**
     * Finds lines in the specified file that match a regular expression pattern.
     *
     * @param filename The path to the file.
     * @param regex    The regular expression pattern to match.
     * @return A list of lines matching the regex pattern.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> findLinesMatchingRegex(String filename, String regex) throws IOException {
        Pattern pattern = Pattern.compile(regex);
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.filter(line -> pattern.matcher(line).find())
                    .collect(Collectors.toList());
        }
    }


    /**
     * Collects palindromic words from the specified file.
     *
     * @param filePath The path to the file.
     * @return A list of palindromic words found in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> findPalindromicWords(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> isPalindrome(word.toLowerCase()))
                    .distinct()
                    .collect(Collectors.toList());
        }
    }


    /**
     * Checks whether a given word is a palindrome.
     *
     * @param word The word to check.
     * @return True if the word is a palindrome, false otherwise.
     */
    private static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
