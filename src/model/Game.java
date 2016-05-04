/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;

/**
 *
 * @author hakkahi
 */
public class Game extends Observable {

    private int _posPreview;

    public Game() {
        init();
    }

    public void init() {
        resetPosPreview();
    }

    public int getPosPreview() {
        return _posPreview;
    }

    public void setPosPreview(int i) {

        this._posPreview = i;
        setChanged();
        notifyObservers();

    }

    public void resetPosPreview() {
        setPosPreview(-1);
    }

}
