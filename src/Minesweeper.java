import javax.naming.ldap.StartTlsRequest;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
Minesweeper game class
 */
public class Minesweeper {

    /*
    gameBoard - board with unrevealed tiles
    board - hidden board that shows where bombs are,,, for troubleshooting purposes
    width - width of board
    length - length of board (or vertical height)
    BOMBS - number of bombs on board
     */
    private final String[][] gameBoard;
    private final String[][] board;
    private final int width;
    private final int length;
    private final int MINES;
    private int revealedTiles = 0;
    private final int ttlTiles;
    private final String line;


    /*
    constructor for Board class
     */
    public Minesweeper(int length, int width, int mines) {
        this.board = new String[length +1][width +1];
        this.length = length;
        this.width = width;
        this.MINES = mines;
        this.line = "-".repeat((width+1)*4);
        this.ttlTiles = length * width;

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
        int x, y;
        int i = 0;

        while (i < MINES) {
            x = r.nextInt(1, length+1);
            y = r.nextInt(1, width+1);

            //if that spot on the board already contains a bomb, do it again
            if (this.board[x][y].equals("[B]")) {
                continue;
            }

            this.board[x][y] = "[B]";
            i++;


        }
    }

    /*
    reveals tile on gameBoard with coordinates (x, y):
        1. if tile is a bomb end the game
        else:
        2. If tile is adjacent to bomb(s) put the number of bombs its adjacent to
        3. If tile is not adjacent to any bomb, keep revealing adjacent tiles until there are no more adjacent tiles
           with no adjacent bombs
     */
    private int revealTile(int x, int y){
        int tile = -900;

        //if tile isn't bomb
        if(!board[x][y].equals("[B]")){

            int adj = checkAdjacency(x, y);

            if(adj !=0){
                revealedTiles += 1;
                gameBoard[x][y] = "["+adj+"]";
                tile = adj;
            }
            else{
                recursiveReveal(x,y);
                tile = 0;
            }
        }

        return tile;
    }

    /*
    checks the amount of adjacent bombs to tile with coordinates (x, y)
    Don't run on a tile with a Bomb
    @param x, y coordinates of tile to check
    @return
     */
    public int checkAdjacency(int x, int y){

        int ttlAdjacent = -1;

        if(validCoords(x, y)) {

            if (board[x][y].equals("[B]")) System.err.println("Can't check adjacency of bomb");


            else {
                ttlAdjacent = 0;
                for (int xIncrement = -1; xIncrement <= 1; xIncrement++) {

                    for (int yIncrement = -1; yIncrement <= 1; yIncrement++) {

                        if ((x + xIncrement) > length || (y + yIncrement) > width) continue;

                        ttlAdjacent += board[x + xIncrement][y + yIncrement].equals("[B]") ? 1 : 0;
                    }
                }
            }
        }
        return ttlAdjacent;
    }

    /*
    Recursively reveals tiles adjacent to tiles with no bombs adjacent to it
    only run it on tiles with 0 adjacent bombs
     */
    private void recursiveReveal(int x, int y){
        revealedTiles += 1;
        gameBoard[x][y] = "   ";
        int adj;

        //check adjacency for all tiles adjacent to it
        for(int xIncrement = -1; xIncrement <= 1; xIncrement++){
            for(int yIncrement = -1; yIncrement <= 1; yIncrement++){

                int adjX = x + xIncrement;
                int adjY = y + yIncrement;

                if(!validCoords(adjX, adjY)) continue;

                adj = checkAdjacency(adjX, adjY);

                if (adj != 0 ){
                    if(gameBoard[adjX][adjY].equals("[ ]")) revealedTiles += 1;

                    gameBoard[adjX][adjY] = "[" + adj + "]";

                }
                else if (!gameBoard[adjX][adjY].equals("   ")){
                    recursiveReveal(adjX, adjY);
                }
            }
        }
    }

    /*
    private helper method, returns true if coordinates x and y are valid
     */
    private boolean validCoords(int x, int y){

        return !(x<1 || x > length || y < 1 || y >width);
    }

    /*
    for troubleshooting... prints  the hidden board with where bombs are
     */
    public void printBoard() {

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

        for (String[] sArray : this.gameBoard) {

            for (String s : sArray) {
                System.out.print(s + " ");
            }

            System.out.println();
        }
    }

    /*
    gets coordinates from keyboard input, used for troubleshooting and terminal gameplay
    @param keyboard Scanner object
    @return 2D array length 2 containing (x, y) coordinates (coordinates[0] = x  and coordinates[1] = y)
     */
    public int [] getCoordinates (Scanner keyboard) {
        int [] coordinates = new int[2];
        boolean gettingCoords = true;

        while(gettingCoords) {
            System.out.println("Enter coordinates x y: ");
            try {
                int x = keyboard.nextInt();
                int y = keyboard.nextInt();

                if (!validCoords(x, y)) {
                    throw new BadCoordinateException(length, width);
                }

                else {
                    coordinates[0] = x;
                    coordinates[1] = y;
                    gettingCoords = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Not a pair of integers");
                keyboard.nextLine();
            } catch (BadCoordinateException e) {
                System.err.println(e.getMessage());
                keyboard.nextLine();
            }
        }
        return coordinates;

    }

    /*
    private helper class that extends exception. Throws exception if keyboard inputs bad coordintates
     */
    private static class BadCoordinateException extends Exception{
        int length, width;
        public BadCoordinateException(int length, int width){
            super("Coordinates Not In Range");
            this.length = length;
            this.width = width;
        }
    }

    /*
    method that gets action from keyboard input:
    action can either be f for flag, or r for reveal
     */
    private String getAction(Scanner keyboard){
        boolean getting = true;
        String action = "";

        while(getting){
            System.out.println("Enter Action (f - flag, r - reveal, 0 - quit): ");
            action = keyboard.next();

            if (!action.equalsIgnoreCase("f") && !action.equalsIgnoreCase("r") && !action.equals("0")){
                System.err.println("Not a Valid Action");
            }
            else{
                getting = false;
            }
        }
        return action;

    }

    /*

     */
    private void flagTile(int x, int y){

        if(gameBoard[x][y].equals(" * ")){
            gameBoard[x][y] = "[ ]";
        }
        else {
            gameBoard[x][y] = " * ";
        }
    }

    /*
    game loop, to be executed in the Main classes main method.
     */
    public void startGame(Scanner keyboard){
        boolean game = true;
        int [] coords;
        int x;
        int y;
        String action;

        while(game){
            System.out.println(line);
            System.out.println("MINES: " + MINES);
            System.out.println("REVEALED: "+ revealedTiles);
            System.out.println("TTL TILES: " + (ttlTiles-MINES));
            printGameBoard();
            System.out.println(line);
            action = getAction(keyboard);

            if(action.equals("0")){
                game = false;
                keyboard.nextLine();
                continue;
            }

            coords = getCoordinates(keyboard);
            x = coords[0];
            y = coords[1];

            if(action.equalsIgnoreCase("r") ){
                //if they want to reveal a tile that's already revealed
                while((!gameBoard[x][y].equals("[ ]") && !gameBoard[x][y].equals(" * "))) {
                    System.err.println("Tile Already Revealed");
                    coords = getCoordinates(keyboard);
                    x = coords[0];
                    y = coords[1];
                }
            }

            //flag tile
            if(action.equalsIgnoreCase("f")){
                flagTile(x, y);
            }

            //if player reveals tile
            else if (action.equalsIgnoreCase("r")){

                //if player reveals a bomb end game and show all bombs
                if (revealTile(x, y) < 0) {
                    game = false;
                    System.out.println(line);
                    printBoard();
                    System.out.println(line);
                    System.out.println("-".repeat(((width+1)*4)/2 - 4) + "GAME OVER" + "-".repeat(((width+1)*4)/2 - 4));
                    keyboard.nextLine();
                }

                //if player reveals all tiles that aren't bombs
                else if(revealedTiles == ttlTiles - MINES){
                    game = false;
                    printGameBoard();
                    System.out.println("-".repeat(((width+1)*4)/2 - 3) + "YOU WIN" + "-".repeat(((width+1)*4)/2 - 3));
                    keyboard.nextLine();
                }
            }

        }

    }

}
