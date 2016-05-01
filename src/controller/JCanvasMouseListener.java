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

import java.awt.event.*;
import javax.swing.SwingUtilities;
import view.JCanvas;

public abstract class JCanvasMouseListener extends MouseAdapter {

	protected JCanvas canvas;

	public JCanvasMouseListener(JCanvas canvas) {
		super();
		this.canvas = canvas;
		canvas.addMouseListener(this);
	}
		
	public JCanvas getCanvas() {
		return canvas;
	}

        @Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			leftClickAction(e);
		} else {
			rightClickAction(e);
		}
	}

	
	protected void rightClickAction(MouseEvent e) {

	}

	protected void leftClickAction(MouseEvent e) {
		
	}
	
}
