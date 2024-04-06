import java.awt.*;

public class Ball {
    private int x, y; // Position of the ball
    private int diameter; // Diameter of the ball
    private Color color; // Color of the ball
    private int speedX, speedY; // Velocity of the ball


    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public Ball(int x, int y, int diameter, Color color, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
        this.speedX = speedX;
        this.speedY = speedY;
    }



    public void updatePosition() {

        x += speedX;
        y += speedY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Method to check collision with the game boundaries
    public void checkBoundaryCollision(int panelWidth, int panelHeight) {
        if (x <= 0 || x >= panelWidth - diameter) {
            // Reverse horizontal velocity if hitting the left or right boundary
            speedX = -speedX;
        }
        if (y <= 0 || y >= panelHeight - diameter) {
            // Reverse vertical velocity if hitting the top or bottom boundary
            speedY = -speedY;
        }
    }

    // Method to check collision with another object (e.g., brick)
    public boolean intersects(Rectangle other) {

        Rectangle ballRect = new Rectangle(x, y, diameter, diameter);
        return ballRect.intersects(other);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
