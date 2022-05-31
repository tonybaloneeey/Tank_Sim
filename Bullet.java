import java.awt.geom.Point2D;

public class Bullet {
    private Point2D from;
    private Point2D to;

    private Point2D current;

    private long lastUpdate = 0;

    private double deltaX;
    private double deltaY;

    public Bullet(Point2D from, Point2D to, int speed) {
        this.from = from;
        this.to = to;
        current = new Point2D.Double(from.getX(), from.getY());

        double deltaX = from.getX() - to.getX();
        double deltaY = from.getY() - to.getY();
        double angle = Math.atan2(deltaY, deltaX) + Math.toRadians(180);

        this.deltaY = Math.sin(angle) * speed;
        this.deltaX = Math.cos(angle) * speed;
        lastUpdate = System.currentTimeMillis();
    }

    public Point2D getLocation() {
        return current;
    }

    public void tick() {
        long elapsedTime = System.currentTimeMillis() - lastUpdate;
        lastUpdate = System.currentTimeMillis();

        double x = current.getX();
        double y = current.getY();

        x += deltaX * (elapsedTime / 1000d);
        y += deltaY * (elapsedTime / 1000d);

        current.setLocation(x, y);
    }
}