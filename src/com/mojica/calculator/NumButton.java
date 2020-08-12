/*
* Buttons for numbers 0-9
* */

package com.mojica.calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NumButton extends JButton {
    public NumButton(String text){
        super(text);
        setBackground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 15));

        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
    }
}
