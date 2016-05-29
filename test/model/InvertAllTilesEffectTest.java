/** 
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for InvertAllTilesEffect
 * @author Amélie Cordier
 */
public class InvertAllTilesEffectTest {
    
    static Game aGame;
    
    public InvertAllTilesEffectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
               
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        // Création d'un jeu vide
        aGame = new Game();
        Board b = new Board(10,10);
        aGame.setBoard(b);
 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test du bon fonctionnement du jeu, en dehors de l'effet
     * Résultats attendus après le coup : 
     * - un jeton de plus sur le plateau
     * - le tour de jeu est passé 
     * - l'effet a bien été appliqué 
     */
    @Test
    public void testInvertAllTilesNormalGame() {

        // On pré-remplit le plateau pour les besoins de la simulation 
        Utils.simulateAGame(aGame);
        
        // Effet fixé sur une case (qui n'est pas encore remplie)
        int height = aGame.getBoard().getHeight();
                
        // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
        aGame.getBoard().getTileIJ(height-3, 0).setEffect(new InvertAllTilesEffect());

        // Récupération de l'ID du joueur avant que le coup soit joué 
        int id_player = aGame.getCurrentPlayer().getId();
        
        // Récupération du nombre de jetons présents 
        int nb_tokens_before = aGame.getBoard().getTotalTilesCount();
        
        // Coup joué sur une case ne contenant pas l'effet  
        aGame.playMove(1);
         
        // Récupération du nombre de jetons après le coup 
        int nb_tokens_after = aGame.getBoard().getTotalTilesCount();
        
        // Vérifications :
        // - l'effet est bien appliqué sur la case 
        // - le tour de jeu a bien changé
        // - il y a bien un jeton de plus sur le plateau
        assertTrue("Doit être d'effet invertAllTiles", aGame.getBoard().getTileIJ(height-3,0).getEffect() instanceof InvertAllTilesEffect);
        assertTrue(aGame.getCurrentPlayer().getId() != id_player);
        assertEquals(nb_tokens_before+1, nb_tokens_after);
    }

    
    
    /**
     * Test de InvertAllTilesEffect sur grille vide
     * vérification de l'état de la case 
     * après application de l'effet
     * Résultats attendus : la case doit être de la couleur opposée à celle jouée, 
     * le tour de jeu doit être passé
     */
    @Test
    public void testInvertAllTilesEffectEmptyGame() {
       
        // Effet fixé sur une case 
        int height = aGame.getBoard().getHeight();
        aGame.getBoard().getTileIJ(height-1, 0).setEffect(new InvertAllTilesEffect());

        // Récupération de l'ID du joueur courant 
        int id_player = aGame.getCurrentPlayer().getId();
 
        // Coup joué sur la case de l'effet 
        aGame.playMove(0);
        
        int id_nextplayer = aGame.getCurrentPlayer().getId();
        
        // Vérifications :
        // - la case est de la couleur opposée à celle jouée 
        // - l'effet est bien appliqué sur la case 
        // - le tour de jeu a bien changé
        assertEquals(id_nextplayer, aGame.getBoard().getTileIJ(height-1,0).getStatus());
        assertTrue("Doit être d'effet invert all tiles", aGame.getBoard().getTileIJ(height-1,0).getEffect() instanceof InvertAllTilesEffect);
        assertTrue(id_nextplayer != id_player);
        
    }
    

    /**
     * Test de InvertAllTilesEffect sur grille pré-renmplie
     * vérification du nombre de jetons
     * après application de l'effet
     * Résultat attendu : le nombre de jetons de chaque joueur doit
     * être inversé (sans oublier le jeton du joueur courant)
     */
    @Test
    public void testInvertAllTilesEffectFilledGame() {

        // On pré-remplit le plateau pour les besoins de la simulation 
        Utils.simulateAnOddGame(aGame);

        // On compte les nombres de jetons de chaque joueur
        int nbtoken_p1_before = aGame.getBoard().getTilesCountPlayer1();
        int nbtoken_p2_before = aGame.getBoard().getTilesCountPlayer2();
        
        // Effet fixé sur une case (qui n'est pas encore remplie)
        int height = aGame.getBoard().getHeight();
        // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
        aGame.getBoard().getTileIJ(height-3, 0).setEffect(new InvertAllTilesEffect());

        // Récupération de l'ID du joueur avant que le coup soit joué 
        int id_player = aGame.getCurrentPlayer().getId();
                
        // Coup joué sur cette case 
        aGame.playMove(0);
         
        // On compte les nombres de jetons de chaque joueur après le coup joué 
        int nbtoken_p1_after = aGame.getBoard().getTilesCountPlayer1();
        int nbtoken_p2_after = aGame.getBoard().getTilesCountPlayer2();
        
        // Vérifications :
        // - c'est bien le joueur 1 qui a joué 
        // - l'effet est bien appliqué sur la case 
        // - le nombre de jetons a bien été inversé 
        // - le tour de jeu a bien changé
        assertEquals(1, id_player);
        assertTrue("Doit être d'effet invert all tiles", aGame.getBoard().getTileIJ(height-3,0).getEffect() instanceof InvertAllTilesEffect);
        // Le joueur 2 doit avoir l'ancien nombre de jetons du joueur1 + 1 
        assertEquals(nbtoken_p2_after, nbtoken_p1_before + 1);
        // Le joueur 1 doit avoir l'ancien nombre de jetons du joueur2 
        assertEquals(nbtoken_p1_after, nbtoken_p2_before);        
        assertTrue(aGame.getCurrentPlayer().getId() != id_player);
    }
}
