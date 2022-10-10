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
    private Tile[][] tile;
    private boolean turnOfPlayerOne = true;


    public int getNextPlayer()
    {
        //TODO Implement this method
        return 0;
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
        if(!tile[row][col].getIsUsed()){
            tile[row][col].setUsed(true);
            tile[row][col].setHasX(turnOfPlayerOne);
        }

        setTextForButton();


        return true;
    }

    private void setTextForButton() {

        if(turnOfPlayerOne){
            //set X
        }
        else{
            //set O
        }

    }

    public boolean isGameOver()
    {
        return getWinner() > -1;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method

        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        int row = 3, col = 3; //to be changed

        tile = new Tile[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                tile[i][j].setUsed(false);
            }
        }

        clearButtonText();
    }

    private void clearButtonText() {


    }

}
