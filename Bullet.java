import java.awt.geom.Point2D;

public class Bullet {
    private Point2D from;
    private Point2D to;

    private Point2D current;

    private long lastUpdate = 0;

    private double deltaX;
    private double deltaY;

    /**
     * Creates a bullet with the starting and ending points as well as speed
     * @param from - starting point of the bullet
     * @param to - ending point of the bullet
     * @param speed - speed at which the bullet should move
     */
    // https://stackoverflow.com/questions/72411743/how-to-move-paint-graphics-along-slope?answertab=scoredesc#tab-top
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

    /**
     * Gets the current location of the bullet
     * @return the point of the bullet location
     */
    public Point2D getLocation() {
        return current;
    }

    /**
     * Keeps the bullet moving at a constant rate regardless of the distance
     */
    // https://stackoverflow.com/questions/771206/how-do-i-cap-my-framerate-at-60-fps-in-java
    // https://dewitters.com/dewitters-gameloop/
    public void tick() {
        long timeElapsed = System.currentTimeMillis() - lastUpdate;
        lastUpdate = System.currentTimeMillis();

        double x = current.getX();
        double y = current.getY();

        x += deltaX * (timeElapsed / 1000d);
        y += deltaY * (timeElapsed / 1000d);

        current.setLocation(x, y);
    }
}