package com.bigtictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Controller {
    static int player = 1;
    static int chainRow = 0;
    static int chainColumn = 0;
    static int chainFirDia = 0;
    static int chainSecDia = 0;
    String[][] bigBoard = new String[10][10];
    int moveCounter = 0;
    static String turn = " ";

    @FXML
    private Label labelPlayer;
    @FXML
    private Label labelWinner;

    @FXML
    protected void playerMove(ActionEvent event) {

            if (player == 1) {
                ((Button) event.getSource()).setText("X");
                ((Button) event.getSource()).setDisable(true);
                labelPlayer.setText("Now is O' turn!");
                turn = "X";
                player++;
            } else if (player == 2) {
                ((Button) event.getSource()).setText("O");
                ((Button) event.getSource()).setDisable(true);
                labelPlayer.setText("Now is X' turn!");
                turn = "O";
                player--;
            }
        //Zapisanie ruchu na tablicy
        bigBoard[(GridPane.getColumnIndex(((Button) event.getSource())) != null ? GridPane.getColumnIndex(((Button) event.getSource())) : 0)][(GridPane.getRowIndex(((Button) event.getSource()))) != null ? (GridPane.getRowIndex(((Button) event.getSource()))) : 0] = ((Button) event.getSource()).getText();

        moveCounter++;
        //Sprawdzanie wygranej w wierszu -
        for (int row = 0; row < bigBoard.length; row++) {
            for (int col = 0; col < bigBoard.length; col++) {

                if (bigBoard[col][row] == turn) {
                    chainRow++;
                    if (chainRow == 5) {
                        labelPlayer.setText("GAME OVER!");
                        labelWinner.setText("Player " + turn + " wins in a row");
                        System.out.println(turn + " Wygrana w wierszu");
                    }
                } else {
                    chainRow = 0;
                }

            }
        }
        //Sprawdzanie wygranej w kolumnie |
        for (int col = 0; col < bigBoard.length; col++) {
            for (int row = 0; row < bigBoard.length; row++) {
                            if (bigBoard[col][row] == turn) {
                    chainColumn++;
                                if (chainColumn == 5) {
                                    labelPlayer.setText("GAME OVER!");
                                    labelWinner.setText("Player " + turn + " wins in a column");
                                    System.out.println(turn + "  Wygrana w columnie");
                                }
                } else {
                    chainColumn = 0;
                }

            }
        }
        //Sprawdzanie wygranej w po przekątnej \
        for (int p = 0; p < bigBoard.length; p++) {
            if (bigBoard[p][p] == turn) {
                chainFirDia++;
                if (chainFirDia == 5) {
                    labelPlayer.setText("GAME OVER!");
                    labelWinner.setText("Player " + turn + " wins diagonally");
                    System.out.println(turn + " Wygrana first ");
                }
            } else {
                chainFirDia = 0;
            }

        }
        //Sprawdzanie wygranej w po przekątnej /
            for (int p = 0; p < bigBoard.length; p++) {
                if (bigBoard[(bigBoard.length - 1) - p][p] == turn) {
                    chainSecDia++;
                    if (chainSecDia == 5) {
                        labelPlayer.setText("GAME OVER!");
                        labelWinner.setText("Player " + turn + " wins diagonally");
                        System.out.println(turn + " Wygrana seco");
                    }
                } else {
                    chainSecDia = 0;
                }

            }
        //Sprawdzanie pełnej planszy
        if (moveCounter == 100) {
            labelPlayer.setText("GAME OVER!");
            labelPlayer.setText("End of game - DRAW");

        }
    }
}







