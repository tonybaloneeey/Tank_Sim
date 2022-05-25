import javax.swing.*;


public class GameFrame{
    //TODO RESET NETWORK WITH BACK BUTTON
    private JFrame frame = new JFrame(); //creates the frame
    static final int FRAME_HEIGHT = 720; //should be changed in settings later
    static final int FRAME_WIDTH = 1280; //should be changed in settings later
    private GamePanel panel; //used for the actual game

    public GameFrame() {
        frame.setLayout(null);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Tank Game");
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
     * Sets JFrame to host menu panel
     */

    public void startGame() {
        panel = new GamePanel(/*game*/); //Creates GamePanel object
        panel.setVisible(true);
        frame.setContentPane(panel);
    }
}


