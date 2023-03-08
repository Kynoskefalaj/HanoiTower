package root;

import javax.swing.*;
import java.awt.*;

public class Mechanics {
    UserInterface ui;

    public Mechanics(UserInterface ui){
        this.ui = ui;
        moveToMiddle(ui.testButton, 400);
    }

    int[] columnsMiddle = {ui.marginX + ui.stickPanelWidth / 2,
            ui.marginX + ui.innerMargin + ui.stickPanelWidth + ui.stickPanelWidth / 2,
            ui.marginX + (ui.innerMargin + ui.stickPanelWidth ) * 2 + ui.stickPanelWidth / 2};

    public void moveToMiddle(JButton button, int diameter){
        button.setBounds(columnsMiddle[1] - diameter / 2, ui.windowY - 200, diameter, 50);
    }
}
