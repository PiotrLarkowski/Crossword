package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosingWordOrderPanel extends JPanel implements ActionListener {
    JButton backButton, showButton;
    JComboBox wordChooser;
    JLabel textMessageNextToWordChooserEN;
    JLabel textMessageNextToWordChooserPL;
    public ChoosingWordOrderPanel() {
        Toolkit toolkit = getToolkit();
        MainView.screenSize = toolkit.getScreenSize();

        this.setPreferredSize(new Dimension(MainView.screenSize.width,MainView.screenSize.height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        backButton = new JButton("Back / Powrot");
        backButton.setBounds(675,475,400,50);
        add(backButton);
        backButton.addActionListener(this);

        showButton = new JButton("Show position / Pokaz pozycje");
        showButton.setBounds(675,640,400,50);
        add(showButton);
        showButton.addActionListener(this);

        wordChooser = new JComboBox();
        wordChooser.setBounds(675,555,50,60);
        for(int i=0;i<36;i++) {
            wordChooser.addItem(i+1);
        }
        add(wordChooser);

        textMessageNextToWordChooserEN = new JLabel("Please select the number of looking word");
        textMessageNextToWordChooserEN.setBounds(735,555,500,30);
        add(textMessageNextToWordChooserEN);

        textMessageNextToWordChooserPL = new JLabel("Prosze wybrac numer szukanego slowa");
        textMessageNextToWordChooserPL.setBounds(735,580,500,30);
        add(textMessageNextToWordChooserPL);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(225,225,225));
        g.fillRect(50,50,MainView.screenSize.width-200, MainView.screenSize.height-200);

        g.setColor(Color.white);
        g.fillRect(100,100,850, 350);
        g.fillRect(100,450,550, 300);

        g.setColor(Color.BLACK);
        int numberOfRectInWidth = 0;
        int numberOfRectInHeight = 0;
        for(int i=0;i<7;i++){
            for(int j=0;j<17;j++) {
                if((j == 7 && i == 0)||(j == 9 && i == 0)
                        ||(j == 1 && i == 1 )||(j == 3 && i == 1 )||(j == 5 && i == 1 )
                        ||(j == 11 && i == 1)||(j == 13 && i == 1)||(j == 15 && i == 1)
                        ||(j == 7 && i == 2)||(j == 9 && i == 2)
                        ||(j == 1 && i == 3 )||(j == 3 && i == 3 )||(j == 5 && i == 3 )
                        ||(j == 11 && i == 3)||(j == 13 && i == 3)||(j == 15 && i == 3)
                        ||(j == 6 && i == 4)||(j == 8 && i == 4)||(j == 9 && i == 4)
                        ||(j == 0 && i == 5)||(j == 2 && i == 5)||(j == 4 && i == 5)
                        ||(j == 11 && i == 5)||(j == 12 && i == 5)||(j == 14 && i == 5)||(j == 16 && i == 5)
                        ||(j == 6 && i == 6)||(j == 8 && i == 6)||(j == 9 && i == 6)){
                    g.fillRect(100 + numberOfRectInWidth, 100+numberOfRectInHeight, 50, 50);
                }else{
                    g.drawRect(100 + numberOfRectInWidth, 100+numberOfRectInHeight, 50, 50);
                    if(wordChooser.getSelectedItem().toString().equals("1")){
                        g.setColor(Color.GREEN);
                        g.fillRect(100, 100, 50, 50);
                        g.fillRect(150, 100, 50, 50);
                        g.fillRect(200, 100, 50, 50);
                        g.fillRect(250, 100, 50, 50);
                        g.fillRect(300, 100, 50, 50);
                        g.fillRect(350, 100, 50, 50);
                        g.fillRect(400, 100, 50, 50);
                        g.setColor(Color.BLACK);
                        g.drawRect(100, 100, 50, 50);
                        g.drawRect(150, 100, 50, 50);
                        g.drawRect(200, 100, 50, 50);
                        g.drawRect(250, 100, 50, 50);
                        g.drawRect(300, 100, 50, 50);
                        g.drawRect(350, 100, 50, 50);
                        g.drawRect(400, 100, 50, 50);
                    }

                }
                numberOfRectInWidth += 50;
            }
            numberOfRectInHeight+= 50;
            numberOfRectInWidth = 0;
        }
        numberOfRectInWidth = 0;
        numberOfRectInHeight = 0;
        for(int i=0;i<6;i++){
            for(int j = 0; j<11;j++){
                if((j == 0 && i == 0)||(j == 2 && i == 0)||(j == 4 && i == 0)
                        ||(j == 6 && i == 1)||(j == 8 && i == 1)||(j == 9 && i == 1)
                        ||(j == 1 && i == 2)||(j == 3 && i == 2)||(j == 5 && i == 2)
                        ||(j == 7 && i == 3)||(j == 9 && i == 3)
                        ||(j == 1 && i == 4)||(j == 3 && i == 4)||(j == 5 && i == 4)
                        ||(j == 7 && i == 5)||(j == 9 && i == 5)){
                    g.fillRect(100+numberOfRectInWidth, 450+numberOfRectInHeight, 50, 50);
                }else{
                    g.drawRect(100+numberOfRectInWidth, 450+numberOfRectInHeight, 50, 50);
                }
                numberOfRectInWidth += 50;
            }
            numberOfRectInHeight+= 50;
            numberOfRectInWidth = 0;
        }
        g.drawRect(150,100,50,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event == backButton){
            MainView.selectOrderFrame.dispose();
            MainCrossword.window.setVisible(true);
        }else if(event == showButton){
            repaint();
        }else if(event == wordChooser){
        }
    }
}
