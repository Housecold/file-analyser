package com.codeforall.online;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        String file1 = FileAnalyser.getFirstFileToAnalyse();
        String file2 = FileAnalyser.getSecondFileToAnalyse();

        System.out.println("Path to the first file: " + file1);
        System.out.println("Path to the second file: " + file2);

        try {
            // Single file analysis for file1
            System.out.println("-------- Analysis of file: " + file1 + " --------");
            printLineCount(file1);
            printWordCount(file1);
            printNonEmptyLinesCount(file1);
            printUniqueWordsCount(file1);
            printWordOccurrencesCount(file1, "file");
            printLinesContainingWord(file1, "file");
            printAverageLineLength(file1);
            printAverageWordLength(file1);
            printShortestLine(file1);
            printLongestLine(file1);
            printTopNLongestWords(file1, 5);
            printFirstWordWithMoreThanNCharacters(file1, 5);
            printWordFrequency(file1);
            printLinesContainingNumbers(file1);
            printLinesMatchingRegex(file1, "\\b\\w{5}\\b");
            printPalindromicWords(file1);

            // Single file analysis for file2
            System.out.println("-------- Analysis of file: " + file2 + " --------");
            printLineCount(file2);
            printWordCount(file2);
            printNonEmptyLinesCount(file2);
            printUniqueWordsCount(file2);
            printWordOccurrencesCount(file2, "file");
            printLinesContainingWord(file2, "file");
            printAverageLineLength(file2);
            printAverageWordLength(file2);
            printShortestLine(file2);
            printLongestLine(file2);
            printTopNLongestWords(file2, 5);
            printFirstWordWithMoreThanNCharacters(file2, 5);
            printWordFrequency(file2);
            printLinesContainingNumbers(file2);
            printLinesMatchingRegex(file2, "\\b\\w{5}\\b");
            printPalindromicWords(file2);

            // Comparison between file1 and file2
            System.out.println("-------- Comparison between files: " + file1 + " and " + file2 + " --------");
            printCommonWordsBetweenFiles(file1, file2);

        } catch (IOException e) {
            System.out.println("File not found or error reading the file.");
        }

    }

    private static void printLineCount(String file) throws IOException {
        System.out.println("-------- Count how many lines are in the file --------");
        System.out.println(FileAnalyser.countLines(file));
        System.out.println("--------");
    }

    private static void printWordCount(String file) throws IOException {
        System.out.println("-------- Count how many words are in the file --------");
        System.out.println(FileAnalyser.countWords(file));
        System.out.println("--------");
    }

    private static void printNonEmptyLinesCount(String file) throws IOException {
        System.out.println("-------- Count how many non-empty lines are in the file --------");
        System.out.println(FileAnalyser.countNonEmptyLines(file));
        System.out.println("--------");
    }

    private static void printUniqueWordsCount(String file) throws IOException {
        System.out.println("-------- Count how many unique words are in the file --------");
        System.out.println(FileAnalyser.countUniqueWords(file));
        System.out.println("--------");
    }

    private static void printWordOccurrencesCount(String file, String word) throws IOException {
        System.out.println("-------- Count how many times a specific word is mentioned in the file --------");
        System.out.println("The word '" + word + "' is mentioned " + FileAnalyser.countWordOccurrences(file, word) + " times");
        System.out.println("--------");
    }

    private static void printLinesContainingWord(String file, String word) throws IOException {
        System.out.println("-------- Find lines which contain a specific word in the file --------");
        System.out.println("The word '" + word + "' is mentioned in the following lines: \n" + FileAnalyser.findLinesContainingWord(file, word));
        System.out.println("--------");
    }

    private static void printAverageLineLength(String file) throws IOException {
        System.out.println("-------- Find average line length of the file --------");
        System.out.println("Average line length: " + FileAnalyser.averageLineLength(file));
        System.out.println("--------");
    }

    private static void printAverageWordLength(String file) throws IOException {
        System.out.println("-------- Find average word length of the file --------");
        System.out.println("Average word length: " + FileAnalyser.averageWordLength(file));
        System.out.println("--------");
    }

    private static void printShortestLine(String file) throws IOException {
        System.out.println("-------- Find the shortest line in the file --------");
        System.out.println("Shortest line: " + FileAnalyser.findShortestLine(file).orElse("No lines found"));
        System.out.println("--------");
    }

    private static void printLongestLine(String file) throws IOException {
        System.out.println("-------- Find the longest line in the file --------");
        System.out.println("Longest line: " + FileAnalyser.findLongestLine(file).orElse("No lines found"));
        System.out.println("--------");
    }

    private static void printTopNLongestWords(String file, int n) throws IOException {
        System.out.println("-------- Find the top " + n + " longest words in the file --------");
        System.out.println("Longest words: " + FileAnalyser.findTopNLongestWord(file, n));
        System.out.println("--------");
    }

    private static void printFirstWordWithMoreThanNCharacters(String file, int n) throws IOException {
        System.out.println("-------- Find the first word with more than " + n + " characters in the file --------");
        System.out.println("First word with more than " + n + " characters: " + FileAnalyser.getFirstWordWithMoreThanNCharacters(file, n).orElse("No word found"));
        System.out.println("--------");
    }

    private static void printWordFrequency(String file) throws IOException {
        System.out.println("-------- Find the frequency of every word in the file --------");
        System.out.println("Word frequency: " + FileAnalyser.getWordFrequency(file));
        System.out.println("--------");
    }

    private static void printLinesContainingNumbers(String file) throws IOException {
        System.out.println("-------- Find lines that contain numbers in the file --------");
        System.out.println("Lines containing numbers: " + FileAnalyser.findLinesContainingNumbers(file));
        System.out.println("--------");
    }

    private static void printLinesMatchingRegex(String file, String regex) throws IOException {
        System.out.println("-------- Find lines that match the regex pattern in the file --------");
        System.out.println("Lines matching regex pattern '" + regex + "': " + FileAnalyser.findLinesMatchingRegex(file, regex));
        System.out.println("--------");
    }

    private static void printPalindromicWords(String file) throws IOException {
        System.out.println("-------- Find palindromic words in the file --------");
        System.out.println("Palindromic words: " + FileAnalyser.findPalindromicWords(file));
        System.out.println("--------");
    }

    private static void printCommonWordsBetweenFiles(String file1, String file2) throws IOException {
        System.out.println("-------- Find common words between the two files --------");
        System.out.println("Common words: " + FileAnalyser.findCommonWordsBetweenFiles(file1, file2));
        System.out.println("--------");
    }

}
