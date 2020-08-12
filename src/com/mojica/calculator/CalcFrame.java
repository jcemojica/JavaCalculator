/*
* Main frame of the GUI of the calculator
*/
package com.mojica.calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame implements ActionListener {
    private final int CALC_FRAME_WIDTH = 400;
    private final int CALC_FRAME_HEIGHT = 550;

    private Calculator calc;
    private Container container;

    //will display the numbers currently being worked on
    private JPanel buffPanel;
    private JLabel buffLabel;

    //will display the numbers being typed/clicked
    private JPanel inputPanel;
    private JLabel inputLabel;

    //will display the buttons
    private JPanel buttonPanel;
    private NumButton n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private OpsButton plusBtn, minusBtn, multBtn, divBtn, eqBtn, backBtn, cBtn, signBtn, decimalBtn;

    private JButton lastBtnClicked = null;

    public CalcFrame(){
        setTitle("Calculator");
        setPreferredSize(new Dimension(CALC_FRAME_WIDTH, CALC_FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setBackground(Color.decode("#F3F3F3"));

        createBuffPanel();
        createInputPanel();
        createButtonPanel();

        container.add(buffPanel);
        container.add(inputPanel);
        container.add(buttonPanel);

        calc = new Calculator();

        pack();
        setVisible(true);
        setResizable(false);
    }

    private void createBuffPanel(){
        buffPanel = new JPanel();
        buffPanel.setSize(CALC_FRAME_WIDTH, 50);
        buffPanel.setLayout(new BorderLayout());

        buffLabel = new JLabel("0");
        buffLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        buffLabel.setForeground(Color.GRAY);
        buffLabel.setBorder(new EmptyBorder(0, 0, 0, 25));

        buffPanel.add(buffLabel, BorderLayout.EAST);
    }

    private void createInputPanel(){
        inputPanel = new JPanel();
        inputPanel.setSize(CALC_FRAME_WIDTH, 130);
        inputPanel.setLayout(new BorderLayout());

        inputLabel = new JLabel("0", SwingConstants.RIGHT);
        inputLabel.setBorder(new EmptyBorder(0, 0, 10, 25));
        inputLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));

        inputPanel.add(inputLabel, BorderLayout.SOUTH);
    }

    private void createButtonPanel(){
        buttonPanel = new JPanel();
        buttonPanel.setSize(CALC_FRAME_WIDTH, CALC_FRAME_HEIGHT);
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(130,0,0,0));

        JPanel buttonPanelTop = new JPanel();
        buttonPanelTop.setLayout(new GridLayout(1,2,5,5));

        //numerical buttons
        n0 = new NumButton("0");
        n1 = new NumButton("1");
        n2 = new NumButton("2");
        n3 = new NumButton("3");
        n4 = new NumButton("4");
        n5 = new NumButton("5");
        n6 = new NumButton("6");
        n7 = new NumButton("7");
        n8 = new NumButton("8");
        n9 = new NumButton("9");

        //operational buttons
        //plusBtn, minusBtn, multBtn, divBtn, eqBtn, backBtn, ceBtn, cBtn, percentBtn, signBtn, decimalBtn;
        plusBtn = new OpsButton("+");
        minusBtn = new OpsButton("-");
        multBtn = new OpsButton("x");
        divBtn = new OpsButton("/");
        eqBtn = new OpsButton("=");
        signBtn = new OpsButton("+/-");
        decimalBtn = new OpsButton(".");

        backBtn = new OpsButton("DEL");
        cBtn = new OpsButton("C");

        buttonPanel.add(new JPanel());
        buttonPanel.add(cBtn);
        buttonPanel.add(backBtn);
        buttonPanel.add(plusBtn);

        buttonPanel.add(n7);
        buttonPanel.add(n8);
        buttonPanel.add(n9);
        buttonPanel.add(minusBtn);

        buttonPanel.add(n4);
        buttonPanel.add(n5);
        buttonPanel.add(n6);
        buttonPanel.add(multBtn);

        buttonPanel.add(n1);
        buttonPanel.add(n2);
        buttonPanel.add(n3);
        buttonPanel.add(divBtn);

        buttonPanel.add(signBtn);
        buttonPanel.add(n0);
        buttonPanel.add(decimalBtn);
        buttonPanel.add(eqBtn);

        addActionListenersToBtn();
    }

    public void addActionListenersToBtn(){
        n0.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);

        plusBtn.addActionListener(this);
        minusBtn.addActionListener(this);
        multBtn.addActionListener(this);
        divBtn.addActionListener(this);
        eqBtn.addActionListener(this);
        backBtn.addActionListener(this);
        cBtn.addActionListener(this);
        decimalBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();

        if(btnClicked instanceof NumButton){
            if(lastBtnClicked == null || lastBtnClicked instanceof NumButton){
                String label;
                if(lastBtnClicked == null)
                    label = btnClicked.getText();
                else
                    label = inputLabel.getText() + btnClicked.getText();
                inputLabel.setText(label);
                buffLabel.setText(label);
            } else {
                Double b = Double.parseDouble(btnClicked.getText());

                switch(lastBtnClicked.getText()){
                    case "+":
                        calc.setTotal(calc.add(b));
                        break;
                    case "-":
                        calc.setTotal(calc.subtract(b));
                        break;
                    case "x":
                        calc.setTotal(calc.multiply(b));
                        break;
                    case "/":
                        calc.setTotal(calc.divide(b));
                        break;
                    default: break;
                }
            }
            lastBtnClicked = btnClicked;
        } else {

        }
    }
}
