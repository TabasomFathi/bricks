import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    private Ball ball;
    private Brick brick;


    public GamePanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 600));

        // Initialize ball and brick
        initializeBall();
        initializeBrick();


        // Add mouse listener to handle ball movement
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Calculate new velocity for the ball based on the click position
                int targetX = e.getX();
                int targetY = e.getY();
                int deltaX = targetX - ball.getX();
                int deltaY = targetY - ball.getY();
                double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                double speed = 5; // Adjust this value for desired speed
                ball.setSpeedX((int) (deltaX / distance * speed));
                ball.setSpeedY((int) (deltaY / distance * speed));

                updateBallPosition();
            }
        });
        startGameLoop();


    }

    private void initializeBall() {
        int ballX = getWidth() / 2; // Center of the panel horizontally
        int ballY = getHeight() - 50; // Near the bottom of the panel
        int ballDiameter = 20;
        Color ballColor = Color.RED;
        ball = new Ball(ballX, ballY, ballDiameter, ballColor, 0, 0);
    }

    private void initializeBrick() {
        int brickX = getWidth() - 50; // Near the right edge of the panel
        int brickY = 50; // Near the top of the panel
        int brickWidth = 50;
        int brickHeight = 30;
        Color brickColor = Color.BLUE;
        int brickValue = 1; // Value of the brick
        brick = new Brick(brickX, brickY, brickWidth, brickHeight, brickColor, brickValue);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        initializeBall();
        initializeBrick();


        // Draw ball
        g2d.setColor(ball.getColor());
        g2d.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());

        // Draw brick if visible
        g2d.setColor(brick.getColor());
        g2d.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());

        // Draw value text on the brick
        g2d.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 12);
        g2d.setFont(font);
        String valueText = Integer.toString(brick.getValue());
        int textX = brick.getX() + brick.getWidth() / 2 - g2d.getFontMetrics().stringWidth(valueText) / 2;
        int textY = brick.getY() + brick.getHeight() / 2 + g2d.getFontMetrics().getHeight() / 2;
        g2d.drawString(valueText, textX, textY);


    }

    private void updateBallPosition() {
        // Update ball position
        ball.updatePosition();

        // Perform collision detection with walls
        if (ball.getX() <= 0 || ball.getX() >= getWidth() - ball.getDiameter()) {
            ball.setSpeedX(-ball.getSpeedX()); // Reverse horizontal velocity
        }
        if (ball.getY() <= 0 || ball.getY() >= getHeight() - ball.getDiameter()) {
            ball.setSpeedY(-ball.getSpeedY()); // Reverse vertical velocity
        }

        // Perform collision detection with brick
        if (brick != null && ball.intersects(brick.getBounds())) {
            // Update brick value
            brick.decrementValue();
            if (brick.getValue() <= 0) {
                // Brick has been destroyed
                brick = null; // Remove brick
            }
        }

        repaint(); // Redraw the panel
    }


    private void startGameLoop() {
        Timer timer = new Timer(16, e -> {
            // Update ball position in the game loop
            updateBallPosition();
        });
        timer.start();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

            // Calculate new velocity for the ball based on the click position
            int targetX = mouseEvent.getX();
            int targetY = mouseEvent.getY();
            int deltaX = targetX - ball.getX();
            int deltaY = targetY - ball.getY();
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            double speed = 5; // Adjust this value for desired speed
            ball.setSpeedX((int) (deltaX / distance * speed));
            ball.setSpeedY((int) (deltaY / distance * speed));

            updateBallPosition();


    startGameLoop();



}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}}




