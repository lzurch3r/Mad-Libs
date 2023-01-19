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
    System.out.println("");
    String display = parseStory(story);

    /*for (int i = 0; i < story.size(); i++) {
      total += story.get(i);
    }*/

    //Display the Mad Lib with all the changes
    System.out.println(display);
  }

  static String parseStory(ArrayList<String> list) {
    ArrayList<String> lines = new ArrayList<String>(list);
    String text = "\n\n";
    //Advanced for loop to read a line from the list and parse out the user input lines
    for (String line : lines) {
      //Standard for loop to iterate through each character in the text
      for (int i = 0; i < line.length(); i++) {
        //System.out.println(line.charAt(i));

        
      //stops reading when the iterator encounters an open square bracket [
        if (line.charAt(i) == '[') {
          //System.out.println("Reached a '['");
          boolean ending = false;
          String prompt = "";
          int n = i + 1;
          
          //writes the adjoining word into a separate String until iterator encounters a closed square bracket ]
          while (!ending) {
            if (line.charAt(n) == ']') {
              //System.out.println("Reached a ']'");
              ending = true;
            }
            else {
              prompt += line.charAt(n);
              n++;
            }

          }
          
          //calls getUserInput and passes the prompt word in
          text += getUserInput(prompt);
          i = n;
        }
        else {
          //Adds each non-prompt character to the String text
          text += line.charAt(i);
        }

      }
      text += "\n";
    }
    //System.out.println(lines.get(0));

    return text;
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
    String word = "";
    boolean validation = false;
    //Prompts the user for a number
    System.out.print(wordType + ": ");

    //Gets user input and assign it to word
    while (!validation) {
      try {
        Scanner input = new Scanner(System.in);
        word += input.nextLine();
        validation = true;
      } catch (Exception e) {
        System.out.print("Can't accept that. Please enter a/an " + wordType);
      }
    }

    //Return user word
    return word;
  }
  static int getUserInput(String prompt, int num) {
    boolean validation = false;
    //Prompts the user for a number
    System.out.print(prompt);

    //Gets user input and assign it to num
    while (!validation) {
      try {
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        validation = true;
      } catch (Exception e) {
        System.out.print(prompt);
      }
    }

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
          System.out.print("Can't accept that. Must be a number between " + min + " and " + max + ": ");
        }
      } catch (Exception e) {
        System.out.print("Can't accept that. Must be a number between " + min + " and " + max + ": ");
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