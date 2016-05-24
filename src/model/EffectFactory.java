package model;

import java.util.Random;


/**
 *
 * @author hakkahi
 * 
 */


public class EffectFactory {

    public static Effect createEffect() {
        int min = 1;
        int max = 1;
        Random rand = new Random();
        //Tire un nombre aléatoire entre min et max compris
        int random = rand.nextInt(max - min + 1) + min;

        switch (random) {

            case 0:
                return new ChangeColorEffect();
            case 1:
                return new DisappearEffect();
        }

        return null;

    }

}
