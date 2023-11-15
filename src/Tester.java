import java.util.Scanner;
/*
Class to help with test board methods
 */
public class Tester {

    public static void main(String []args){

        int [] coordinates;
        int width = 16;
        int length = 16;
        Board board = new Board(length, width, 40);


        board.printBoard();
        System.out.println("-".repeat(width*4));


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Q to quit testing: ");
        String s = keyboard.nextLine();
        while(!s.equals("Q")) {
            coordinates = board.getCoordinates(keyboard);
            System.out.println("Adjacency: "+ board.checkAdjacency(coordinates[0], coordinates[1]));
            System.out.println("Q to quit testing: ");
            s = keyboard.nextLine();
        }
    }
}

