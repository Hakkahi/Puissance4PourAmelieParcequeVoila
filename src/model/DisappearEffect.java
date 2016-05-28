/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 *
 * @author Amélie Cordier IUT Lyon 1 - 2016
 */
public class DisappearEffect extends Effect {

    /**
     * This effect makes the token disappear as soon as it is played
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {

        // After the token is played, we reset the status of the tile to -1  
        game.getBoard().getTileIJ(line, column).setStatus(-1);

    }

}
