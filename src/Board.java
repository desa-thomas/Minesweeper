import java.util.Random;
/*
class contains 2 2D arrays for minesweeper

 */
public class Board {

    private String[][] gameBoard;
    public String[][] board;
    private final int width;
    private final int length;
    private final int BOMBS;

    /*
    constructor for Board class
     */
    public Board(int length, int width, int bombs) {
        this.board = new String[length +1][width +1];
        this.length = length;
        this.width = width;
        this.BOMBS = bombs;

        this.gameBoard = new String[length +1][width +1];

        board[0][0] = "   ";
        gameBoard[0][0] = "   ";

        for (int x = 0; x < length +1; x++) {
            if(x!=0 && x < 10){
                board[x][0] = " " + x + " ";
                gameBoard[x][0] = " " + x + " ";
            }

            else if(x != 0){
                board[x][0] = x +" ";
                gameBoard[x][0] = x +" ";
            }
            for (int y = 1; y < width +1; y++) {

                if (x == 0 && y < 10){
                    board[0][y] = " " + y + " ";
                    gameBoard[0][y] = " " + y + " ";
                }
                else if(x ==0){
                    board[0][y] = " " + y;
                    gameBoard[0][y] = " " + y;
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

        while (i < BOMBS) {
            x = r.nextInt(1, length+1);
            y = r.nextInt(1, width+1);

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
    reveals tile on gameBoard:
        1. if tile is a bomb end the game
        2. If tile is adjacent to bomb(s) put the number of bombs its adjacent to
        3. If tile is not adjacent to any bomb, keep revealing adjacent tiles until there are no more adjacent tiles
           with no adjacent bombs
     */
    public void revealTile(){}

    /*
    checks the amount of adjacent bombs to tile with coordinates (x, y)
    @param x, y coordinates of tile to check
     */
    private int checkAdjacency(int x, int y){
        return 0;
    }

    /*
    for troubleshooting... prints hidden board with where bombs are
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

    /*
    prints game boards with hidden tiles
     */
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
