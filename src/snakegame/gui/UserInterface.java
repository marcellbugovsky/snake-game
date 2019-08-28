package snakegame.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import snakegame.game.SnakeGame;

public class UserInterface implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int sideLength;
    private DrawingBoard board;

    public UserInterface(SnakeGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        int width = (game.getWidth() + 1) * sideLength + 10;
        int height = (game.getHeight() + 2) * sideLength + 10;

        frame.setPreferredSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setBackground(Color.BLACK);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        // Create drawing board first which then is added into container-object.
        // After this, create keyboard listener which is added into frame-object
        board = new DrawingBoard(game, sideLength, game.getScore());
        container.add(board);
        
        frame.addKeyListener(new KeyboardListener(game.getSnake()));
    }
    
    public Updatable getUpdatable() {
        return board;
    }


    public JFrame getFrame() {
        return frame;
    }
}
