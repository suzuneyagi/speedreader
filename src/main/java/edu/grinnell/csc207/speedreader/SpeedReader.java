package edu.grinnell.csc207.speedreader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.lang.Integer;

/**
 * 
 */
public class SpeedReader{
    /**
     * Shows a grapical panel of words rendered according to the given wpm as a Speed Reader. At the end, shows the number of words and sentences displayed.
     * 
     * @param filename the name of the text file that is used in WordGenerator.
     * @param width the width of the graphical panel.
     * @param height the height of the graphical panel.
     * @param wpm word per minute; the speed the words are shown.
     * @param fontsize the size of the font used in the graphical panel.
     * @throws InterruptedException if an in-valid file name is given.
     */
    public static void main(String[] args) throws InterruptedException{
        if (args.length != 5){
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
        } else{
            String filename = args[0];
            int width = Integer.parseInt(args[1]);
            int height = Integer.parseInt(args[2]);
            int wpm = Integer.parseInt(args[3]);
            int fontsize = Integer.parseInt(args[4]);

            DrawingPanel panel = new DrawingPanel(width, height);
            Graphics g = panel.getGraphics();
            Font f = new Font("Courier", Font.BOLD, fontsize);
            g.setFont(f);

            try{
                WordGenerator wg = new WordGenerator(filename);

                try{
                    while(wg.hasNext()) {
                        g.setColor(Color.WHITE);
                        g.fillRect(0, 0, width, height);

                        g.setColor(Color.BLACK);
                        g.drawString(wg.next(), 100, 100);

                        Thread.sleep(wpm);
                    }

                    System.out.println("The number of words: " + wg.getWordCount() + "\n");
                    System.out.println("The number of sentences: " + wg.getSentenceCount() + "\n");
                } catch (InterruptedException e) { 
                    Thread.currentThread().interrupt(); 
                }
            }catch(IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }

    

    // public static void demonstratePanel() {
    //     DrawingPanel panel = new DrawingPanel(400, 300);
    //     Graphics g = panel.getGraphics();
    //     Font f = new Font("Courier", Font.BOLD, 46);
    //     g.setFont(f);
    //     try{
    //         WordGenerator wg = new WordGenerator("our_file.txt");
    //         g.drawString(wg.next(), 100, 100);
    //     } catch(IOException e) {
    //         System.out.println("Error reading file: " + e.getMessage());
    //     }
    // }

    // public static void printStaggered() throws InterruptedException {
    //     try{
    //         while(true) {
    //             System.out.println("Hello World!");The names and Grinnell emails of your participant(s).
    //             Thread.sleep(1000);
    //         }
    //     } catch (InterruptedException e) { 
    //         Thread.currentThread().interrupt(); 
    //     }
    // }



}
