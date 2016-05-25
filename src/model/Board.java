package model;

/**
 *
 * @author hakkahi
 *
 */
public class Board {

    private Tile[][] _board;
    private int _tileEffectChance;
    private int _width;
    private int _height;

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

    public void setWidth(int width) {
        this._width = width;
    }

    public void setHeight(int height) {
        this._height = height;
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

    
    @Override
    public String toString() {

        String boardString = "";    

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                boardString += this._board[i][j].getIdPlayer();

            }
            boardString += "\n";

        }
        return boardString;
    }
    
    public String toStringSymbols() {

        String boardString = "";    
        int idPlayer;

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                idPlayer = this._board[i][j].getIdPlayer();
                if(idPlayer == 1){
                    boardString += "x";
                }else if(idPlayer == 2){
                    boardString += "o";
                }else{
                    boardString += "-";
                }

            }
            boardString += "\n";

        }
        return boardString;
    }

}
