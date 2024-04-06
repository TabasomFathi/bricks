import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanelAgain extends JPanel implements MouseListener {
    private ArrayList<Block> blocks;
    private ArrayList<Ball> balls;
    private int nextBlockNumber;
    private Random random;

    public GamePanelAgain() {
        this.setBackground(Color.WHITE);
        blocks = new ArrayList<>();
        balls = new ArrayList<>();
        nextBlockNumber = 2;
        random = new Random();

        // Add the first block at the top with number 1
        Block initialBlock = new Block(1, 0, 0);
        blocks.add(initialBlock);
        Ball initialBall = new Ball(275,500,30);
        balls.add(initialBall);

        // Add balls at the bottom
        for (int i = 0; i < 5; i++) {
            Ball ball = new Ball(275, getHeight() - 50, 50);
            balls.add(ball);
        }

        // Add mouse listener to handle clicks
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw all blocks
        for (Block block : blocks) {
            block.draw(g);
        }
        // Draw all balls
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    // Inner class representing a numbered block
    private class Block {
        public static final int BLOCK_SIZE = 40;
        private int number;
        private int x, y;

        public Block(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }


        public void draw(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(String.valueOf(number), x + BLOCK_SIZE / 2 - 5, y + BLOCK_SIZE / 2 + 5);
        }

        // Method to update block position
        public void moveDown() {
            y += 40; // Move down by 40 pixels
        }
    }
    // Inner class representing a ball
    private class Ball {
        private int x, y, diameter;

        public Ball(int x, int y, int diameter) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
        }
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x, y, diameter, diameter);
        }
    }

    // Implement MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        
        for (Block block : blocks) {
            block.moveDown();
        }
        // Add a new block at the top with the next number
        Random random = new Random();
        Block newBlock = new Block(nextBlockNumber++, random.nextInt(560), 0);
        blocks.add(newBlock);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}