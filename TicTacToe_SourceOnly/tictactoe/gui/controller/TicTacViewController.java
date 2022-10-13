/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;
import tictactoe.bll.Player;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{

    public Label lblPlayerOneHealth;
    public Label lblPlayerZeroHealth;


    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;

    private Player player0 = new Player();
    private Player player1 = new Player();
    
    private static final String TXT_PLAYER = "Turn: ";
    private IGameModel game;

    @FXML
    private void mouseEnterAction(MouseEvent event){
        Button btn = (Button) event.getSource();
        if(btn.getGraphic() == null)
            btn.setGraphic(new ImageView("tictactoe/gui/images/Flag.png"));

    }

    @FXML
    public void mouseLeaveAction(MouseEvent event) {
        Button btn = (Button) event.getSource();
        if(!btn.isDisabled())
            btn.setGraphic(null);
    }

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();
            Button btn = (Button) event.getSource();

            lblPlayerZeroHealth.setTextFill(Paint.valueOf("#ffffff"));
            lblPlayerOneHealth.setTextFill(Paint.valueOf("#ffffff"));

            if (game.play(r,c,btn))
            {
                if (game.isGameOver())
                {
                    disableButtons(gridPane);
                    String xOrO = player == 0 ? "X" : "O";
                    setPictureToButton(btn, xOrO);

                    int winner = game.getWinner();
                    doCombat(winner);

                    if(player0.getHealth() <= 0 && player0.getHealth() == player1.getHealth())
                    {
                        displayWinner(-1);
                    }
                    else if(player0.getHealth() <= 0){
                        displayWinner(0);
                    }
                    else if(player1.getHealth() <= 0){
                        displayWinner(1);
                    }
                    else
                    {
                        clearBoard();
                        game.newGame();
                    }

                }
                else
                {
                    String xOrO = player == 0 ? "X" : "O";
                    setPictureToButton(btn, xOrO);

                    setPlayer();
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    private void doCombat(int winner) {

        clearBoard();
        lockBoard();

        if (winner == 0){
            player0.dealDamageTo(player1);
            lblPlayerOneHealth.setTextFill(Paint.valueOf("#ff0000"));
        }
        else if (winner == 1){
            player1.dealDamageTo(player0);
            lblPlayerZeroHealth.setTextFill(Paint.valueOf("#ff0000"));
        }
        else
        {
            player0.receiveDamage(1);
            lblPlayerZeroHealth.setTextFill(Paint.valueOf("#ff0000"));
            player1.receiveDamage(1);
            lblPlayerOneHealth.setTextFill(Paint.valueOf("#ff0000"));
        }
        lblPlayerZeroHealth.setText("P0 Health: " + player0.getHealth());
        lblPlayerOneHealth.setText("P1 Health: " + player1.getHealth());
    }


    private void disableButtons(GridPane gridPane) {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setDisable(true);
        }
    }

    private void setPictureToButton(Button btn, String xOrO) {
        if(xOrO == "X"){
            btn.setGraphic(new ImageView("tictactoe/gui/images/sword.png"));
        }
        else
            btn.setGraphic(new ImageView("tictactoe/gui/images/shield.png"));


    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();

        player0 = new Player();
        lblPlayerZeroHealth.setText("P0 Health: " + player0.getHealth());
        player1 = new Player();
        lblPlayerOneHealth.setText("P1 Health: " + player1.getHealth());

        lblPlayerZeroHealth.setTextFill(Paint.valueOf("#ffffff"));
        lblPlayerOneHealth.setTextFill(Paint.valueOf("#ffffff"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + "Player " + game.getNextPlayer());

    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayerOneHealth.setText(null);
        lblPlayerZeroHealth.setText(null);
        clearBoard();
        lockBoard();
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setGraphic(null);
            btn.setDisable(false);
        }

    }

    private void lockBoard(){
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setDisable(true);
        }
    }

}
