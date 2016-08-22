package com.pfariasmunoz.codewars.two_fighters_one_winner;

/**
 *
 * @author pablo
 */
public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        boolean fighter1Turn = fighter1.name.equals(firstAttacker);
        boolean fighter2Turn = fighter2.name.equals(firstAttacker);
        
        while (fighter1.health > 0 && fighter2.health > 0) {
            if (fighter1Turn) {
                fighter2.health -= fighter1.damagePerAttack;
                if (fighter2.health <= 0) break;
                fighter2Turn = true;
            } 
            if (fighter2Turn) {
                fighter1.health -= fighter2.damagePerAttack;
                if (fighter1.health <= 0) break;
                fighter1Turn = true;
            }
        }
        String winner = fighter1.health > 0 ? fighter1.name : fighter2.name;
        return winner;        
    }
    
}
