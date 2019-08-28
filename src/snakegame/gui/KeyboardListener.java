/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.gui;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import snakegame.Direction;
import snakegame.domain.Snake;

/**
 *
 * @author Marcell
 */
public class KeyboardListener implements KeyListener {

    private Snake snake;

    public KeyboardListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch(key.getKeyCode()) {
            case VK_UP: snake.setDirection(Direction.UP); break;
            case VK_DOWN: snake.setDirection(Direction.DOWN); break;
            case VK_LEFT: snake.setDirection(Direction.LEFT); break;
            case VK_RIGHT: snake.setDirection(Direction.RIGHT); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
