/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import snakegame.domain.Piece;
import snakegame.domain.Score;
import snakegame.game.SnakeGame;

/**
 *
 * @author Marcell
 */
public class DrawingBoard extends JPanel implements Updatable {
    
    private final static Color BACKGROUNDCOLOR = new Color(0,0,0);
    private final static Color SNAKECOLOR = new Color(255,20,147);
    private final static Color APPLECOLOR = Color.GREEN;
    private final static Font ENDSCREENFONT = new Font("Verdana", Font.BOLD, 30);
    
    private SnakeGame game;
    private int pieceLength;
    private Score score;
    
    public DrawingBoard(SnakeGame game, int pieceLength, Score score) {
        this.game = game;
        this.pieceLength = pieceLength;
        this.score = score;
        
        setBackground(BACKGROUNDCOLOR);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(game.continues()) {
            drawGame(g);
        }else {
            drawEndscreen(g);
        }
        
    }
    
    public void drawEndscreen(Graphics g) {
        g.setFont(ENDSCREENFONT);
        g.setColor(Color.GREEN);
        g.drawString("Game over", game.getWidth() / 2 * pieceLength - 90, game.getHeight() / 2 * pieceLength - 50);
        g.drawString("Your score: " + score.getScore(), game.getWidth() / 2 * pieceLength - 120, game.getHeight() / 2 * pieceLength - 10);
    }
    
    public void drawGame(Graphics g) {
        drawSnake(g);
        drawApple(g);
        drawScore(g);
    }
    
    public void drawScore(Graphics g) {
        g.drawString(score.toString(), 15, 20);
    }
    
    public void drawApple(Graphics g) {
        g.setColor(APPLECOLOR);
        g.fillOval(game.getApple().getX() * pieceLength, game.getApple().getY() * pieceLength, pieceLength, pieceLength);
    }
    
    public void drawSnake(Graphics g) {
        g.setColor(SNAKECOLOR);
        for(Piece piece : game.getSnake().getPieces()) {
            g.fill3DRect(piece.getX() * pieceLength, piece.getY() * pieceLength, pieceLength, pieceLength, true);
        }
    }

    @Override
    public void update() {
        super.repaint();
    }
}
