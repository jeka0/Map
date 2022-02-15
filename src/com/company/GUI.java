package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JFrame {
    public GUI()
    {
        super("My First Window"); //Заголовок окна
        setBounds(100, 100, 700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
