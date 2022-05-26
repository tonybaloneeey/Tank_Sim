import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("ALL")
public class GamePanel extends JPanel implements ActionListener, MouseListener
{
    static final int FRAME_HEIGHT = 720;
    static final int FRAME_WIDTH = 1280;
    static final int playerTank_PNG_WIDTH = 134;
    static final int playerTank_PNG_HEIGHT = 204;
    private int focus = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private final String RIGHT = "right";
    private final String LEFT = "left";
    private final String UP = "up";
    private final String DOWN = "down";
    private final String RIGHTP = "rightp";
    private final String LEFTP = "leftp";
    private final String UPP = "upp";
    private final String DOWNP = "downp";
    private final String RIGHTR = "rightr";
    private final String LEFTR = "leftr";
    private final String UPR = "upr";
    private final String DOWNR = "downr";
    private final int MOVEMENT_SPEED = 5;
    private boolean moveUp, moveDown, rotateRight, rotateLeft;
    private Point mouseLoc;
    private Point topMid, bottomMid;
    private Point2D centerBase, centerTurret;
    private int mouseLocX, mouseLocY;
    private double mouseDist, mouseDistX, mouseDistY;
    private double mouseDegree;
    private Timer timer;
    private Tank playerTank;
    private BufferedImage blueTankBase, redTankBase, blueTankTurret, redTankTurret;
    private moveAction leftpress, rightpress, uppress, downpress, leftrelease, rightrelease, uprelease, downrelease;
    public GamePanel() {
        playerTank = new Tank(50, 50, Color.white);
        this.centerBase = new Point2D.Double(0,0);
        this.addMouseListener(this);

        try {
            blueTankBase = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/bluetankbase.png")));
            redTankBase = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/redtankbase.png")));
            blueTankTurret = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/bluetankturret.png")));
            redTankTurret = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/redtankturret.png")));
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

        leftpress = new moveAction(LEFT, 1);
        rightpress = new moveAction(RIGHT, 1);
        uppress = new moveAction(UP, 1);
        downpress = new moveAction(DOWN, 1);

        leftrelease = new moveAction(LEFT, 0);
        rightrelease = new moveAction(RIGHT, 0);
        uprelease = new moveAction(UP, 0);
        downrelease = new moveAction(DOWN, 0);

        this.getInputMap(focus).put(KeyStroke.getKeyStroke("pressed A"), LEFTP);
        this.getActionMap().put(LEFTP, leftpress);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("pressed D"), RIGHTP);
        this.getActionMap().put(RIGHTP, rightpress);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("pressed W"), UPP);
        this.getActionMap().put(UPP, uppress);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("pressed S"), DOWNP);
        this.getActionMap().put(DOWNP, downpress);

        this.getInputMap(focus).put(KeyStroke.getKeyStroke("released A"), LEFTR);
        this.getActionMap().put(LEFTR, leftrelease);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("released D"), RIGHTR);
        this.getActionMap().put(RIGHTR, rightrelease);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("released W"), UPR);
        this.getActionMap().put(UPR, uprelease);
        this.getInputMap(focus).put(KeyStroke.getKeyStroke("released S"), DOWNR);
        this.getActionMap().put(DOWNR, downrelease);

        startGame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        playerTank.setShooting(true);
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

    private class moveAction extends AbstractAction {

        String direction;
        int state;
        moveAction(String direction, int state) {
            this.direction = direction;
            this.state = state;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(direction.equals(RIGHT) && state == 1) {
                rotateRight = true;
            }
            if(direction.equals(LEFT) && state == 1) {
                rotateLeft = true;
            }
            if(direction.equals(UP) && state == 1) {
                moveUp = true;
            }
            if(direction.equals(DOWN) && state == 1) {
                moveDown = true;
            }

            if(direction.equals(RIGHT) && state == 0) {
                rotateRight = false;
            }
            if(direction.equals(LEFT) && state == 0) {
                rotateLeft = false;
            }
            if(direction.equals(UP) && state == 0) {
                moveUp = false;
            }
            if(direction.equals(DOWN) && state == 0) {
                moveDown = false;
            }
        }
    }

    public void update() {
        centerTurret = new Point2D.Double(playerTank.xPos() + 67, playerTank.yPos() + 125);
        centerBase = new Point2D.Double(playerTank.xPos() + (playerTank_PNG_WIDTH / 2), playerTank.yPos() + (playerTank_PNG_HEIGHT / 2));

        mouseLoc = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mouseLoc, this);

        mouseLocX = (int) mouseLoc.getX();
        mouseLocY = (int) mouseLoc.getY();

        mouseDistX = mouseLocX - centerTurret.getX();
        mouseDistY = mouseLocY - centerTurret.getY();

        mouseDegree = angleInRelation(mouseLoc, centerTurret);

        if(moveUp) {
            playerTank.setLocation(playerTank.xPos() + (MOVEMENT_SPEED * Math.sin(Math.toRadians(playerTank.getBaseDegree()))), playerTank.yPos() - MOVEMENT_SPEED * Math.cos(Math.toRadians(playerTank.getBaseDegree())));
        }
        if(moveDown) {
            playerTank.setLocation(playerTank.xPos() - (MOVEMENT_SPEED * Math.sin(Math.toRadians(playerTank.getBaseDegree()))), playerTank.yPos() + MOVEMENT_SPEED * Math.cos(Math.toRadians(playerTank.getBaseDegree())));
        }
        if(rotateLeft && playerTank.xPos() >= 0) {
            playerTank.setBaseDegree(playerTank.getBaseDegree() - 5);
        }
        if(rotateRight && playerTank.xPos() + playerTank.getWidth() <= FRAME_WIDTH) {
            playerTank.setBaseDegree(playerTank.getBaseDegree() + 5);
        }

        mouseDegree -= playerTank.getBaseDegree();

        this.setBackground(Color.white);
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.white);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.white);
        g2D.setColor(Color.white);

        g2D.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        paintBase(g2D);

        playerTank.setTurretDegree(mouseDegree);
        g2D.rotate(Math.toRadians(playerTank.getTurretDegree()), playerTank.xPos() + 67, playerTank.yPos() + 125);
        paintTurret(g2D);
    }
    public void paintBase(Graphics2D g2D) {
        g2D.rotate(Math.toRadians(playerTank.getBaseDegree()), centerBase.getX(), centerBase.getY());
        g2D.drawImage(blueTankBase, (int) playerTank.xPos(), (int) playerTank.yPos(), playerTank_PNG_WIDTH, playerTank_PNG_HEIGHT, null);
    }

    public void paintTurret(Graphics2D g2D) {
        g2D.drawImage(blueTankTurret, (int) playerTank.xPos()+33, (int) playerTank.yPos() - 10, 68, 176, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
    public double angleInRelation(Point mouseLoc, Point2D tankLoc) {
        double angle = Math.toDegrees(Math.atan2((mouseLoc.getY() - tankLoc.getY()), mouseLoc.getX() - tankLoc.getX()));
        angle += 90;
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }
    public void startGame()
    {
        timer = new Timer(1000/60, this);
        timer.start();
    }
}