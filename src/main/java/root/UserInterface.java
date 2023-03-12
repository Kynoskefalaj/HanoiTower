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
    public int marginX, upperMarginY, lowerMarginY, innerMargin, stickPanelWidth, stickPanelHeight;


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
        marginX = 225;
        upperMarginY = 250;
        lowerMarginY = 50;
        innerMargin = 400;

        //sticks dimensions
        stickPanelWidth = (windowX - 2 * marginX - 2 * innerMargin) / 3; //default 400
        stickPanelHeight = windowY - upperMarginY - lowerMarginY - 100;

        //sticks made of JPanels
        leftStickPanel = new JPanel();
        leftStickPanel.setBounds(marginX, upperMarginY, stickPanelWidth, stickPanelHeight);
        leftStickPanel.setBackground(Color.gray);

        middleStickPanel = new JPanel();
        middleStickPanel.setBounds(marginX + stickPanelWidth + innerMargin, upperMarginY, stickPanelWidth, stickPanelHeight);
        middleStickPanel.setBackground(Color.gray);

        rightStickPanel = new JPanel();
        rightStickPanel.setBounds(marginX + 2 * (innerMargin + stickPanelWidth), upperMarginY, stickPanelWidth, stickPanelHeight);
        rightStickPanel.setBackground(Color.gray);

        // panel for buttons
        buttonPanel = new JPanel();
        buttonPanel.setBounds(marginX, windowY - lowerMarginY - 50, windowX - 2 * marginX, 50);
        buttonPanel.setBackground(Color.green);

        //buttons to move rings
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


//        int[] columnsMiddle = {marginX + stickPanelWidth / 2,
//                marginX + innerMargin + stickPanelWidth + stickPanelWidth / 2,
//                marginX + (innerMargin + stickPanelWidth ) * 2 + stickPanelWidth / 2};
//
//        testButton.setBounds(columnsMiddle[1] - 400 / 2, windowY - 200, 400, 50);

//        testButton = new JButton("TEST");
//        testButton.setBounds(150 + 800, windowY - 50 * 4, 400, 50);
//        testButton.setBackground(Color.magenta);
//        testButton.setForeground(Color.black);
//        testButton.setFont(normalFont);
//        con.add(testButton);

//        JButton test2Button = new JButton("400");
//        test2Button.setBackground(Color.cyan);
//        test2Button.setName("400");
//        test2Button.setForeground(Color.black);
//        test2Button.setFont(normalFont);
//        test2Button.addActionListener(main.handler);
//        test2Button.setActionCommand("400");
//        test2Button.setVisible(true);
//        con.add(test2Button);

        con.add(buttonPanel);
        con.add(leftStickPanel);
        con.add(middleStickPanel);
        con.add(rightStickPanel);
        }
    }
