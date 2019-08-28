/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

/**
 *
 * @author Marcell
 */
public class Score {
    
    private int score;
    
    public Score() {
        score = 0;
    }
    
    public void increase(int points) {
        score += points;
    }
    
    public int getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return "Score: " + score;
    }
}
