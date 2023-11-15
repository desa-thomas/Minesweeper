import java.util.Scanner;
/*
Class to help with test board methods
 */
public class Tester {

    public static void main(String []args){

        int [] coordinates;
        int width = 16;
        int length = 16;
        Minesweeper minesweeper= new Minesweeper(length, width, 40);
        String line = "-".repeat(width*4);
        Scanner keyboard = new Scanner(System.in);

        minesweeper.printBoard();
        System.out.println(line);
        System.out.println(line);
        coordinates = minesweeper.getCoordinates(keyboard);
        int x = coordinates[0];
        int y = coordinates[1];

        minesweeper.revealTile(x, y);

        minesweeper.printGameBoard();




    }

    public static void testAdjacency(Minesweeper board){
        int [] coordinates;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Q to quit testing: ");
        String s = keyboard.nextLine();
        while(!s.equals("Q")) {
            coordinates = board.getCoordinates(keyboard);
            System.out.println("Adjacency: "+ board.checkAdjacency(coordinates[0], coordinates[1]));
            System.out.println("Q to quit testing: ");
            s = keyboard.nextLine();
        }
        keyboard.close();
    }
}

