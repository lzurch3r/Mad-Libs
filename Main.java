import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //Create an empty String to use as display
    String total = "";
    //Create an ArrayList to hold the Mad Lib text
    ArrayList<String> story = new ArrayList<String>();

    //Call getStory to add the selected story
    getStory(story);

    Iterator iter = story.iterator();
    while (iter.hasNext()) {
      total += iter.next();
    }
    System.out.println(total);
  }

  static void getStory(ArrayList<String> list) {
    list.add("Long ago, in the year " + getUserInput(0));
    list.add(", there was a(n) " + getUserInput("Adjective") + " [proper noun]");
    list.add(". It's name was [name]");
    list.add(".");
  }

  static String getUserInput(String wordType) {
    //Prompts the user for a number
    System.out.print(wordType + ": ");

    //Gets user input and assign it to word
    Scanner input = new Scanner(System.in);
    String word = "";
    word += input.nextLine();

    //Return user word
    return word;
  }
  static int getUserInput(int num) {
    //Prompts the user for a number
    System.out.print("Number: ");

    //Gets user input and assign it to num
    Scanner input = new Scanner(System.in);
    num = input.nextInt();

    //Return user number
    return num;
  }
}