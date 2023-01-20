import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
  static boolean writeNewFile(String filename) {
    try {
        File myObj = new File(filename);
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
            return false;
        }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return true;
  }

  static void writeToFile(String filename, String output) {
    try {
      FileWriter myWriter = new FileWriter(filename);
      myWriter.write(output);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  static void deleteFile(String filename) {
    try {
      File myObj = new File(filename);
      if (myObj.delete()) {
        System.out.println("Deleted the file: " + myObj.getName());
      } else {
        System.out.println("Failed to delete the file.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}