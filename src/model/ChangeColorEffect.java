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

        if (id == 1) {
            game.getBoard().getTileIJ(line, column).setIdPlayer(2);
        } else {
            game.getBoard().getTileIJ(line, column).setIdPlayer(1);
        }

    }

}
