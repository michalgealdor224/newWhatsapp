import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
  public static final int  WIDTH_OF_WINDOW = 700,HEIGHT_OF_WINDOW = 600;
    public static void main(String[] args) {

        new Main();

    }
    public Main () {
        this.setSize(WIDTH_OF_WINDOW,HEIGHT_OF_WINDOW);
        this.setResizable(false);
        this.setBackground(Color.cyan);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        OpenWindow openWindow = new OpenWindow();
        add(openWindow);
    }
}
