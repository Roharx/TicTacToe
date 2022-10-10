/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import java.awt.Button;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */

    private boolean turnOfPlayerOne = true;

    public int getNextPlayer()
    {
        if(turnOfPlayerOne)
            return 0;
        return 1;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if(true){
            turnOfPlayerOne = !turnOfPlayerOne;
            //turn off the button and won't need to check any ifs
            return true;
        }

        return false;
    }


    public boolean isGameOver()
    {
        return getWinner() >= 0 || noTilesLeft();
    }

    private boolean noTilesLeft() {

        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if(checkHorizontally())
            if(turnOfPlayerOne)
                return 0;
            else
                return 1;

        if(checkVertically())
            if(turnOfPlayerOne)
                return 0;
            else
                return 1;

        if(checkDiagonally())
            if(turnOfPlayerOne)
                return 0;
            else
                return 1;

        return -1;
    }

    private boolean checkHorizontally() {

        return false;
    }

    private boolean checkVertically() {

        return false;
    }

    private boolean checkDiagonally() {

        return  false;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {


    }



}
