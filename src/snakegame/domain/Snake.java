/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.util.ArrayList;
import java.util.List;
import snakegame.Direction;
import snakegame.game.SnakeGame;

/**
 *
 * @author Marcell
 */
public class Snake {

    private static final int matureLength = 3;
    private Direction direction;
    private List<Piece> pieces;
    private boolean grow;
    private SnakeGame game;
    private Direction lastDirection;
    private boolean dirSet;
    

    public Snake(int originalX, int originalY, Direction originalDirection, SnakeGame game) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX,originalY));
        direction = originalDirection;
        grow = false;
        this.game = game;
        lastDirection = originalDirection;
        dirSet = false;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        if(!dirSet) {
            lastDirection = direction;
            direction = dir;
            dirSet = true;
        }
    }
    
    public int getLength() {
        return pieces.size();
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public void move() {
        dirSet = false;
        int lastX = pieces.get(pieces.size() - 1).getX();
        int lastY = pieces.get(pieces.size() - 1).getY();
        
        switch(direction) {
            case UP: if(lastDirection != Direction.DOWN) { if(lastY == 0) {pieces.add(new Piece(lastX, game.getHeight() - 1));} else {pieces.add(new Piece(lastX, lastY - 1));}} else {setDirection(Direction.DOWN); lastDirection = Direction.DOWN; move();} break;
            case LEFT: if(lastDirection != Direction.RIGHT) { if(lastX == 0) {pieces.add(new Piece(game.getWidth() - 1, lastY));} else {pieces.add(new Piece(lastX - 1, lastY));}} else {setDirection(Direction.RIGHT); lastDirection = Direction.RIGHT; move();} break;
            case RIGHT: if(lastDirection != Direction.LEFT) { if(lastX == game.getWidth() - 1) {pieces.add(new Piece(0 , lastY));} else {pieces.add(new Piece(lastX + 1, lastY));}} else {setDirection(Direction.LEFT); lastDirection = Direction.LEFT; move();} break;
            case DOWN: if(lastDirection != Direction.UP) { if(lastY == game.getHeight() - 1) {pieces.add(new Piece(lastX, 0));} else {pieces.add(new Piece(lastX, lastY + 1));}} else {setDirection(Direction.UP); lastDirection = Direction.UP; move();} break;
        }
        if(pieces.size() > matureLength && !grow) {
            pieces.remove(0);
        }else {
            grow = false;
        }
    }
    
    public void grow() {
        grow = true;
    }
    
    public boolean runsInto(Piece piece) {
        return pieces.get(pieces.size() - 1).runsInto(piece);
    }
    
    public boolean runsIntoItself() {
        for(int i = 0; i < pieces.size() - 1; i++) {
            if(runsInto(pieces.get(i))) {
                return true;
            }
        }
        return false;
    }
}
