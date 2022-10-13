/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    int row = 3, col = 3;//to be changed probably
    private int turnsLeft = row * col;
    private boolean turnOfPlayerZero = true;
    private int[][] tiles = new int[row][col];

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int ID of the next player.
     */
    public int getNextPlayer()
    {
        if(turnOfPlayerZero)
            return 0;
        return 1;
    }

    /**
     * Attempts to let the current player play at the given button. If the
     * attempt is successful the current player has ended his turn, and it is the
     * next players turn.
     *
     * @param r
     * @param c
     * @param btn gets the button pressed by the user
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */

    public boolean play(int r, int c, Button btn)
    {
        if(!isGameOver() && turnsLeft > 0){
            turnOfPlayerZero = !turnOfPlayerZero;
            turnsLeft--;
            if(turnOfPlayerZero)
                tiles[r][c] = 1;
            else
                tiles[r][c] = 2;
            btn.setDisable(true);
            return true;
        }

        return false;
    }


    public boolean isGameOver()
    {
        return getWinner() >= 0 || noTilesLeft();
    }

    private boolean noTilesLeft() {

        return turnsLeft == 0;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     *
     */
    public int getWinner()
    {
        if(checkHorizontally())
            if(turnOfPlayerZero)
                return 1;
            else
                return 0;

        if(checkVertically())
            if(turnOfPlayerZero)
                return 1;
            else
                return 0;

        if(checkDiagonally())
            if(turnOfPlayerZero)
                return 1;
            else
                return 0;

        return -1;
    }

    private boolean checkHorizontally() {

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length - 2; j++){
                if(tiles[i][j] > 0 && tiles[i][j] == tiles[i][j + 1] && tiles[i][j + 1] == tiles[i][j + 2])
                    return true;
            }
        }
        return false;
    }

    private boolean checkVertically() {
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length - 2; j++){
                if(tiles[j][i] > 0 && tiles[j][i] == tiles[j + 1][i] && tiles[j + 1][i] == tiles[j + 2][i])
                    return true;
            }
        }
        return false;
    }

    private boolean checkDiagonally() {
        for(int i = 0; i < tiles.length - 2; i++){
            for (int j = 0; j < tiles[i].length - 2; j++){
                if(tiles[j][i] > 0 && tiles[j][i] == tiles[j + 1][i + 1] && tiles[j + 1][i + 1] == tiles[j + 2][i + 2])
                    return true;
                else if(tiles[j][i + 2] > 0 && tiles[j][i + 2] == tiles[j + 1][i + 1] && tiles[j + 1][i + 1] == tiles[j + 2][i])
                    return true;
            }
        }

        return  false;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        turnOfPlayerZero = true;
        turnsLeft = row * col;

        for(int i = 0; i < tiles.length; i++)
            for(int j = 0; j < tiles[i].length; j++)
                tiles[i][j] = 0;

    }



}
