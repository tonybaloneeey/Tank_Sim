import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel panel;
    private JTextField playerNameTextField;
    private JButton startGame;
    private JLabel playerName;
    private JLabel title;
    private String playerInput;
    private GameFrame gameFrame;
    public MainMenu(JFrame frame) {
        frame.setContentPane(panel);
        frame.setVisible(true);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerInput = playerNameTextField.getText();
                frame.setVisible(false);
                gameFrame = new GameFrame();
                gameFrame.startGame();
            }
        });
    }
}
