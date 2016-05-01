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


import java.awt.Graphics;
import java.awt.Rectangle;

public interface IDrawable {
	
	public  void draw(Graphics g);

	public Rectangle getRectangle();
}
