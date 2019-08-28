package snakegame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import snakegame.Direction;
import snakegame.domain.Apple;
import snakegame.domain.Score;
import snakegame.domain.Snake;
import snakegame.gui.Updatable;

public class SnakeGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Snake snake;
    private Random random;
    private Apple apple;
    private int appleCount;
    private Score score;

    public SnakeGame(int width, int height) {
        super(1000, null);
        
        random = new Random();
        
        appleCount = 1;
        score = new Score();

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        
        snake = new Snake(width / 2, height / 2, Direction.DOWN, this);
        setRandomApple();
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public Score getScore() {
        return score;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public void setRandomApple() {
        apple = new Apple(random.nextInt(width - 1), random.nextInt(height - 1));
        appleCount++;
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }else {
            snake.move();
            if(snake.runsInto(apple)) {
                score.increase(appleCount * 2);
                snake.grow();
                setRandomApple();
            }else if(snake.runsIntoItself()) {
                continues = false;
            }
        }
        updatable.update();
        super.setDelay(1000 / snake.getLength());
    }

}
