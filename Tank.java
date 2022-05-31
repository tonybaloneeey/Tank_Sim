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

    public int getTankWidth() {
        return this.tankWidth;
    }
    public int getTankHeight() {
        return this.tankHeight;
    }
    public double xPos() {
        return x;
    }
    public double yPos() {
        return y;
    }
    public void setTurretAngle(double degree) {
        this.turretDegree = degree;
    }
    public double getTurretAngle() {
        return this.turretDegree;
    }
    public void setBaseAngle(double degree) {
        this.baseDegree = degree;
    }
    public double getBaseAngle() {
        return this.baseDegree;
    }
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setEndTurret(Point2D endTurret) {
        this.endTurret = endTurret;
    }
    public Point2D getCenterTurret() {
        return this.centerTurret;
    }
    public void setCenterTurret(Point2D centerTurret) {
        this.centerTurret = centerTurret;
    }
    public Point2D getCenterBase() {
        return this.centerBase;
    }
    public void setCenterBase(Point2D centerBase) {
        this.centerBase = centerBase;
    }
    public int getTurretWidth() {
        return this.turretWidth;
    }
    public int getTurretHeight() {
        return this.turretHeight;
    }

}