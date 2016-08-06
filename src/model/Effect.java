/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import java.awt.Color;

/**
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public abstract class Effect {

    private final Color _effectColor;

    public Effect(Color color) {
        this._effectColor = color;
    }

    //line and column are in the coordinates of the token that has just been played
    public abstract void playEffect(int line, int column, Game game);

    public Color getColor() {
        return this._effectColor;
    }

}
