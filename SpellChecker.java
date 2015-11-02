/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Bill Blunk C202 IUS 
 */
public class SpellChecker
{
    private MyLinkedList [] dictionary = new MyLinkedList [26];
    private long notFoundWords;
    private long wordsFoundComparison;
    private long foundWords;
    private long wordsNotFoundComparison;
    private final int [] stringComparisons = new int[1];
    
    /**
     * Default constructor of SpellChecker objects.  Putting all counters at 0
     */
    public SpellChecker()
    {
        notFoundWords = 0;
        wordsFoundComparison = 0;
        foundWords = 0;
        wordsNotFoundComparison = 0;
        for (int i =0; i < dictionary.length; i++)
        {
            dictionary[i] = new MyLinkedList<String>();
        }
    }// end of spellChecker
    
    /* pre : empty args
     * post: read dictionary file into array / linkedlist
    */ 
    public void readDictionaryFile()
    {
        File df = new File("random_dictionary.txt");
        try{
            Scanner input = new Scanner(df);
            while (input.hasNext ()){
                String word = (input.nextLine().toLowerCase());
                dictionary [(int)word.charAt(0) - 97].addFirst(word);
            }
            input.close();
        }
        catch (Exception e)
        { // nothing to add to dictionary
            e.printStackTrace();
        }
    }// end of readDictionaryFile method
    
/* pre : empty args
 * post: compare input text file to dictionary
 */ 
    public void spellCheck()
    {
        try
        {
            FileInputStream inf = new FileInputStream(new File("oliver.txt"));
            char let;
            String str=""; //word to be processed            
            int n = 0;
            while ((n = inf.read()) != -1)
            {
                let = (char)n;
                if (Character.isLetter(let))
                {
                    str += Character.toLowerCase(let);                    
                }
                if ((Character.isWhitespace(let) || let =='-') && !str.isEmpty())
                {
                    if(dictionary[(int)str.charAt(0)-97].contains(str, stringComparisons))
                    {
                        foundWords++;
                        wordsFoundComparison += stringComparisons[0];
                    }
                    else
                    {
                        notFoundWords++;
                        wordsNotFoundComparison += stringComparisons[0];
                    }
                    str="";
                }
            }
            inf.close(); 
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }// end of spellCheck
    /**
     * Tests the methods created above.  
     * @param args
     */
    public static void main(String[] args)
    {
        SpellChecker newChecker = new SpellChecker();
        newChecker.readDictionaryFile();
        newChecker.spellCheck();        
        System.out.println("Number of misspelled words: " + newChecker.notFoundWords);
        System.out.println("Number of correct spelled words: " + 
                newChecker.foundWords);
        System.out.println("Number of misspelled words comparisons: " +
                newChecker.wordsNotFoundComparison);
        System.out.println("Number of correct spelled words comparisons: " + 
                newChecker.wordsFoundComparison);
        System.out.println("The average number of comparisons for words "
                + "found: " + newChecker.wordsFoundComparison/newChecker.foundWords);
        System.out.println("The average number of comparisons for words not"
                + "found: " + newChecker.wordsNotFoundComparison/newChecker.notFoundWords);
    }
}

