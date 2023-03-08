package root;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    public JFrame window;
    public Container con;
    public JPanel leftStickPanel, middleStickPanel, rightStickPanel, buttonPanel;
    public JButton leftButton, middleButton, rightButton, testButton;
    int windowX = 1400;
    int windowY = 800;
    public int marginX, marginY, innerMargin, stickPanelWidth, stickPanelHeight;

    Main main;

    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public UserInterface(){
        displayWindow();
        displayGameScreen();
    }

    protected void displayWindow(){
        window = new JFrame(); //creating main window as an instance of JFrame
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
        window.setLayout(null);
        con = window.getContentPane();
    }

    public void displayGameScreen(){

        //align every margin and set them to 50
        marginX = 50;
        marginY = 50;
        innerMargin = 50;

        buttonPanel = new JPanel();
        buttonPanel.setBounds(marginX, windowY - marginY - 50, windowX - 2 * marginX, 50);
        buttonPanel.setBackground(Color.green);

        stickPanelWidth = (windowX - 2 * marginX - 2 * innerMargin) / 3; //default 400
        stickPanelHeight = windowY - 2 * marginY - 100;

        leftStickPanel = new JPanel();
        leftStickPanel.setBounds(marginX, marginY, stickPanelWidth, stickPanelHeight);
        leftStickPanel.setBackground(Color.yellow);

        middleStickPanel = new JPanel();
        middleStickPanel.setBounds(marginX + stickPanelWidth + innerMargin, marginY, stickPanelWidth, stickPanelHeight);
        middleStickPanel.setBackground(Color.cyan);

        rightStickPanel = new JPanel();
        rightStickPanel.setBounds(marginX + 2 * (innerMargin + stickPanelWidth), marginY, stickPanelWidth, stickPanelHeight);
        rightStickPanel.setBackground(Color.magenta);


        leftButton = new JButton("LEFT");
        leftButton.setBackground(Color.yellow);
        leftButton.setForeground(Color.black);
        leftButton.setFont(normalFont);
        buttonPanel.add(leftButton);

        middleButton = new JButton("MIDDLE");
        middleButton.setBackground(Color.cyan);
        middleButton.setForeground(Color.black);
        middleButton.setFont(normalFont);
        buttonPanel.add(middleButton);

        rightButton = new JButton("RIGHT");
        rightButton.setBackground(Color.magenta);
        rightButton.setForeground(Color.black);
        rightButton.setFont(normalFont);
        buttonPanel.add(rightButton);

        testButton = new JButton("TEST");
        testButton.setBounds(150 + 800, windowY - 50 * 4, 400, 50);
        testButton.setBackground(Color.magenta);
        testButton.setForeground(Color.black);
        testButton.setFont(normalFont);
        con.add(testButton);

        con.add(buttonPanel);
        con.add(leftStickPanel);
        con.add(middleStickPanel);
        con.add(rightStickPanel);

        int[] columnsMiddle = {marginX + stickPanelWidth / 2,
                marginX + innerMargin + stickPanelWidth + stickPanelWidth / 2,
                marginX + (innerMargin + stickPanelWidth ) * 2 + stickPanelWidth / 2};

        testButton.setBounds(columnsMiddle[1] - 400 / 2, windowY - 200, 400, 50);
        }
    }
