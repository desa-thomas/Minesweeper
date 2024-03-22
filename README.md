# Minesweeper in Terminal 

Minesweeper in terminal is the classic Minesweeper single player logic game written in Java and playable in the terminal. 

## Playing the game 
### 1. Download and run the Main.java file 
### 2. Select Difficulty (E, M, H):
   - `E` has a 9x9 grid and 10 bombs
   - `M` has a 16x16 grid and 40 bombs
   - `H` has a 16x30 grid  with 99 bombs <br/><br>
   <table align = center> 
     <tr> 
       <th> 'E' Gameboard </th>
     </tr>
     <tr> 
       <td>
        <pre> 
 Select Difficulty (E, M, H): 
 e
----------------------------------------
MINES: 10
REVEALED: 0
TTL TILES: 71
     1   2   3   4   5   6   7   8   9
 1  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 2  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 3  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 4  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 5  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 6  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 7  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 8  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 9  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
----------------------------------------
        </pre>
       </td>
     </tr>
   </table>

  
### 3. Action commands: <br/>
   `Enter Action (f - flag, r - reveal, 0 - quit):`<br/>
   `Enter coordinates x y: ` <br/>
  
   Entering a command such as: `f 3 4` will flag the tile with coordinates x = 3, y = 4, replacing the square brackets `[ ]` with an asterisk ` * `, whereas `r 3 4` will reveal the tile replacing the     brackets or asterisk, with the number of bombs adjacent to that tile:
   <table align = "center"> 
     <tr> 
       <th align = "center"> Flagged </th>
       <th align = "center"> Revealed </th>
     </tr>
     <tr> 
       <td> 
        <pre>
----------------------------------------
MINES: 10
REVEALED: 0
TTL TILES: 71
     1   2   3   4   5   6   7   8   9
 1  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 2  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 3  [ ] [ ] [ ]  *  [ ] [ ] [ ] [ ] [ ]
 4  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 5  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] 
 6  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 7  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 8  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 9  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
----------------------------------------
        </pre>
       </td>
       <td> 
          <pre>
----------------------------------------
MINES: 10
REVEALED: 1
TTL TILES: 71
     1   2   3   4   5   6   7   8   9
 1  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 2  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 3  [ ] [ ] [ ] [1] [ ] [ ] [ ] [ ] [ ]
 4  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 5  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 6  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 7  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 8  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 9  [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
----------------------------------------
         </pre>
       </td>
     </tr>
   </table>

### 4. Winning the game 
To win the game you must reveal all tiles on the board which are not bombs, i.e, when your `REVEALED` count on the top right equals the `TTL TILES` value 
   <table align = "center"> 
     <tr> 
       <th align = "center"> Losing the game</th>
       <th align = "center"> Winning the game </th>
     </tr>
     <tr> 
       <td> 
        <pre>
Enter Action (f - flag, r - reveal, 0 - quit):
r 4 1
Enter coordinates x y:
     1   2   3   4   5   6   7   8   9
 1  [1]  *  [2] [ ] [ ]  *   *  [1]
 2  [2] [3]  *  [1] [1] [2] [2] [1]
 3  [2]  *  [2] [1]
 4   B  [2] [1] [1] [1] [1]
 5  [1] [1]     [1]  *  [1]
 6      [1] [2] [4] [3] [2]
 7      [1]  *   *   *  [1]
 8      [1] [2] [3] [2] [1]
 9
----------------GAME OVER----------------
Continue playing (Y - yes, anything else no):
        </pre>
       </td>
       <td> 
          <pre>
Enter Action (f - flag, r - reveal, 0 - quit):
r 7 7
Enter coordinates x y:
     1   2   3   4   5   6   7   8   9
 1
 2  [1] [1]                     [1] [1]
 3   *  [2] [1] [1]             [1]  *
 4  [2] [3]  *  [2] [1] [1]     [1] [1]
 5   *  [2] [1] [2]  *  [2] [1] [1]
 6  [1] [1]     [1] [1] [2]  *  [1]
 7          [1] [1] [1] [2] [2] [2]
 8  [1] [2] [2]  *  [1] [1]  *  [1]
 9   *  [2]  *  [2] [1] [1] [1] [1]
-----------------YOU WIN-----------------
Continue playing (Y - yes, anything else no):
         </pre>
       </td>
     </tr>
   </table>



