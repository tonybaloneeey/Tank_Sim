import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel panel;
    private JButton startGame;
    private JLabel title;
    private GameFrame gameFrame;
    public MainMenu(JFrame frame) {
        frame.setContentPane(panel);
        frame.setVisible(true);
        title.setFont(new Font("Monospaced", Font.BOLD, 30));
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                gameFrame = new GameFrame();
                gameFrame.startGame();
            }
        });
    }
}
