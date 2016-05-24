/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hakkahi
 */
public abstract class Effect {

    //column et line sont les coordonnées du token qui vient d'être joué
    public abstract void playEffect(int line, int column, Game game);

}
