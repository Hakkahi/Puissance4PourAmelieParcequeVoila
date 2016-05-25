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

        Game game = new Game(10, 9);
        GameView board = new GameView(10, 9);
        GameController controller = new GameController(board, game);
        game.addObserver(board);

    }
}
