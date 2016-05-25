package model;

/**
 *
 * @author hakkahi
 *
 */
public class Board {

    private final Tile[][] _board;
    private int _tileEffectChance;
    private final int _width;
    private final int _height;

    public Board(int width, int height) {

        this._width = width;
        this._height = height;
        this._board = new Tile[this._height][this._width];
        init();

    }

    private void init() {

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {
                this._board[i][j] = new Tile(-1);
            }

        }

    }

    public void resetBoard() {

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

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

    public int getWidth() {
        return this._width;
    }

    public int getHeight() {
        return this._height;
    }

}
