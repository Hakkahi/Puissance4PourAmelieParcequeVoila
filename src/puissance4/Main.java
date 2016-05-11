package puissance4;

import controller.GameController;
import model.Game;
import view.GameView;


/**
 *
 * @author hakkahi
 * 
 */


public class Main {

    public static void main(String args[]) {

        GameView board = new GameView();   
        Game game = new Game();
        GameController controller = new GameController(board, game);
        game.addObserver(board);
        
    }
}
