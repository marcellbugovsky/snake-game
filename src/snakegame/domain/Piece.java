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
public class Piece {

    private int x;
    private int y;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece) {
        if(x == piece.getX() && y == piece.getY()) {
            return true;
        }else {
            return false;
        }
    }
    
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
