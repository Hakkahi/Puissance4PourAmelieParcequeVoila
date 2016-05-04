/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.View;

/**
 *
 * @author hakkahi
 */
public class Controller {

    private final View _view;

    private final MouseAdapter[][] _selectColumnGrid;
    private final MouseAdapter[][] _unSelectColumnGrid;
    private final MouseAdapter[][] _clickColumnGrid;

    private final MouseAdapter[] _selectColumnPreview;
    private final MouseAdapter[] _unSelectColumnPreview;
    private final MouseAdapter[] _clickColumnPreview;

    WindowAdapter _closingWindow;

    public Controller(View v) {
        
        //On initialise la vue du controller
        this._view = v;
        
        //On initialise les matrices d'évènement de la partie Grid
        this._selectColumnGrid = new MouseAdapter[6][7];
        this._unSelectColumnGrid = new MouseAdapter[6][7];
        this._clickColumnGrid = new MouseAdapter[6][7];
        
        //On initialise les matrices d'évènement de la partie Preview
        this._selectColumnPreview = new MouseAdapter[7];
        this._unSelectColumnPreview = new MouseAdapter[7];
        this._clickColumnPreview = new MouseAdapter[7];
        
        //Création de l'évènement qui quitte le jeu lors d'un clique de la croix
        this._closingWindow = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        };
        
        //Création des évènements de souris dans la partie Grid
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {

                final int column = j;
                
                this._selectColumnGrid[i][j] = new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {

                        //System.out.println("BlahG" + column);
                    }
                };

                this._unSelectColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseExited(MouseEvent e) {

                        //System.out.println("BlohG");
                    }
                };

                this._clickColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        //System.out.println("BluhG");
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

                    //System.out.println("BlahP");
                }
            };

            this._unSelectColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseExited(MouseEvent e) {

                    //System.out.println("BlohP");
                }
            };

            this._clickColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    //System.out.println("BluhP");
                }
            };

        }
        
        //Ajout des évènements crées à leurs éléments dans la vue
        this._view.getMainFrame().addWindowListener(_closingWindow);

        int count = 0;
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 7; ++j) {

                this._view.getGrid().getComponent(count).addMouseListener(this._selectColumnGrid[i][j]);
                this._view.getGrid().getComponent(count).addMouseListener(this._unSelectColumnGrid[i][j]);
                this._view.getGrid().getComponent(count).addMouseListener(this._clickColumnGrid[i][j]);
                count++;

            }

        }

        for (int i = 0; i < 7; ++i) {

            this._view.getPreview().getComponent(i).addMouseListener(this._selectColumnPreview[i]);
            this._view.getPreview().getComponent(i).addMouseListener(this._unSelectColumnPreview[i]);
            this._view.getPreview().getComponent(i).addMouseListener(this._clickColumnPreview[i]);

        }
    }

}
