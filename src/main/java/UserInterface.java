import javax.swing.*;
import java.awt.*;

public class UserInterface {
    public JFrame window;
    public Container con;
    int windowX = 1400;
    int windowY = 800;

    public UserInterface(){
        displayWindow();
    }

    protected void displayWindow(){
        window = new JFrame(); //creating main window as an instance of JFrame
        window.setSize(windowX, windowY);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
        window.setLayout(null);
        con = window.getContentPane();
    }
}
