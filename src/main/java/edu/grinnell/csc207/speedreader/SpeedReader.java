package edu.grinnell.csc207.speedreader;

import java.io.IOException;
import java.awt.*;
import java.lang.Integer;

/**
 * Shows a grapical panel of words rendered according to the given wpm as a
 * Speed Reader. At the end, shows the number of words and sentences displayed.
 */
public class SpeedReader {
    /**
     * Shows a grapical panel of words rendered according to the given wpm as a
     * Speed Reader. At the end, shows the number of words and sentences displayed.
     * 
     * @param filename the name of the text file that is used in WordGenerator.
     * @param width    the width of the graphical panel.
     * @param height   the height of the graphical panel.
     * @param wpm      word per minute; the speed the words are shown.
     * @param fontsize the size of the font used in the graphical panel.
     * @throws InterruptedException if an in-valid filgit e name is given.
     */
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 5) {
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
        } else {
            String filename = args[0];
            int width = Integer.parseInt(args[1]);
            int height = Integer.parseInt(args[2]);
            int fontsize = Integer.parseInt(args[3]);
            int wpm = Integer.parseInt(args[4]);

            DrawingPanel panel = new DrawingPanel(width, height);
            Graphics g = panel.getGraphics();
            Font f = new Font("Courier", Font.BOLD, fontsize);
            g.setFont(f);

            try {
                WordGenerator wg = new WordGenerator(filename);

                try {
                    while (wg.hasNext()) {
                        g.setColor(Color.WHITE);
                        g.fillRect(0, 0, width, height);

                        g.setColor(Color.BLACK);
                        g.drawString(wg.next(), 100, 100);

                        Thread.sleep(60000 / wpm);
                    }

                    System.out.println("The number of words: " + wg.getWordCount() + "\n");
                    System.out.println("The number of sentences: " + wg.getSentenceCount() + "\n");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
