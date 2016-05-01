/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author hakkahi
 */
public class View extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(10, 10, 80, 80);
        g.setColor(Color.BLUE);
        g.fillOval(150, 50, 80, 80);
        g.setColor(c);
    }

}
