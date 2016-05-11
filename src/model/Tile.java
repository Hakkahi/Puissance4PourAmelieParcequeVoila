package model;


/**
 *
 * @author hakkahi
 * 
 */


public class Tile {

    private int _idPlayer;
    private Effect _effect;

    public Tile(int _idPlayer) {

        this._idPlayer = _idPlayer;
        this._effect = null;
    }

    public void setIdPlayer(int id) {
        this._idPlayer = id;
    }

    public void setEffect(Effect effect) {
        this._effect = effect;
    }

    public Effect getEffect() {
        return this._effect;
    }

    public int getIdPlayer() {
        return this._idPlayer;
    }

}
