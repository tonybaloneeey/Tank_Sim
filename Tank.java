import java.awt.*;
import java.awt.geom.Point2D;

public class Tank {
    private double x, y;
    private double bulletX, bulletY;
    private boolean shooting;
    private double turretDegree, baseDegree;
    private double initialTurretDegree;
    private Point2D centerBase, centerTurret, endTurret;
    private int width;
    private int height;
    private Color color;
    private double slope;

    public Tank(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.turretDegree = 0;
        this.baseDegree = 0;
        this.centerBase = new Point2D.Double(0,0);
        this.centerTurret = new Point2D.Double(0,0);
        this.endTurret = new Point2D.Double(0,0);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public double xPos() {
        return x;
    }
    public double yPos() {
        return y;
    }
    public void setTurretDegree(double degree) {
        this.turretDegree = degree;
    }
    public double getTurretDegree() {
        return turretDegree;
    }
    public void setBaseDegree(double degree) {
        this.baseDegree = degree;
    }
    public double getBaseDegree() {
        return this.baseDegree;
    }
    public boolean isShooting() {
        return this.shooting;
    }
    public void setShooting(boolean bool) {
        this.shooting = bool;
    }
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point2D getEndTurret() {
        return endTurret;
    }
    public void setEndTurret(Point2D endTurret) {
        this.endTurret = endTurret;
    }
    public Point2D getCenterTurret() {
        return centerTurret;
    }
    public void setCenterTurret(Point2D centerTurret) {
        this.centerTurret = centerTurret;
    }
    public Point2D getCenterBase() {
        return centerBase;
    }
    public void setCenterBase(Point2D centerBase) {
        this.centerBase = centerBase;
    }
    public void setBulletPos(double bulletX, double bulletY) {
        this.bulletX = bulletX;
        this.bulletY = bulletY;
    }
    public void setBulletPos(Point2D point2D) {
        this.bulletX = point2D.getX();
        this.bulletY = point2D.getY();
    }
    public double getBulletX() {
        return bulletX;
    }
    public void setBulletX(double bulletX) {
        this.bulletX = bulletX;
    }
    public double getBulletY() {
        return bulletY;
    }
    public void setBulletY(double bulletY) {
        this.bulletY = bulletY;
    }

    public double getInitialTurretDegree() {
        return initialTurretDegree;
    }

    public void setInitialTurretDegree(double initialTurretDegree) {
        this.initialTurretDegree = initialTurretDegree;
    }
}