package edu.grinnell.csc207.speedreader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;

/*
 * The WordGenerator class reads a text file from the command line, provides methods that show the words one by one (one per line)
 * by determining if there is a word next and shows it if there is, as well as methods for reporting the number of words and sentences.
 */
public class WordGenerator {
    private Scanner text;
    private int wordcount;
    private int sentencecount;

    public WordGenerator(String filename) throws IOException{
        /* constructs a new generator that processes text from the given file. */
        text = new Scanner(new File(filename));
        wordcount = 0;
        sentencecount = 0;
    }

    public boolean hasNext(){
        /* returns true iff the underlying Scanner of this WordGenerator has text left to process. */
       return text.hasNext();
    }

    public String next(){
        /* returns the next word of the underlying Scanner. If the Scanner does not have words left, then the behavior of next() is undefined */
        String word = text.next();
        wordcount++;

        int n = word.length() - 1;

        if (word.charAt(n) == '.' || word.charAt(n) == '!' || word.charAt(n) == '?'){
            sentencecount++;
        }

        return word;
    }

    public int getWordCount(){
        /* returns the number of words produced by the WordGenerator so far.*/
        return wordcount;
    }

    public int getSentenceCount(){
        /* returns the number of sentences produced by the WordGenerator so far. Define a sentence to be the number of occurrences of words 
           where a punctuation mark appears at the end---'.', '!', or '?'. */ 
        return sentencecount;
    }

    // public static void main(String[] args){
    //     try{
    //         WordGenerator our_text = new WordGenerator("our_file.txt");
    //         while (our_text.hasNext()) {
    //             System.out.println(our_text.next());
    //         }
    //         System.out.println("The number of words: " + our_text.getWordCount() + "\n");
    //         System.out.println("The number of sentences: " + our_text.getSentenceCount() + "\n");
    //     } catch (IOException e) {
    //         System.out.println("Error reading file: " + e.getMessage());
    //     }
    // }
}