package root;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    Main main;

    public JFrame window;
    public Container con;
    public JPanel leftStickPanel, middleStickPanel, rightStickPanel, buttonPanel;
    public JButton leftButton, middleButton, rightButton, testButton;
    int windowX = 1400;
    int windowY = 800;
    public int marginX, upperMarginY, lowerMarginY, innerMargin, stickPanelWidth, stickPanelHeight;


    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public UserInterface(Main main){
        this.main = main;
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
        buttonPanel.setBackground(Color.black);

        //buttons to move rings
        leftButton = new JButton("LEFT");
        leftButton.setBackground(Color.gray);
        leftButton.setForeground(Color.black);
        leftButton.setFont(normalFont);
        leftButton.addActionListener(main.handler);
        leftButton.setActionCommand("LEFT");
        buttonPanel.add(leftButton);

        middleButton = new JButton("MIDDLE");
        middleButton.setBackground(Color.gray);
        middleButton.setForeground(Color.black);
        middleButton.setFont(normalFont);
        middleButton.addActionListener(main.handler);
        middleButton.setActionCommand("MIDDLE");
        buttonPanel.add(middleButton);

        rightButton = new JButton("RIGHT");
        rightButton.setBackground(Color.gray);
        rightButton.setForeground(Color.black);
        rightButton.setFont(normalFont);
        rightButton.addActionListener(main.handler);
        rightButton.setActionCommand("RIGHT");
        buttonPanel.add(rightButton);


        con.add(buttonPanel);
        con.add(leftStickPanel);
        con.add(middleStickPanel);
        con.add(rightStickPanel);
        }
    }
