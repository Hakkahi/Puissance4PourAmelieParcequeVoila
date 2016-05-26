package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Classe de tests de l'effet Disappear
 * Principe de l'effet : un pion joué sur une case portant 
 *  l'effet Disappear disparaît immédiatement. 
 *  Conséquences : l'état du jeu n'est pas modifié, le pion 
 *  joué n'apparaît pas sur la grille, et le tour de jeu 
 *  change
 * @author acordier
 */
public class DisappearEffectTest {
    
    static Game agame;
    static Game anEmptyGame;
    
    public DisappearEffectTest() {
    }
    
    // Liste des tests à faire : 
    // - Tester que l'effet marche sur une grille vide
    // - Tester que l'effet marche sur une grille vide en regardant le nombre de pions
    // - Tester que l'effet marche sur une grille remplie
    // - Tester que l'effet marche en regardant le nombre de pions de la grille
    // - Tester que l'effet est "sans effet" sur une case qui ne le comporte pas
    // - Tester que le tour est bien passé
   
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
               
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
 
        agame = new Game();
        Board b = new Board(10,10);
        agame.setBoard(b);
  
        for(int i=0; i<10; i++){
            agame.playMove(i);
        }
        for(int i=0; i<10; i=i+2){
            agame.playMove(i);
        }
        
        System.out.println(agame.getBoard().toStringSymbols());

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test de DisappearEffect sur grille vide
     * vérification de l'état de la tuile 
     * après application de l'effet
     * Résultat attendu : la case doit être vide
     */
    @Test
    public void testDisappearEffectEmptyGame() {

        // Création d'un jeu vide
        anEmptyGame = new Game();
        Board b = new Board(10,10);
        anEmptyGame.setBoard(b);
        
        
        // Effet fixé sur une case 
        int height = anEmptyGame.getBoard().getHeight();
        anEmptyGame.getBoard().getTileIJ(height-1, 0).setEffect(new DisappearEffect());

        // Coup joué sur cette case 
        anEmptyGame.playMove(0);
         
        // Vérification que la case est bien vide et que l'effet est bien appliqué sur la case 
        assertEquals(-1, anEmptyGame.getBoard().getTileIJ(height-1,0).getIdPlayer());
        assertTrue("Doit être d'effet disappear", anEmptyGame.getBoard().getTileIJ(height-1,0).getEffect() instanceof DisappearEffect);
    }
    
    /**
     * Test de DisappearEffect sur grille vide
     * vérification du nombre de tuiles après jeu 
     * Résultat attendu : le nombre doit être égal à 0
     */
    @Test
    public void testDisappearEffectEmptyGameWithTilesNumber() {

        // Création d'un jeu vide
        anEmptyGame = new Game();
        Board b = new Board(10,10);
        anEmptyGame.setBoard(b);
        
        
        // Effet fixé sur une case 
        int height = anEmptyGame.getBoard().getHeight();
        anEmptyGame.getBoard().getTileIJ(height-1, 0).setEffect(new DisappearEffect());

        // Coup joué sur cette case 
        anEmptyGame.playMove(0);
         
        // Vérification que la case est bien vide 
        assertEquals(0, anEmptyGame.getTotalTilesCount());
        assertTrue("Doit être d'effet disappear", anEmptyGame.getBoard().getTileIJ(height-1,0).getEffect() instanceof DisappearEffect);
    }

    /**
     * Test de DisappearEffect sur grille pré-renmplie
     * vérification de l'état de la tuile 
     * après application de l'effet
     * Résultat attendu : la case doit être vide
     */
    @Test
    public void testDisappearEffectFilledGame() {

        fail("Todo... not done so far");
        // Création d'un jeu vide
        anEmptyGame = new Game();
        Board b = new Board(10,10);
        anEmptyGame.setBoard(b);
        
        
        // Effet fixé sur une case 
        int height = anEmptyGame.getBoard().getHeight();
        anEmptyGame.getBoard().getTileIJ(height-1, 0).setEffect(new DisappearEffect());

        // Coup joué sur cette case 
        anEmptyGame.playMove(0);
         
        // Vérification que la case est bien vide et que l'effet est bien appliqué sur la case 
        assertEquals(-1, anEmptyGame.getBoard().getTileIJ(height-1,0).getIdPlayer());
        assertTrue("Doit être d'effet disappear", anEmptyGame.getBoard().getTileIJ(height-1,0).getEffect() instanceof DisappearEffect);
    }

    
}
