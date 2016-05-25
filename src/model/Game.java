package model;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;
import static model.EffectFactory.createEffect;

/**
 *
 * @author hakkahi
 *
 */
public final class Game extends Observable {

    private int _posPreview;
    private Board _board;
    private final Player _player1;
    private final Player _player2;
    private Player _currentPlayer;
    private int _winner;
    private boolean _over;

    public Game() {

        this._winner = -1;
        this._over = false;

        this._player1 = new HumanPlayer(1, Color.RED);
        this._player2 = new HumanPlayer(2, Color.YELLOW);
        this._currentPlayer = this._player1;
        //this._board = new Board(width, height);

        init();

    }

    public void init() {

        resetPosPreview();

    }

    public void playMove(int column) {

        int i;

        if (this._board.getTileIJ(0, column).getIdPlayer() == -1) {

            for (i = 0; i < this._board.getHeight(); ++i) {

                if (this._board.getTileIJ(i, column).getIdPlayer() != -1) {
                    break;
                }

            }

            if (i > 0) {

                i--;
                this._board.getTileIJ(i, column).setIdPlayer(this._currentPlayer.getId());

            }

            if (this._board.getTileIJ(i, column).getEffect() != null) {
                this._board.getTileIJ(i, column).getEffect().playEffect(i, column, this);
            }

            Player tmp = Win();
            if (tmp != null) {
                this._winner = tmp.getId();
            }

            isOver();

            if (this._currentPlayer.getId() == this._player1.getId()) {
                _currentPlayer = _player2;
            } else {
                _currentPlayer = _player1;
            }

            setChanged();
            notifyObservers();
        }
    }

    public boolean strokeIsValid(int column) {
        return this._board.getTileIJ(0, column).getIdPlayer() == -1;
    }

    public Player Win() {

        //Vérification des lignes
        for (int i = 0; i < this._board.getHeight(); ++i) {

            for (int j = 0; j <= (this._board.getWidth() - 4); ++j) {

                if (this._player1.getId() == this._board.getTileIJ(i, j).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(i, j + 1).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(i, j + 2).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(i, j + 3).getIdPlayer()) {
                    return _player1;
                }

                if (this._player2.getId() == this._board.getTileIJ(i, j).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(i, j + 1).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(i, j + 2).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(i, j + 3).getIdPlayer()) {
                    return _player2;
                }

            }

        }

        //Vérification des colonnes
        for (int i = 0; i < this._board.getWidth(); ++i) {

            for (int j = 0; j <= (this._board.getHeight() - 4); ++j) {

                if (this._player1.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 1, i).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 2, i).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 3, i).getIdPlayer()) {
                    return _player1;
                }

                if (this._player2.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 1, i).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 2, i).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 3, i).getIdPlayer()) {
                    return _player2;
                }

            }

        }

        //Vérification des diagonales droites
        for (int i = 0; i <= (this._board.getWidth() - 4); ++i) {

            for (int j = 0; j <= (this._board.getHeight() - 4); ++j) {

                if (this._player1.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 1, i + 1).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 2, i + 2).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 3, i + 3).getIdPlayer()) {
                    return _player1;
                }

                if (this._player2.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 1, i + 1).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 2, i + 2).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 3, i + 3).getIdPlayer()) {
                    return _player2;
                }

            }

        }

        /*//Vérification des diagonales gauches
        for (int i = this._board.getHeight(); i >= (this._board.getWidth() - 4); --i) {

            for (int j = 0; j <= (this._board.getHeight() - 4); ++j) {

                if (this._player1.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 1, i - 1).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 2, i - 2).getIdPlayer() && this._player1.getId() == this._board.getTileIJ(j + 3, i - 3).getIdPlayer()) {
                    return _player1;
                }

                if (this._player2.getId() == this._board.getTileIJ(j, i).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 1, i - 1).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 2, i - 2).getIdPlayer() && this._player2.getId() == this._board.getTileIJ(j + 3, i - 3).getIdPlayer()) {
                    return _player2;
                }

            }

        }*/

        return null;

    }

    public void isOver() {

        for (int i = 0; i < this._board.getHeight(); ++i) {

            for (int j = 0; j < this._board.getWidth(); j++) {

                if (this._board.getTileIJ(i, j).getIdPlayer() == -1) {
                    return;
                }

            }

        }

        this._over = true;

    }

    public void resetGame() {

        this._board.resetBoard();
        this._winner = -1;
        this._currentPlayer = this._player1;

        setChanged();
        notifyObservers();

    }

    public void resetPosPreview() {
        setPosPreview(-1);
    }

    public void setTilesEffect() {

        for (int i = 0; i < this._board.getHeight(); ++i) {

            for (int j = 0; j < this._board.getWidth(); ++j) {

                Random rand = new Random();
                //Tire un nombre aléatoire entre min et max compris
                int random = rand.nextInt(100 - 1 + 1) + 1;

                if (random <= this._board.getTileEffectChance()) {
                    this._board.getTileIJ(i, j).setEffect(createEffect());
                }

            }

        }

    }

    public void setPosPreview(int i) {

        this._posPreview = i;
        setChanged();
        notifyObservers();

    }

    public void setBoard(Board board) {
        this._board = board;
    }

    public int getPosPreview() {
        return _posPreview;
    }

    public Board getBoard() {
        return this._board;
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

    public int getWinner() {
        return this._winner;
    }

    public boolean getOver() {
        return this._over;
    }

    public int getTilesCountPlayer1() {

        int count = 0;

        for (int i = 0; i < this._board.getHeight(); ++i) {

            for (int j = 0; j < this._board.getWidth(); ++j) {

                if (this._board.getTileIJ(i, j).getIdPlayer() == this._player1.getId()) {
                    count++;
                }

            }

        }

        return count;

    }

    public int getTilesCountPlayer2() {

        int count = 0;

        for (int i = 0; i < this._board.getHeight(); ++i) {

            for (int j = 0; j < this._board.getWidth(); ++j) {

                if (this._board.getTileIJ(i, j).getIdPlayer() == this._player2.getId()) {
                    count++;
                }

            }

        }

        return count;

    }

    public int getTotalTilesCount() {
        return getTilesCountPlayer1() + getTilesCountPlayer2();
    }

    public Player getPlayer1() {
        return this._player1;
    }

    public Player getPlayer2() {
        return this._player2;
    }

}
