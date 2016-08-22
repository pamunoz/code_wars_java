package com.pfariasmunoz.codewars;

import com.pfariasmunoz.codewars.two_fighters_one_winner.*;

public class Codewars {
    public static void main(String[] args) {
        
        String result1 = Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew");
        String result2 = Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry");
        String result3 = Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry");
        String result4 = Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald");
        
        
        System.out.println("The winner is: " + result1);
        System.out.println("The winner is: " + result2);
        System.out.println("The winner is: " + result3);
        System.out.println("The winner is: " + result4);
    }
        
}
