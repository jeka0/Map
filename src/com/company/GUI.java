package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JFrame {
    public GUI()
    {
        super("Window"); //Заголовок окна
        setBounds(200, 100, 1500, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

