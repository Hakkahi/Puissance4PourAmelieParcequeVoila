/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4;

import controller.Controller;
import model.Game;
import view.*;

/**
 *
 * @author hakkahi
 */
public class Main {

    public static void main(String args[]) {
        /*JCanvas jc = new JCanvas();
        jc.setBackground(Color.WHITE);
        jc.setPreferredSize(new Dimension(400, 200));
        Dimension dim = new Dimension(40, 40);
        IDrawable circle = new CircleDrawable(Color.BLUE, new Point(60, 30), dim);
        jc.addDrawable(circle);
        SimpleMouseListener simpleMouseListener = new SimpleMouseListener(jc);
        GUIHelper.showOnFrame(jc, "test JCanvas");*/
        
        View board = new View();
        Game game = new Game();
        Controller controller = new Controller(board, game);
        game.addObserver(board);
    }
}
