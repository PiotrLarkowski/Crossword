package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainView extends JPanel implements ActionListener {
    static Dimension screenSize;
    public static JFrame selectOrderFrame, setValueOfWordFrame;

    public static ArrayList<String> choseWords = new ArrayList<>();
    private JTextArea chosenWordsTextArea;
    private JLabel chosenWordsLabel;
    private JButton refreshButton, selectOrderButton, startFillingCrosswordButton, setValueOfWordButton;
    public MainView() {

        fillEmptySpacesForChosenWords();

        Toolkit toolkit = getToolkit();
        screenSize = toolkit.getScreenSize();

        this.setPreferredSize(new Dimension(screenSize.width,screenSize.height));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        refreshButton = new JButton("Refresh / Odswiez");
        refreshButton.setBounds(675,475,400,50);
        refreshButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            repaint();
                        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(refreshButton);
        refreshButton.addActionListener(this);

        selectOrderButton = new JButton("Choice the word order / Wybierz kolejnosc wybierania slow");
        selectOrderButton.setBounds(675,540,400,50);
        selectOrderButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            openChoosingWordOrderPanel();
                        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(selectOrderButton);
        selectOrderButton.addActionListener(this);

        startFillingCrosswordButton = new JButton("Star filling crossword / Rozpocznij uzupelnianie krzyzowki");
        startFillingCrosswordButton.setBounds(675,605,400,50);
        startFillingCrosswordButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(startFillingCrosswordButton);
        startFillingCrosswordButton.addActionListener(this);

        setValueOfWordButton = new JButton("Set value of specific word / Ustaw konkretne slowa");
        setValueOfWordButton.setBounds(675,670,400,50);
        setValueOfWordButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            setValueOfWordFrameOpen();
                        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(setValueOfWordButton);
        setValueOfWordButton.addActionListener(this);

        chosenWordsTextArea = new JTextArea();
        chosenWordsTextArea.setBounds(1125,150,305,635);
        chosenWordsTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        chosenWordsTextArea.setFocusable(false);
        add(chosenWordsTextArea);

        chosenWordsLabel = new JLabel("Chosen Words");
        chosenWordsLabel.setBounds(1225,100,200,30);
        chosenWordsLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(chosenWordsLabel);

        MainCrossword.window.getRootPane().setDefaultButton(refreshButton);
    }

    private static void fillEmptySpacesForChosenWords() {
        choseWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] LengthOfWordsArray = {7,5,5,7,5,6,4,5,5,4,13,7,7,5,7,5,5,7,3,3,7,5,6,5,5,6,6,6,5,7,5,7,5,4,5,4,5};
        for (int i =0; i<37;i++){
            for(int j=0; j<LengthOfWordsArray[i];j++){
                sb.append(" ");
            }
            choseWords.add(sb.toString());
            sb = new StringBuilder();
        }
    }

    public static void sendLoadValue(ArrayList<String> choseWords) {
        MainView.choseWords = choseWords;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(225,225,225));
        g.fillRect(50,50,screenSize.width-200, screenSize.height-200);

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

        creatingTextAreaBorder(g);
        inputLettersIntoCrossword(g);
    }

    private static void inputLettersIntoCrossword(Graphics g) {
       int[] firstValueInWordsOfXCoordinate = {125,125,225,125,325,125,425,425,425,525,625,625,625,725,625,825,925,625,775,875,475,175,125,275,375,375,375,125,125,125,225,125,325,425,425,525,425};
       int[] firstValueInWordsOfYCoordinate = {125,125,125,225,125,325,125,175,275,125,125,125,225,125,325,125,125,425,325,325,275,325,425,325,325,375,475,525,525,625,525,725,525,575,575,575,675};

        int verticalValue = 0;
        int horizontallyValue = 0;
        boolean[] wordIsInVertical = {false,true,true,false,true,false,true,false,false,true,true,false,false,true,false,
        true,true,false,true,true,true,true,false,true,true,false,false,false,true,false,true,false,true,true,false,true,false};
        for(int i=0; i<choseWords.size();i++){
            verticalValue = 0;
            horizontallyValue = 0;
            for(int j=0; j<choseWords.get(i).length();j++){
                if(wordIsInVertical[i]) {
                    g.drawString("" + choseWords.get(i).charAt(j), firstValueInWordsOfXCoordinate[i], firstValueInWordsOfYCoordinate[i]+verticalValue);
                    verticalValue+=50;
                }else{
                    g.drawString("" + choseWords.get(i).charAt(j), firstValueInWordsOfXCoordinate[i]+horizontallyValue, firstValueInWordsOfYCoordinate[i]);
                    horizontallyValue+=50;
                }
            }
        }

    }

    private void creatingTextAreaBorder(Graphics g) {
        g.drawLine(1105,130,1450,130);
        g.drawLine(1115,140,1440,140);

        g.drawLine(1105,130,1105,805);
        g.drawLine(1115,140,1115,795);

        g.drawLine(1450,130,1450,805);
        g.drawLine(1440,140,1440,795);

        g.drawLine(1105,805,1450,805);
        g.drawLine(1115,795,1440,795);

    }

    public void inputChosenWordsIntoTextAreaFields(){
        chosenWordsTextArea.setText("");
        int countOfSpaces;
        for(int i=0;i<choseWords.size();i++){
            countOfSpaces = 66 - choseWords.get(i).length();
            chosenWordsTextArea.setText(chosenWordsTextArea.getText() + i + ":");
            for(int j = 0; j< countOfSpaces/2;j++)
                chosenWordsTextArea.setText(chosenWordsTextArea.getText() + "-");
            chosenWordsTextArea.setText(chosenWordsTextArea.getText() + choseWords.get(i));
            for(int j = 0; j< countOfSpaces/2-3;j++)
                chosenWordsTextArea.setText(chosenWordsTextArea.getText() + "-");
            chosenWordsTextArea.setText(chosenWordsTextArea.getText() + "\n");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event == refreshButton){
            inputChosenWordsIntoTextAreaFields();
            repaint();
        }else if(event == selectOrderButton){
            openChoosingWordOrderPanel();
        }else if(event == startFillingCrosswordButton){

        }else if(event == setValueOfWordButton){
            setValueOfWordFrameOpen();
        }
    }

    private void setValueOfWordFrameOpen() {
        setValueOfWordFrame = new JFrame();
        setValueOfWordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setValueOfWordFrame.setResizable(false);
        setValueOfWordFrame.setTitle("Set word value");
        setValueOfWordFrame.setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        SetValueOfSpecificWord setValueOfWordPanel = new SetValueOfSpecificWord();
        setValueOfWordPanel.setLayout(null);

        setValueOfWordFrame.add(setValueOfWordPanel, BorderLayout.CENTER);

        setValueOfWordFrame.setLocation(dim.width/2-(this.getSize().width/2/2), dim.height/2-(this.getSize().height/2/2));
        setValueOfWordFrame.pack();
        setValueOfWordFrame.setVisible(true);
    }

    private void openChoosingWordOrderPanel() {
        MainCrossword.window.setVisible(false);
        selectOrderFrame = new JFrame();
        selectOrderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectOrderFrame.setResizable(false);
        selectOrderFrame.setTitle("Choosing words order");
        selectOrderFrame.setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        selectOrderFrame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        ChoosingWordOrderPanel choosingWordOrderPanel = new ChoosingWordOrderPanel();
        choosingWordOrderPanel.setLayout(null);

        selectOrderFrame.add(choosingWordOrderPanel, BorderLayout.CENTER);

        selectOrderFrame.pack();
        selectOrderFrame.setVisible(true);
    }
    private void doExit() {
        int answer = JOptionPane.showConfirmDialog(MainCrossword.window,"Are You sure You want to exit? \n Czy napewno chcesz zakonczyc program?","Exit",JOptionPane.YES_NO_OPTION);
        if(answer == JOptionPane.YES_OPTION)
            System.exit(1);
    }
}
