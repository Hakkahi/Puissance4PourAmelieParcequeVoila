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
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;
import model.Game;

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
    private Border _blueLine;

    public View() {

        super("Puissance4");

        init();

        setSize(_windowHeight, _windowWidth);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void init() {

        this._window = new JPanel(new GridBagLayout());
        this._grid = new JPanel(new GridLayout(6, 7));
        this._preview = new JPanel(new GridLayout(1, 6));

        _blueLine = BorderFactory.createLineBorder(Color.BLUE, _borderSize);

        GridBagConstraints cWindow = new GridBagConstraints();

        this._grid.setBackground(Color.WHITE);

        for (int i = 0; i < 42; i++) {
            JLabel labelGrid = new JLabel();
            labelGrid.setBorder(_blueLine);
            labelGrid.setOpaque(true);
            labelGrid.setBackground(Color.WHITE);
            labelGrid.setVerticalAlignment(SwingConstants.CENTER);
            labelGrid.setHorizontalAlignment(SwingConstants.CENTER);
            this.getGrid().add(labelGrid);
        }

        for (int i = 0; i < 7; i++) {

            JLabel labelPreview = new JLabel();
            labelPreview.setOpaque(true);
            labelPreview.setBackground(Color.WHITE);
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

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof Game) {

            Game game = (Game) o;
            
            resetPreview();

            int i = game.getPosPreview();
            if (i != -1) {

                this.getPreview().getComponent(i).setBackground(Color.RED);

            }
        }
    }

    public void resetPreview() {

        for (int i = 0; i < 7; ++i) {

            this.getPreview().getComponent(i).setBackground(Color.WHITE);

        }

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

    public void setBorderSize() {

        Rectangle rectangle = this.getBounds();

        this.setWindowHeight(rectangle.height);
        this.setWindowWidth(rectangle.width);

        _borderSize = (_windowWidth * 1) / 100;

        _blueLine = BorderFactory.createLineBorder(Color.BLUE, _borderSize);
        
        this.setLabelBorder();

    }

    public void setWindowHeight(int height) {
        this._windowHeight = height;
    }

    public void setWindowWidth(int width) {
        this._windowWidth = width;
    }

    public void setLabelBorder() {
        
        JLabel tmp;
        for (int i = 0; i < 42; ++i) {
            
            tmp = (JLabel) this.getGrid().getComponent(i);
            tmp.setBorder(_blueLine);
        }

    }

}
