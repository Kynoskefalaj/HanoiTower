package root;

import javax.swing.*;
import java.awt.*;
import root.Main;

public class Mechanics {
    UserInterface ui;
    Main main;

    public Mechanics(Main main, UserInterface ui){
        this.main = main;
        this.ui = ui;
//        moveToMiddle(ui.testButton, 400);
    }

//    int[] columnsMiddle = {ui.marginX + ui.stickPanelWidth / 2,
//            ui.marginX + ui.innerMargin + ui.stickPanelWidth + ui.stickPanelWidth / 2,
//            ui.marginX + (ui.innerMargin + ui.stickPanelWidth ) * 2 + ui.stickPanelWidth / 2};

//    public void moveToMiddle(JButton button, int diameter){
//        button.setBounds(columnsMiddle[1] - diameter / 2, ui.windowY - 200, diameter, 50);
//    }

    public JButton makeButton(JButton button, String name, Color color, String action){
        button = new JButton(name);
        button.setBackground(color);
        button.setForeground(Color.black);
        button.setFont(ui.normalFont);
        button.addActionListener(main.handler);
        button.setActionCommand(action);
        button.setVisible(true);
        return button;
    }

}
