import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {
    //Prompt user for a story
    int storyNum = getUserInput("Select a story (1, 2, or 3): ", 1, 3);
    

    //Create an empty String to use as display
    String total = "";
    //Create an ArrayList to hold the Mad Lib text
    ArrayList<String> story = new ArrayList<String>();
    //System.out.println("Getting story...");
    //Call getStory to add the selected story
    story = getStory(storyNum, story);
    //System.out.println("gotten story");

    for (int i = 0; i < story.size(); i++) {
      total += story.get(i);
    }

    System.out.println(total);
  }

  static ArrayList<String> getStory(int storyNum, ArrayList<String> list) {
    //System.out.println("Story #" + storyNum + " selected, reading...");
    switch (storyNum) {
      case 1: {
        list = readFile("Stories/VacationFun.txt");
      }
      break;
      default: {
        list = readFile("Stories/default.txt");
      }
    }
    return list;
  }

  static ArrayList<String> readFile(String fileName) {
    ArrayList<String> text = new ArrayList<String>();
    try {
      File madLibFile = new File(fileName);
      Scanner fileReader = new Scanner(madLibFile);
      while (fileReader.hasNextLine()) {
        text.add(fileReader.nextLine());
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //System.out.println("Read complete.\n" + text.get(0));
    return text;
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
  static int getUserInput(String prompt, int num) {
    //Prompts the user for a number
    System.out.print(prompt);

    //Gets user input and assign it to num
    Scanner input = new Scanner(System.in);
    num = input.nextInt();

    //Return user number
    return num;
  }
  static int getUserInput(String prompt, int min, int max) {
    int num = -1;
    boolean validation = false;
    //Prompts the user for a number
    System.out.print(prompt);

    //Gets user input and assign it to num
    while (!validation) {
      try {
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        if (num >= min && num <= max)
          validation = true;
        else {
          System.out.print("Invalid input. Must be a number between " + min + " and " + max + ": ");
        }
      } catch (Exception e) {
        System.out.print("Invalid input. Must be a number between " + min + " and " + max + ": ");
        //e.printStackTrace();

      }
    }

    /*while (num < min || num > max) {
      System.out.print("Please enter a number between " + min + " and " + max + ": ");
      Scanner newInput = new Scanner(System.in);
      num = newInput.nextInt();
    }*/

    //Return user number
    return num;
  }
}