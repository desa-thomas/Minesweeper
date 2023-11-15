import java.util.Scanner;

public class Tester {

    public static void main(String args []){

        int [] coordinates;
        int width = 16;
        int length = 16;
        Board board = new Board(length, width, 40);


        board.printBoard();
        System.out.println("-".repeat(width*4));


        Scanner keyboard = new Scanner(System.in);
        coordinates = board.getCoordinates(keyboard);
        board.checkAdjacency(coordinates[0], coordinates[1]);

    }
}

