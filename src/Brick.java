import java.awt.*;

public class Brick {
    private int x, y; // Position of the brick
    private int width, height; // Size of the brick
    private Color color; // Color of the brick
    private int value; // Value of the brick

    public Brick(int x, int y, int width, int height, Color color, int value) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void decrementValue() {
        value--;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        // Draw value on the brick
        g.drawString(String.valueOf(value), x + width / 2, y + height / 2);
    }
}
