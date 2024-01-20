package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

public class ChoosingWordOrderPanel extends JPanel implements ActionListener{
    JButton backButton, showButton, applyChangeButton;
    JComboBox wordChooser, wordChooserSecond, wordChooserThird;
    JLabel textMessageNextToWordChooserEN;
    JLabel textMessageNextToWordChooserPL;
    JLabel currentOrderText;
    JLabel currentOrderNumberOrder;
    JLabel changingPositionLabelFirst, changingPositionLabelSecond, changingPositionLabelThirst;

    private static ArrayList<WordVariable> getWordVariables() {
        WordVariable word;
        ArrayList<WordVariable> allWordsList = new ArrayList<>();
        int[] wordLength = {7,5,5,7,6,5,4,5,5,4,13,7,7,5,7,5,5,7,3,3,7,5,6,5,5,6,6,6,5,7,5,7,5,4,5,4,5};
        int[] firstPositionOfXAxis = {100,100,200,100,100,300,400,400,400,500,600,600,600,700,600,800,900,600,750,850,450,
                150,100,250,350,350,350,100,100,100,200,100,300,400,400,500,400};
        int[] firstPositionOfYAxis = {100,100,100,200,300,100,100,150,250,100,100,100,200,100,300,100,100,400,300,300,250,
                300,400,300,300,350,450,500,500,600,500,700,500,550,550,550,650};
        boolean[] VerticalOrHorizontal = {false,true,true,false,false,true,true,false,false,true,true,false,false,true,false,
                true,true,false,true,true,true,true,false,true,true,false,false,false,true,false,true,false,true,true,
                false,true,false};
        for (int i = 0; i < 37; i++) {
            word = new WordVariable(i+1,wordLength[i],VerticalOrHorizontal[i],firstPositionOfXAxis[i],firstPositionOfYAxis[i]);
            allWordsList.add(word);
        }
        return allWordsList;
    }

    public ChoosingWordOrderPanel() {
        Toolkit toolkit = getToolkit();
        MainView.screenSize = toolkit.getScreenSize();

        this.setPreferredSize(new Dimension(MainView.screenSize.width, MainView.screenSize.height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        backButton = new JButton("Back / Powrot");
        backButton.setBounds(795, 475, 400, 50);
        backButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            MainView.selectOrderFrame.dispose();
                            MainCrossword.window.setVisible(true);
                        }
                    }
                });
        add(backButton);
        backButton.addActionListener(this);


        showButton = new JButton("Show position / Pokaz pozycje");
        showButton.setBounds(795, 640, 400, 50);
        showButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            repaint();
                        }
                    }
                });
        add(showButton);
        showButton.addActionListener(this);

        wordChooser = new JComboBox();
        wordChooser.setBounds(815, 555, 50, 60);
        for (int i = 0; i < 37; i++) {
            wordChooser.addItem(i + 1);
        }
        wordChooser.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            repaint();
                        }else if (e.getKeyCode() == KeyEvent.VK_1) {
                            wordChooser.setSelectedIndex(0);
                        }
                    }
                });
        add(wordChooser);

        textMessageNextToWordChooserEN = new JLabel("Please select the number of looking word");
        textMessageNextToWordChooserEN.setBounds(875, 555, 500, 30);
        add(textMessageNextToWordChooserEN);

        textMessageNextToWordChooserPL = new JLabel("Prosze wybrac numer szukanego slowa");
        textMessageNextToWordChooserPL.setBounds(875, 580, 500, 30);
        add(textMessageNextToWordChooserPL);

        currentOrderText = new JLabel("Current order / Obecna kolejnosc");
        currentOrderText.setBounds(905, 690, 500, 30);
        add(currentOrderText);

        currentOrderNumberOrder = new JLabel("");
        printOnScreanOrderOfWords();
        currentOrderNumberOrder.setBounds(700, 720, 1000, 30);
        add(currentOrderNumberOrder);

        changingPositionLabelFirst = new JLabel("There is 37 words in all crossword. Select the word number in the first cell to change its position and then position the second cell to insert the word there");
        changingPositionLabelFirst.setBounds(200, 800, 2000, 30);
        add(changingPositionLabelFirst);

        changingPositionLabelSecond = new JLabel("Jest 37 slowa w calej krzyzowce. Wybierz numer slowa w pierwszej komorce, aby zmienic jej pozycje a nastepnie ustaw druga komorkę, aby wstawic tam slowo");
        changingPositionLabelSecond.setBounds(200, 830, 2000, 30);
        add(changingPositionLabelSecond);

        wordChooserSecond = new JComboBox();
        wordChooserSecond.setBounds(400, 860, 50, 30);
        for (int i = 0; i < 37; i++) {
            wordChooserSecond.addItem(i + 1);
        }
        add(wordChooserSecond);

        changingPositionLabelThirst = new JLabel("Change to / Zamien na");
        changingPositionLabelThirst.setBounds(480, 860, 2000, 30);
        add(changingPositionLabelThirst);

        wordChooserThird = new JComboBox();
        wordChooserThird.setBounds(650, 860, 50, 30);
        for (int i = 0; i < 37; i++) {
            wordChooserThird.addItem(i + 1);
        }
        add(wordChooserThird);

        applyChangeButton = new JButton("Apply change / Zatwierdz zmiane");
        applyChangeButton.setBounds(730, 860, 300, 30);
        add(applyChangeButton);
        applyChangeButton.addActionListener(this);
    }

    private void printOnScreanOrderOfWords() {
        for(int j=0;j<MainCrossword.mainOrderOfSearchingWords.size();j++){
            currentOrderNumberOrder.setText(currentOrderNumberOrder.getText()+MainCrossword.mainOrderOfSearchingWords.get(j));
            if(j+1!=MainCrossword.mainOrderOfSearchingWords.size()){
                currentOrderNumberOrder.setText(currentOrderNumberOrder.getText()+"-");
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<WordVariable> allWordsList = getWordVariables();

        g.setColor(new Color(225, 225, 225));
        g.fillRect(50, 50, MainView.screenSize.width - 200, MainView.screenSize.height - 200);

        g.setColor(Color.white);
        g.fillRect(100, 100, 850, 350);
        g.fillRect(100, 450, 550, 300);

        g.setColor(Color.BLACK);
        int numberOfRectInWidth = 0;
        int numberOfRectInHeight = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 17; j++) {
                if ((j == 7 && i == 0) || (j == 9 && i == 0)
                        || (j == 1 && i == 1) || (j == 3 && i == 1) || (j == 5 && i == 1)
                        || (j == 11 && i == 1) || (j == 13 && i == 1) || (j == 15 && i == 1)
                        || (j == 7 && i == 2) || (j == 9 && i == 2)
                        || (j == 1 && i == 3) || (j == 3 && i == 3) || (j == 5 && i == 3)
                        || (j == 11 && i == 3) || (j == 13 && i == 3) || (j == 15 && i == 3)
                        || (j == 6 && i == 4) || (j == 8 && i == 4) || (j == 9 && i == 4)
                        || (j == 0 && i == 5) || (j == 2 && i == 5) || (j == 4 && i == 5)
                        || (j == 11 && i == 5) || (j == 12 && i == 5) || (j == 14 && i == 5) || (j == 16 && i == 5)
                        || (j == 6 && i == 6) || (j == 8 && i == 6) || (j == 9 && i == 6)) {
                    g.fillRect(100 + numberOfRectInWidth, 100 + numberOfRectInHeight, 50, 50);
                } else {
                    g.drawRect(100 + numberOfRectInWidth, 100 + numberOfRectInHeight, 50, 50);
                    int selectedWord = wordChooser.getSelectedIndex()+1;
                    for (int k = 0; k < allWordsList.size(); k++) {
                        if (allWordsList.get(k).numberOfWord == selectedWord ) {
                            for (int kk = 0; kk < allWordsList.get(k).lengthOfWord; kk++) {
                                if(allWordsList.get(k).verticalOrHorizontal){
                                    g.setColor(Color.GREEN);
                                    g.fillRect(allWordsList.get(k).PositionOfFirstCharInXAxis, allWordsList.get(k).PositionOfFirstCharInYAxis+(kk *50), 50, 50);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(allWordsList.get(k).PositionOfFirstCharInXAxis, allWordsList.get(k).PositionOfFirstCharInYAxis+(kk *50), 50, 50);
                                }else{
                                    g.setColor(Color.GREEN);
                                    g.fillRect(allWordsList.get(k).PositionOfFirstCharInXAxis+(kk *50), allWordsList.get(k).PositionOfFirstCharInYAxis, 50, 50);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(allWordsList.get(k).PositionOfFirstCharInXAxis+(kk *50), allWordsList.get(k).PositionOfFirstCharInYAxis, 50, 50);
                                }
                            }
                        }
                    }

                }
                numberOfRectInWidth += 50;
            }
            numberOfRectInHeight += 50;
            numberOfRectInWidth = 0;
        }
        numberOfRectInWidth = 0;
        numberOfRectInHeight = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                if ((j == 0 && i == 0) || (j == 2 && i == 0) || (j == 4 && i == 0)
                        || (j == 6 && i == 1) || (j == 8 && i == 1) || (j == 9 && i == 1)
                        || (j == 1 && i == 2) || (j == 3 && i == 2) || (j == 5 && i == 2)
                        || (j == 7 && i == 3) || (j == 9 && i == 3)
                        || (j == 1 && i == 4) || (j == 3 && i == 4) || (j == 5 && i == 4)
                        || (j == 7 && i == 5) || (j == 9 && i == 5)) {
                    g.fillRect(100 + numberOfRectInWidth, 450 + numberOfRectInHeight, 50, 50);
                } else {
                    g.drawRect(100 + numberOfRectInWidth, 450 + numberOfRectInHeight, 50, 50);
                }
                numberOfRectInWidth += 50;
            }
            numberOfRectInHeight += 50;
            numberOfRectInWidth = 0;
        }
        g.drawRect(150, 100, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event == backButton) {
            MainView.selectOrderFrame.dispose();
            MainCrossword.window.setVisible(true);
        } else if (event == showButton) {
            repaint();
        }else if(event == applyChangeButton){
            int selectedWordByUser = Integer.parseInt(wordChooserSecond.getSelectedItem().toString());
            int selectedPositionByUser = wordChooserThird.getSelectedIndex();
            int positionOfWordInAccualOrder = 0;
            for(int i=0;i<MainCrossword.mainOrderOfSearchingWords.size();i++){
                if(MainCrossword.mainOrderOfSearchingWords.get(i)==selectedWordByUser){
                    positionOfWordInAccualOrder = i;
                    break;
                }
            }
            Collections.swap(MainCrossword.mainOrderOfSearchingWords,selectedPositionByUser,positionOfWordInAccualOrder);
            currentOrderNumberOrder.setText("");
            printOnScreanOrderOfWords();
        }
    }
}
