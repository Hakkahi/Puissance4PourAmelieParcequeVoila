/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hakkahi
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class RectangleDrawable extends FormDrawable {

    public RectangleDrawable(Color color, Point pos, Dimension dim) {
        super(color, pos, dim);

    }

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(rect.x, rect.y, rect.height, rect.width);
        g.setColor(c);
    }

}
