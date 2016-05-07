/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hakkahi
 */
public class Tile {

    private int _idPlayer;
    private Effect _effect;

    public Tile(int _idPlayer) {

        this._idPlayer = _idPlayer;
        this._effect = null;
    }

    public int getIdPlayer() {
        return this._idPlayer;
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
}
