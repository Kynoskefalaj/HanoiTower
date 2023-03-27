package root;

import rings.Ring;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    Main main;

    public JFrame window;
    public JLayeredPane layeredPane;
    public Container con;
    public JPanel leftStickPanel, middleStickPanel, rightStickPanel, buttonPanel, testPanel, aiPanel;
    public JButton leftButton, middleButton, rightButton, aiButton, automaticSolveButton, resetButton;
    public JLabel leftDiameter, midDiameter, rightDiameter, leftAltitude, midAltitude, rightAltitude, counter;
    int windowX = 1400;
    int windowY = 800;
    public int marginX, upperMarginY, lowerMarginY, innerMargin, stickPanelWidth, stickPanelHeight;


    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public UserInterface(Main main) {
        this.main = main;
        displayWindow();
        displayGameScreen();
    }

    protected void displayWindow() {
        window = new JFrame(); //creating main window as an instance of JFrame
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
        window.setLayout(null);
        con = window.getContentPane();

        //set layers for elements
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(new BorderLayout());
    }

    public void displayGameScreen() {

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
//        leftStickPanel.setVisible(false);

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


        //test panel
        testPanel = new JPanel();
        testPanel.setBounds(417, 50 + 18, 800, 100);
        testPanel.setBackground(Color.black);
        testPanel.setLayout(new GridLayout(2, 3));
        con.add(testPanel);
        testPanel.setVisible(false);


        //test labels
        leftDiameter = new JLabel("test1");
        leftDiameter.setForeground(Color.green);
        testPanel.add(leftDiameter);

        midDiameter = new JLabel("test2");
        midDiameter.setForeground(Color.green);
        testPanel.add(midDiameter);

        rightDiameter = new JLabel("test3");
        rightDiameter.setForeground(Color.green);
        testPanel.add(rightDiameter);

        leftAltitude = new JLabel("test4");
        leftAltitude.setForeground(Color.green);
        testPanel.add(leftAltitude);

        midAltitude = new JLabel("test5");
        midAltitude.setForeground(Color.green);
        testPanel.add(midAltitude);

        rightAltitude = new JLabel("test6");
        rightAltitude.setForeground(Color.green);
        testPanel.add(rightAltitude);

        aiPanel = new JPanel();
        aiPanel.setBounds(50, 50, 200, 150);
        aiPanel.setBackground(Color.black);
        aiPanel.setVisible(true);
        con.add(aiPanel);

        aiButton = new JButton("MOVE");
        aiButton.setBackground(Color.black);
        aiButton.setForeground(Color.white);
        aiButton.setFont(normalFont);
        aiButton.addActionListener(main.handler);
        aiButton.setActionCommand("MOVE");
        aiPanel.add(aiButton);

        automaticSolveButton = new JButton("RESOLVE");
        automaticSolveButton.setBackground(Color.BLACK);
        automaticSolveButton.setForeground(Color.white);
        automaticSolveButton.setFont(normalFont);
        automaticSolveButton.addActionListener(main.handler);
        automaticSolveButton.setActionCommand("RESOLVE");
        aiPanel.add(automaticSolveButton);

        resetButton = new JButton("RESET");
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(Color.white);
        resetButton.setFont(normalFont);
        resetButton.addActionListener(main.handler);
        resetButton.setActionCommand("RESET");
        aiPanel.add(resetButton);


//        counter = new JLabel("count");
//        counter.setForeground(Color.red);
//        counter.setVisible(false);
//        testPanel.add(counter);


        con.add(buttonPanel);
        con.add(leftStickPanel);
        con.add(layeredPane);
        con.add(middleStickPanel);
        con.add(rightStickPanel);
    }

}

