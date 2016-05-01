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

public abstract class FormDrawable implements IDrawable {

	
	protected Rectangle rect ;
	protected Color color;
	
	public FormDrawable(Color color, Point pos, Dimension dim){
		this.color=color;
		this.rect = new Rectangle(pos,dim);
	}
	
        @Override
	public abstract void draw(Graphics g);
	
        @Override
	public Rectangle getRectangle(){
		return (Rectangle) rect.clone();
	}
	
}
