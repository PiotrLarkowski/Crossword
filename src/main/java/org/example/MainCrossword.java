package org.example;
import javax.swing.*;
import java.awt.*;

public class MainCrossword extends JFrame {
    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Crossword");
        window.setUndecorated(true);
        window.setVisible(true);

        MainView crosswordPanel = new MainView();
        NavigationBar navigationBar = new NavigationBar();

        crosswordPanel.setLayout(null);

        window.add(navigationBar, BorderLayout.NORTH);
        window.add(crosswordPanel, BorderLayout.CENTER);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}