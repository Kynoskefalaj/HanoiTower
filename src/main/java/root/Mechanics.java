package root;

import javax.swing.*;
import java.awt.*;

import rings.Ring;
import root.Main;

public class Mechanics {
    UserInterface ui;
    Main main;

    public Mechanics(Main main, UserInterface ui){
        this.main = main;
        this.ui = ui;
    }


    // makes Button from Ring extended classes
    public JButton makeButton(Ring ring, JButton button, String name, Color color, String action){
        button.setBackground(color);
        button.setBounds(ring.startPositionX - ring.diameter/2,
                ring.startPositionY - 25, ring.diameter, 50);
        button.setName(name);
        button.setForeground(Color.black);
        button.setFont(ui.normalFont);
        button.addActionListener(main.handler);
        button.setActionCommand(action);
        button.setVisible(true);
        return button;
    }

    public boolean isFromTop (){
        //here I will put method body that will check if selected item is from top of stack
        return false;
    };

}
