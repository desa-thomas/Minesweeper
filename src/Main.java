public class Main {
    public static void main(String[] args) {

        int width = 16;
        int length = 16;
        Board board = new Board(length, width, 40);


        board.printBoard();
        System.out.println("-".repeat(width*4));
        board.printGameBoard();
    }
}