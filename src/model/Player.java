/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author hakkahi
 */
public abstract class Player {

    private final Color _color;
    private final int _id;

    public Player(int id, Color color) {

        this._color = color;
        this._id = id;

    }

    public Color getColor() {
        return this._color;
    }

    public int getId() {
        return this._id;
    }
}
