package com.mojica.calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OpsButton extends JButton {
    public OpsButton(String text){
        super(text);
        setBackground(Color.decode("#F7F7F7"));
        setFont(new Font("SansSerif", Font.PLAIN, 15));

        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
    }
}
