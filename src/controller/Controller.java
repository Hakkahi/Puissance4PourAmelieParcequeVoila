/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.Game;
import model.HumanPlayer;
import view.View;

/**
 *
 * @author hakkahi
 */
public class Controller {

    private final View _view;
    private final Game _game;

    private final MouseAdapter[][] _selectColumnGrid;
    private final MouseAdapter[][] _clickColumnGrid;

    private final MouseAdapter[] _selectColumnPreview;
    private final MouseAdapter[] _clickColumnPreview;

    private final WindowAdapter _closingWindow;
    private final ComponentAdapter _resizingWindow;

    public Controller(View view, Game game) {

        //On initialise la vue du controller
        this._view = view;
        this._game = game;

        //On initialise les matrices d'évènement de la partie Grid
        this._selectColumnGrid = new MouseAdapter[6][7];
        this._clickColumnGrid = new MouseAdapter[6][7];

        //On initialise les matrices d'évènement de la partie Preview
        this._selectColumnPreview = new MouseAdapter[7];
        this._clickColumnPreview = new MouseAdapter[7];

        //Création de l'évènement qui quitte le jeu lors d'un clique de la croix
        this._closingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        };

        this._resizingWindow = new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                _view.setBorderSize();

            }

        };

        //Création des évènements de souris dans la partie Grid
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {

                final int column = j;
                final int line = i;

                this._selectColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        _game.resetPosPreview();
                        _game.setPosPreview(column);

                    }
                };

                this._clickColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (_game.getCurrentPlayer() instanceof HumanPlayer) {

                            if (_game.strokeIsValid(column)) {
                                _game.playMove(column);
                            }
                        }

                    }
                };

            }

        }

        //Création des évènements de souris dans la partie preview
        for (int i = 0; i < 7; ++i) {

            final int column = i;

            this._selectColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    _game.resetPosPreview();
                    _game.setPosPreview(column);

                }
            };

            this._clickColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (_game.getCurrentPlayer() instanceof HumanPlayer) {
                        _game.playMove(column);
                    }
                }
            };

        }

        //Ajout des évènements crées à leurs éléments dans la vue
        this._view.getMainFrame().addWindowListener(_closingWindow);

        this._view.getMainFrame().addComponentListener(_resizingWindow);

        int count = 0;
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {

                this._view.getGrid().getComponent(count).addMouseListener(this._selectColumnGrid[i][j]);
                this._view.getGrid().getComponent(count).addMouseListener(this._clickColumnGrid[i][j]);
                count++;

            }

        }

        for (int i = 0; i < 7; ++i) {

            this._view.getPreview().getComponent(i).addMouseListener(this._selectColumnPreview[i]);
            this._view.getPreview().getComponent(i).addMouseListener(this._clickColumnPreview[i]);

        }
    }

}
