/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public class InvertAllTilesEffect extends Effect {

    /**
     * This effect changes the color of all the tiles on the board
     * including the one that has just been played 
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {

        int player1_id = game.getPlayer1().getId();
        int player2_id = game.getPlayer2().getId();

        for(int i=0; i<game.getBoard().getHeight(); i++){
            for(int j=0; j<game.getBoard().getWidth(); j++){
               if(game.getBoard().getTileIJ(i, j).getStatus()==player1_id){
                  game.getBoard().getTileIJ(i, j).setStatus(player2_id);
               }else if(game.getBoard().getTileIJ(i, j).getStatus()==player2_id){
                  game.getBoard().getTileIJ(i, j).setStatus(player1_id);                   
               }
            }
        }
        
    }
}
