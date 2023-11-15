import java.util.Random;
/*
class contains 2 2D arrays for minesweeper

 */
public class Board {

    private String[][] gameBoard;
    private String[][] board;
    private final int width;
    private final int height;

    /*
    constructor for Board class
     */
    public Board(int width, int height) {
        this.board = new String[width+1][height+1];
        this.width = width;
        this.height = height;

        this.gameBoard = new String[width+1][height+1];

        board[0][0] = "   ";
        gameBoard[0][0] = "   ";

        for (int x = 0; x < width+1; x++) {
            if(x!=0){
                board[x][0] = " " + x + " ";
                gameBoard[x][0] = " " + x + " ";
            }
            for (int y = 1; y < this.height+1; y++) {

                if (x == 0){
                    board[x][y] = " " + (y) + " ";
                    gameBoard[x][y] = " " + (y) + " ";
                }
                else {
                    gameBoard[x][y] = "[ ]";
                    board[x][y] = "[ ]";
                }
            }
        }

        addBombs();
    }

    /*
    helper method for constructor, randomly generates bombs and adds them to board
     */
    private void addBombs() {
        Random r = new Random();
        int randInt, x, y;
        int i = 0;

        while (i < 10) {
            randInt = r.nextInt(width * height - 1);
            x = (randInt % width) + 1;
            y = Math.floorDiv(randInt, height) +1;

            //if that spot on the board already contains a bomb, do it again
            if (this.board[x][y].equals("[B]")) {
                continue;
            } else {
                this.board[x][y] = "[B]";
                i++;
            }

        }
    }

    /*
    for troubleshooting... prints board with where bombs are
     */
    public void printBoard() {

        String str = "";

        for (String[] sArray : this.board) {

            for (String s : sArray) {
                System.out.print(s + " ");
            }

            System.out.println();
        }

    }

    public void printGameBoard() {

        String str = "";

        for (String[] sArray : this.gameBoard) {

            for (String s : sArray) {
                System.out.print(s + " ");
            }

            System.out.println();
        }
    }

}
