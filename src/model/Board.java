package model;


/**
 *
 * @author hakkahi
 * 
 */


public class Board {

    private final Tile[][] _board;
    private int _tileEffectChance;

    public Board() {

        this._board = new Tile[6][7];
        init();

    }

    private void init() {

        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {
                this._board[i][j] = new Tile(-1);
            }

        }

    }

    public void resetBoard() {

        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {

                this._board[i][j].setEffect(null);
                this._board[i][j].setIdPlayer(-1);

            }

        }

    }

    public void setEffectChances(int tileEffectChance) {
        this._tileEffectChance = tileEffectChance;
    }

    public Tile getTileIJ(int i, int j) {
        return this._board[i][j];
    }

    public int getTileEffectChance() {
        return this._tileEffectChance;
    }

}