/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author hakkahi
 */
public class View extends JFrame implements Observer {

    private JPanel _window;
    private JPanel _preview;
    private JPanel _grid;

    private int _windowHeight = 800;
    private int _windowWidth = 600;
    private int _borderSize = (_windowWidth * 1) / 100;

    public View() {

        super("Puissance4");
        
        init();

        setSize(_windowHeight, _windowWidth);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void init() {

        this._window = new JPanel(new GridBagLayout());
        this._grid = new JPanel(new GridLayout(6, 7));
        this._preview = new JPanel(new GridLayout(1, 6));

        Border blueLine = BorderFactory.createLineBorder(Color.BLUE, _borderSize);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK, 2);

        GridBagConstraints cWindow = new GridBagConstraints();

        this._grid.setBackground(Color.WHITE);

        for (int i = 0; i < 42; i++) {
            JLabel labelGrid = new JLabel();
            labelGrid.setBorder(blueLine);
            labelGrid.setOpaque(true);
            labelGrid.setVerticalAlignment(SwingConstants.CENTER);
            labelGrid.setHorizontalAlignment(SwingConstants.CENTER);
            this.getGrid().add(labelGrid);
        }

        for (int i = 0; i < 7; i++) {

            JLabel labelPreview = new JLabel();
            labelPreview.setBorder(blackLine);
            labelPreview.setOpaque(true);
            labelPreview.setVerticalAlignment(SwingConstants.CENTER);
            labelPreview.setHorizontalAlignment(SwingConstants.CENTER);
            this.getPreview().add(labelPreview);
        }

        this._preview.setBackground(Color.WHITE);

        this.add(getWindow());

        cWindow.fill = GridBagConstraints.BOTH;
        cWindow.weightx = 1;
        cWindow.gridx = 0;
        cWindow.gridy = 0;
        cWindow.weighty = 0.14;
        getWindow().add(getPreview(), cWindow);

        cWindow.weightx = 1;
        cWindow.gridx = 0;
        cWindow.gridy = 1;
        cWindow.weighty = 0.86;
        getWindow().add(getGrid(), cWindow);

    }

    public JPanel getWindow() {
        return _window;
    }

    public JPanel getPreview() {
        return this._preview;
    }

    public JPanel getGrid() {
        return this._grid;
    }

    public JFrame getMainFrame() {
        return this;
    }
}
