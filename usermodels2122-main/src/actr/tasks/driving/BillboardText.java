package actr.tasks.driving;

import java.io.*;
import java.util.ArrayList;

public class BillboardText {
  static final int MAX_LENGTH = 15;
  static String fullText;
  public static ArrayList<String[]> boards = new ArrayList<>();

  static void initialize() {
    try {
      fullText = readFile();
      createBoards();
    } catch (IOException e) {
      System.err.println("Something went wrong with reading the text file.");
      e.printStackTrace();
    }
  }

  static String readFile() throws IOException {
    String filePath = "src/resources/Text.txt";
    BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
    StringBuffer sb = new StringBuffer();
    String line = br.readLine();
    while (line != null) {
      sb.append(line);
      line = br.readLine();
    }
    br.close();
    return sb.toString() + " ";
  }

  static String generateLine() {
    String line;
    if (fullText.length() >= MAX_LENGTH) {
      line = fullText.substring(0,MAX_LENGTH);
      // resize string until last character is a space
      while (line.charAt(line.length()-1) != ' ') {
        line = line.substring(0, line.length()-1);
      }
      fullText = fullText.substring(line.length(), fullText.length());
      return line.trim();
    } else {
      line = fullText;
      fullText = "";
      return line;
    }
  }

  static void createBoards() {
    while (!fullText.isEmpty()) {
      String[] board = {generateLine(), generateLine()};
      boards.add(board);
    }
  }

  static String[] getBoard(int boardNumber) {
    return boards.get(boardNumber-1);
  }

  static void printBoards() {
    for (String[] b : boards) {
      System.out.println("Board " + boards.indexOf(b));
      System.out.println("|" + b[0] + "|");
      System.out.println("|" + b[1] + "|");
      System.out.println("---------------------------");
    }
  }

}