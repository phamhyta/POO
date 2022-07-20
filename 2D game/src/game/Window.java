package game;

import javax.swing.JFrame;

public class Window extends JFrame {

    private GamePanel gp;

    public Window() {
        setTitle("GAME 2D RPG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280,720));
        setIgnoreRepaint(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
