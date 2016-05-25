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

        Game game = new Game();
        GameView board = new GameView();
        GameController controller = new GameController(board, game);
        game.addObserver(board);

    }
}
