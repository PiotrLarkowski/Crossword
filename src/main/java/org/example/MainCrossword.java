package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainCrossword extends JFrame {
    public static JFrame window;
    public static ArrayList<Integer> mainOrderOfSearchingWords =
            new ArrayList<>(Arrays.asList(11,12,14,13,17,15,16,19,18,20));

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

        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_ESCAPE){
                    int answer = JOptionPane.showConfirmDialog(window,"Are You sure You want to exit? \n Czy napewno chcesz zakonczyc program?","Exit",JOptionPane.YES_NO_OPTION);
                    if(answer == JOptionPane.YES_OPTION)
                        System.exit(1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}