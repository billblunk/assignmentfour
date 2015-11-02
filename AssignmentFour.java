/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentfour;

/**
 *
 * @author Bill
 */

import java.io.*;
import java.util.Scanner;

public class AssignmentFour
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    //To create and array of 26 MyLinkedLists.

    MyLinkedList [] dictionay = new MyLinkedList[26];

    //Once the array is instantiated, all elements are null. We need to instantiate 26 MyLinkedLists to store data.

    for (int i = 0; i < dictionary.length; i++)

       dictionary[i] = new MyLinkedList<String>();  

 

    //To insert a word in to a specific MyLinkedList

    //Assume that the word you want to insert is in a String type variable called wordstr.

    dictionary [(int)wordstr.charAt(0) - 97].addFront(wordstr) ; 

    //would allow you to jump to the correct linked list. I think addFront is better since it doesn't need to traverse the list. 

 

    //To search a word in a specific MyLinkedList

    //Assume that the word you want to search is in a String type variable called wordstr.

    dictionary [(int)wordstr.charAt(0) - 97].contains(wordstr) ; 

    //would allow you to jump to the correct linked list, and the contains will return true/false depending if the word is in the list or not.

 


    }
    
}
