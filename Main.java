import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    //Clear the console
    System.out.print("\033[2J\033[1;1H");

    //Create a UserInput object
    UserInput ui = new UserInput();

    //Prompt user for a story
    int storyNum = ui.getUserInput("Select a story (1, 2, or 3): ", 1, 3);
    
    //Create an ArrayList to hold the Mad Lib text
    ArrayList<String> story = new ArrayList<String>();
    //System.out.println("Getting story...");
    //Call getStory to add the selected story
    story = getStory(storyNum, story);
    //System.out.println("gotten story");
    System.out.println("");
    String total = parseStory(story, ui);

    //Display the Mad Lib with all the changes
    display("\n\n" + total);

    //Ask user to save
    boolean willSave = ui.getUserInput("Save this Mad Lib? (Y/n) ", true);
    if (willSave) {
      FileHandler fHandler = new FileHandler();
      String url = "SavedStories/";

      String filename = ui.getUserInput("Filename");
      boolean validation = fHandler.writeNewFile(url + filename + ".txt");
      if (!validation) {
        willSave = ui.getUserInput("Overwrite? (Y/n)", true);
        if (willSave) {
          fHandler.writeToFile(url + filename + ".txt", total);
        }
      } else {
        fHandler.writeToFile(url + filename + ".txt", total);
      }
    } else {
      System.out.println("Mad Lib not saved.");
    }
  }

  static void display(String text) {
    System.out.println(text);
  }

  static String parseStory(ArrayList<String> list, UserInput ui) {
    ArrayList<String> lines = new ArrayList<String>(list);
    String text = "";
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
          
          //calls ui.getUserInput and passes the prompt word in
          text += ui.getUserInput(prompt);
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
      case 2: {
        list = readFile("Stories/IfYouGiveA.txt");
      }
      break;
      case 3: {
        list = readFile("Stories/TheSnowballFight.txt");
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
}