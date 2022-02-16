package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JFrame {
    public GUI()
    {
        super("Window"); //Заголовок окна
        setBounds(300, 100, 1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

