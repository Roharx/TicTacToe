/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

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
    int row = 3, col = 3;
    private int turnsLeft = row * col;
    private boolean turnOfPlayerZero = true;

    public int getNextPlayer()
    {
        if(turnOfPlayerZero)
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
        if(turnsLeft > 0){//and tile does not contain X or O
            turnOfPlayerZero = !turnOfPlayerZero;
            turnsLeft--;
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
        turnOfPlayerZero = true;

    }



}
