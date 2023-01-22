import java.util.Scanner;

public class UserInput {
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
  static boolean getUserInput(String prompt, boolean isBool) {
    char letter = ' ';
    boolean willSave = false;
    boolean validation = false;
    //Prompts the user for a number
    System.out.print(prompt);

    //Gets user input and assign it to word
    while (!validation) {
      try {
        Scanner input = new Scanner(System.in);
        letter = input.next(".").charAt(0);
       //System.out.println(letter);
        if (letter == 'Y' || letter == 'y' || letter == 'N' || letter == 'n') {
          //System.out.println("Validating...");
          validation = true;
        } else {
          System.out.print("Please enter Y/n: ");
        }
      } catch (Exception e) {
        System.out.print("Please enter Y/n: ");
      }

      if (letter == 'Y' || letter == 'y')
        willSave = true;
    }

    //Return user word
    return willSave;
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

    //Return user number
    return num;
  }
}
