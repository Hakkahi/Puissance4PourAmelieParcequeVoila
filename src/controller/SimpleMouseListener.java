/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author hakkahi
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import view.CircleDrawable;
import view.IDrawable;
import view.JCanvas;
import view.RectangleDrawable;

public class SimpleMouseListener extends JCanvasMouseListener {

    public SimpleMouseListener(JCanvas canvas) {
        super(canvas);

    }

    @Override
    protected void rightClickAction(MouseEvent e) {
        List selectedDrawables = canvas.findDrawables(e.getPoint());
        if (selectedDrawables.isEmpty()) {
            return;
        }
        IDrawable drawable = (IDrawable) selectedDrawables.get(0);
        canvas.removeDrawable(drawable);
    }

    @Override
    protected void leftClickAction(MouseEvent e) {
        Point p = e.getPoint();
        IDrawable rect = createDrawable(e);
        if (canvas.isFree(rect.getRectangle())) {
            canvas.addDrawable(rect);
        }

    }

    private IDrawable createDrawable(MouseEvent e) {
        Point p = e.getPoint();
        Dimension dim = new Dimension(40, 40);
        return new CircleDrawable(Color.BLUE, p, dim);

    }

}
