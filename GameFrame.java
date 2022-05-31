import javax.swing.*;

public class GameFrame {
    private final JFrame frame = new JFrame(); //creates the frame
    static final int FRAME_HEIGHT = 720; // Height of the JFrame
    static final int FRAME_WIDTH = 1280; // Width of the JFrame
    public GameFrame() {
        frame.setLayout(null);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Tank Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        mainMenu();
    }

    /**
     * Sets JFrame to MainMenu panel
     */
    public void mainMenu() {
        MainMenu m = new MainMenu(frame); //creates MainMenu object
    }

    /**
     * Sets JFrame to game
     */
    public void startGame() {
        GamePanel panel = new GamePanel(); //Creates GamePanel object
        panel.setVisible(true);
        frame.setContentPane(panel);
    }
}


