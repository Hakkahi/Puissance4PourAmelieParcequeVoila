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
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;

public class JCanvas extends JPanel {

    private final LinkedList drawables = new LinkedList();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Iterator iter = drawables.iterator(); iter.hasNext();) {
            IDrawable d = (IDrawable) iter.next();
            d.draw(g);
        }
    }

    public void addDrawable(IDrawable d) {
        drawables.add(d);
        repaint();
    }

    public void removeDrawable(IDrawable d) {
        drawables.remove(d);
        repaint();
    }

    public void clear() {
        drawables.clear();
        repaint();
    }

    public boolean isFree(Rectangle rect) {
        for (Iterator iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            if (element.getRectangle().intersects(rect)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList findDrawables(Point p) {
        ArrayList l = new ArrayList();
        for (Iterator iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            if (element.getRectangle().contains(p)) {
                l.add(element);
            }
        }
        return l;
    }

    public boolean isAlone(IDrawable drawable) {
        Rectangle rect = drawable.getRectangle();
        for (Iterator iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            if (element.getRectangle().intersects(rect) && !element.equals(drawable)) {
                return false;
            } else {
            }
        }
        return true;
    }

}
