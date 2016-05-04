/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.Observable;

/**
 *
 * @author hakkahi
 */
public final class Game extends Observable {

    private int _posPreview;
    private final Tile[][] _board;
    private final Player _player1;
    private final Player _player2;
    private Player _currentPlayer;

    public Game() {

        this._board = new Tile[6][7];
        this._player1 = new HumanPlayer(1, Color.RED);
        this._player2 = new HumanPlayer(2, Color.YELLOW);
        this._currentPlayer = this._player1;

        init();

    }

    public void init() {

        resetPosPreview();

        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {
                this._board[i][j] = new Tile(-1);
            }

        }

    }

    public void playMove(int column) {

        for (int i = 5; i >= 0; --i) {

            if (this._board[i][column].getIdPlayer() == -1) {

                this._board[i][column]._idPlayer = this._currentPlayer.getId();

                break;

            }

        }

        if (Win()) {
            System.out.println(this._currentPlayer.getId());
        }

        if (this._currentPlayer.getId() == this._player1.getId()) {
            _currentPlayer = _player2;
        } else {
            _currentPlayer = _player1;
        }

        setChanged();
        notifyObservers();

    }

    public boolean strokeIsValid(int column) {

        return this._board[0][column].getIdPlayer() == -1;

    }

    public boolean Win() {

        //Vérification des lignes
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 4; ++j) {

                if (this._currentPlayer.getId() == this._board[i][j].getIdPlayer() && this._currentPlayer.getId() == this._board[i][j + 1]._idPlayer && this._currentPlayer.getId() == this._board[i][j + 2]._idPlayer && this._currentPlayer.getId() == this._board[i][j + 3]._idPlayer) {
                    return true;
                }

            }

        }

        //Vérification des colonnes
        for (int i = 0; i < 7; ++i) {

            for (int j = 0; j < 3; ++j) {

                if (this._currentPlayer.getId() == this._board[j][i].getIdPlayer() && this._currentPlayer.getId() == this._board[j + 1][i]._idPlayer && this._currentPlayer.getId() == this._board[j + 2][i]._idPlayer && this._currentPlayer.getId() == this._board[j + 3][i]._idPlayer) {
                    return true;
                }

            }

        }

        //Vérification des diagonales droites
        for (int i = 0; i < 4; ++i) {

            for (int j = 0; j < 3; ++j) {

                if (this._currentPlayer.getId() == this._board[j][i].getIdPlayer() && this._currentPlayer.getId() == this._board[j + 1][i + 1]._idPlayer && this._currentPlayer.getId() == this._board[j + 2][i + 2]._idPlayer && this._currentPlayer.getId() == this._board[j + 3][i + 3]._idPlayer) {
                    return true;
                }

            }

        }

        //Vérification des diagonales gauches
        for (int i = 6; i > 2; --i) {

            for (int j = 0; j < 3; ++j) {

                if (this._currentPlayer.getId() == this._board[j][i].getIdPlayer() && this._currentPlayer.getId() == this._board[j + 1][i - 1]._idPlayer && this._currentPlayer.getId() == this._board[j + 2][i - 2]._idPlayer && this._currentPlayer.getId() == this._board[j + 3][i - 3]._idPlayer) {
                    return true;
                }

            }

        }

        return false;

    }

    public int getPosPreview() {
        return _posPreview;
    }

    public Tile[][] getBoard() {
        return this._board;
    }

    public Tile getTileIJ(int i, int j) {
        return this._board[i][j];
    }

    public void setPosPreview(int i) {

        this._posPreview = i;
        setChanged();
        notifyObservers();

    }

    public void resetPosPreview() {
        setPosPreview(-1);
    }

    public Player getCurrentPlayer() {
        return this._currentPlayer;
    }

    public Player getPlayerById(int id) {

        if (id == this._player1.getId()) {
            return this._player1;
        } else if (id == this._player2.getId()) {
            return this._player2;
        } else {
            return null;
        }

    }

}
