public class Main {
    public static void main(String[] args) {

        Board board = new Board(9, 9);

        board.printBoard();
        System.out.println("-".repeat(40));
        board.printGameBoard();
    }
}