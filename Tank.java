import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Tank {
    private double x, y;
    private double turretDegree, baseDegree;
    private Point2D centerBase, centerTurret, endTurret;
    private BufferedImage tankBase, tankTurret;
    private int tankWidth, tankHeight;
    private int turretWidth, turretHeight;

    /**
     * Instantiates the tank object with the starting X and Y, as well as the factor to decrease dimensions by
     * @param startX - starting X position of the tank
     * @param startY - starting Y position of the tank
     * @param decreaseFactor - factor by which to decrease the dimensions of the tank by
     */
    public Tank(double startX, double startY, int decreaseFactor) {
        try {
            tankBase = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/bluetankbase.png")));
            tankTurret = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/bluetankturret.png")));
        } catch (IOException e) {
            System.out.println("Error in fetching file.");
        }
        this.tankWidth = tankBase.getWidth() / decreaseFactor;
        this.tankHeight = tankBase.getHeight() / decreaseFactor;
        this.turretWidth = tankTurret.getWidth() / decreaseFactor;
        this.turretHeight = tankTurret.getHeight() / decreaseFactor;

        this.x = startX;
        this.y = startY;
        this.turretDegree = 0;
        this.baseDegree = 0;
        this.centerBase = new Point2D.Double(0,0);
        this.centerTurret = new Point2D.Double(0,0);
        this.endTurret = new Point2D.Double(0,0);
    }

    /**
     * Gets the height of the tank, based on the PNG
     * @return height of the tank
     */
    public int getTankWidth() {
        return this.tankWidth;
    }

    /**
     * Gets the height of the tank, based on the PNG
     * @return the height of the tank
     */
    public int getTankHeight() {
        return this.tankHeight;
    }

    /**
     * Gets the current X position of the tank
     * @return the X position of the tank
     */
    public double xPos() {
        return x;
    }

    /**
     * Gets the current Y position of the tank
     * @return the Y position of the tank
     */
    public double yPos() {
        return y;
    }

    /**
     * Sets the angle of the turret
     * @param degree - angle of the turret
     */
    public void setTurretAngle(double degree) {
        this.turretDegree = degree;
    }

    /**
     * Gets the angle of the turret
     * @return the angle of the turret
     */
    public double getTurretAngle() {
        return this.turretDegree;
    }

    /**
     * Sets the angle of the tank base
     * @param degree - degree of the base
     */
    public void setBaseAngle(double degree) {
        this.baseDegree = degree;
    }

    /**
     * Gets the angle of the base
     * @return baseDegree
     */
    public double getBaseAngle() {
        return this.baseDegree;
    }

    /**
     * Sets the position of the tank (x, y)
     * @param x - x position of the tank
     * @param y - y position of the tank
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the point at the end of the turret
     * @param endTurret - point at the end of the turret
     */
    public void setEndTurret(Point2D endTurret) {
        this.endTurret = endTurret;
    }

    /**
     * Gets the point at the center of the turret
     * @return centerTurret - the angle measure of the turret angle
     */
    public Point2D getCenterTurret() {
        return this.centerTurret;
    }

    /**
     * Sets the point at the end of the turret
     * @param centerTurret - the point at the center of the turret
     */
    public void setCenterTurret(Point2D centerTurret) {
        this.centerTurret = centerTurret;
    }

    /**
     * Returns the point that is at the center of the base
     * @return centerBase - the point at the center of the tank base
     */
    public Point2D getCenterBase() {
        return this.centerBase;
    }

    /**
     * Sets the point at the center of the tank base
     * @param centerBase - point at the center of the tank base
     */
    public void setCenterBase(Point2D centerBase) {
        this.centerBase = centerBase;
    }

    /**
     * Gets the width of the turret, based on PNG
     * @return the width of the turret
     */
    public int getTurretWidth() {
        return this.turretWidth;
    }

    /**
     * Gets the height of the turret, based on the PNG
     * @return the height of the turret
     */
    public int getTurretHeight() {
        return this.turretHeight;
    }
}