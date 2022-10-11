/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.scene.control.Button;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    int row = 3, col = 3;
    private int turnsLeft = row * col;
    private boolean turnOfPlayerZero = true;

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
     * @param btn gets the button pressed by the user
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(Button btn)
    {
        if(turnsLeft > 0 && btn.getText() == ""){
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
        turnsLeft = row * col;
    }



}
