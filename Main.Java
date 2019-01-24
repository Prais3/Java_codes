/*
Author: Varun Jani
Purpose: Java application that implements a simple word search game
Compiler/IDE: IntelJ
Operating system: Windows 10
*/

import java.util.Scanner;
import java.lang.String;

public class Main
{
    public static void main(String[] args)
    {
        Scanner ip = new Scanner(System.in);
        System.out.print("Please enter a string representing a word search puzzle: ");

        String puzzle;
        int k = 0;

        String _puzzle_ = ip.nextLine();
        String temp = "";

        System.out.println("\nPuzzle: ");

        char t;
        int length = _puzzle_.length();

        //This for loop is implemented to print the puzzle with # meaning go to next line
        for (int i = 0; i < length; i++)
        {
            t = _puzzle_.charAt(i);

            if (t == '#')
            {
                puzzle = _puzzle_.substring(k, i);
                k = i + 1;
                System.out.println(puzzle);
            }

            if (t == ' ')
            {
                puzzle = _puzzle_.substring(k, i + 1);
                k = i + 1;
                System.out.print(puzzle + " ");
            }

            if (t != ' ')
            {
                temp = temp + _puzzle_.charAt(i);
            }
        }

        _puzzle_ = temp;

        length = _puzzle_.length();

        boolean _play_ = true;
        boolean play_again = true;

        System.out.println("\n\n******************************************************************************");

        while(play_again)
        {
            while (_play_)
            {

                System.out.println("Please enter a word to search for: ");
                String word = ip.next();

                int len = word.length();
                boolean flag = false;
                int pos;
                String s = "";

                word = word.toUpperCase();

                //This for loop is for searching the word in FORWARD in the Puzzle
                for (int i = 0; i < length; i++)
                {
                    t = _puzzle_.charAt(i);

                    if (t == word.charAt(0))
                    {
                        pos = i;

                        for (int j = 0; j < len; j++)
                        {
                            if (pos < _puzzle_.length())
                            {
                                if (_puzzle_.charAt(pos) == word.charAt(j))
                                {
                                    s = s + word.charAt(j);
                                    pos++;
                                }
                            }
                        }
                        if (word.equals(s)) {
                            flag = true;
                            break;
                        }
                        s = "";
                    }
                }

                //This if-else is to print whether the word is word in FORWARD direction
                if (flag == true)
                    System.out.println("Search word " + '"' + word.toUpperCase() + '"' + " found!!");
                else
                    System.out.println("Search word " + '"' + word.toUpperCase() + '"' + " not found!!!");

                s = "";
                flag = false;

                //This for loop is for checking the word in REVERSE in the Puzzle
                for (int i = length - 1; i > 0; i--)
                {
                    t = _puzzle_.charAt(i);

                    if (t == word.charAt(0))
                    {
                        pos = i;
                        for (int j = 0; j < len; j++)
                        {
                            if (_puzzle_.charAt(pos) == word.charAt(j))
                            {
                                s = s + word.charAt(j);
                                pos--;
                            }
                        }
                        if (word.equals(s)) {
                            flag = true;
                            break;
                        }
                        s = "";
                    }
                }

                //This if-else prints whether the word is found in REVERSED or not
                if (flag == true)
                    System.out.println("Search word " + '"' + word.toUpperCase() + '"' + " found reversed!!");
                else
                    System.out.println("Search word " + '"' + word.toUpperCase() + '"' + " not found reversed!!!");

                //This if-else is to ask the user to search for another word
                System.out.println("\nSearch for another word? (Y/N): ");
                String _temp_ = ip.next();
                if (_temp_.charAt(0) == 'Y' || _temp_.charAt(0) == 'y')
                {
                    _play_ = true;
                    System.out.println("******************************************************************************");
                }
                else
                {
                    System.out.println("******************************************************************************");
                    break;
                }
            }

            //This if-else asks the user if he wants to play the game again or not
            System.out.println("Play Again? (Y/N)");
            String _temp = ip.next();
            if(_temp.charAt(0) == 'Y' || _temp.charAt(0) == 'y')
            {
                play_again = true;
                System.out.println("******************************************************************************");
            }
            else
            {
                System.out.println("\nThanks for playing!");
                System.out.println("******************************************************************************");
                break;
            }
        }
    }
}
