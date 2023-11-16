import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length;
        int width;
        int mines;
        String difficulty;
        String line = "-".repeat(20);
        Scanner keyboard = new Scanner(System.in);

        System.out.println(line + "MINESWEEPER"+ line);
        System.out.println("- Numbers on tiles represent the number of adjacent bombs");
        System.out.println("- Flagged tiles are represented by a star *");
        System.out.println("- Reveal all tiles without bombs to win");
        System.out.println("Select Difficulty (E, M, H): ");
        difficulty = keyboard.next();

        while(!difficulty.equalsIgnoreCase("E") && !difficulty.equalsIgnoreCase("M") && !difficulty.equalsIgnoreCase("H")){
            System.err.println("Not a Valid Difficulty");
            System.out.println("Select Difficulty (E, M, H): ");
            difficulty = keyboard.next();

        }

        if(difficulty.equalsIgnoreCase("E")){
            length = 9;
            width = 9;
            mines = 10;
        }

        else if(difficulty.equalsIgnoreCase("M")){
            length = 16;
            width = 16;
            mines = 40;
        }

        else{
            length = 16;
            width = 30;
            mines = 99;
        }

        Minesweeper game = new Minesweeper(length, width, mines);

        game.startGame(keyboard);

        keyboard.close();
    }


}