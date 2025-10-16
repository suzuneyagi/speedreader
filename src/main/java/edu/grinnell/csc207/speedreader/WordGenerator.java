package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;

/*
 * The WordGenerator class reads a text file from the command line, provides methods 
 * that show the words one by one (one per line) by determining if there is a word next and 
 * shows it if there is, as well as methods for reporting the number of words and sentences.
 */
public class WordGenerator {
    private Scanner text;
    private int wordcount;
    private int sentencecount;

    /**
     * constructs a new generator that processes text from the given file.
     * @param filename the file to read from 
     * @throws IOException when they fail to read files 
     */
    public WordGenerator(String filename) throws IOException {
        text = new Scanner(new File(filename));
        wordcount = 0;
        sentencecount = 0;
    }

    /**
     * Checks if there is text left to process
     * @return true if the underlying Scanner of this WordGenerator has text left to process.
     */
    public boolean hasNext() {
        return text.hasNext();
    }

    /**
     * Returns the next word of the underlying Scanner
     * @return the next word of the underlying Scanner. If the Scanner does not have
     * words left, then the behavior of next() is undefined
     */
    public String next() {
        String word = text.next();
        wordcount++;

        int n = word.length() - 1;

        if (word.charAt(n) == '.' || word.charAt(n) == '!' || word.charAt(n) == '?') {
            sentencecount++;
        }

        return word;
    }

    /**
     * Returns the number of words processed so far
     * @return the number of words produced by the WordGenerator so far.
     */
    public int getWordCount() {
        return wordcount;
    }

    /**
     * Returns the number of sentences processed so far
     * @return the number of sentences produced by the WordGenerator so far. Define
     * a sentence to be the number of occurrences of words
     *  where a punctuation mark appears at the end---'.', '!', or '?'.
     */
    public int getSentenceCount() {
        return sentencecount;
    }
}