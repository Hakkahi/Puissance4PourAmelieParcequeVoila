package model;

/**
 *
 * @author hakkahi
 *
 */
public class ChangeColorEffect extends Effect {

    @Override
    public void playEffect(int line, int column, Game game) {

        int id = game.getBoard().getTileIJ(line, column).getIdPlayer();

        if (id == game.getPlayer1().getId()) {
            game.getBoard().getTileIJ(line, column).setIdPlayer(game.getPlayer2().getId());
        } else {
            game.getBoard().getTileIJ(line, column).setIdPlayer(game.getPlayer1().getId());
        }

    }

}
