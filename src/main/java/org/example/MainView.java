package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainView extends JPanel implements ActionListener {
    public final JButton bFirstBlock, bSecondBlock, bThirdBlock, bFourthBlock, bFifthBlock, bSixthBlock;
    static Dimension screenSize;
    public static JFrame selectOrderFrame, setValueOfWordFrame;
    public static ArrayList<String> choseWords = new ArrayList<>();
    private JTextArea chosenWordsTextArea;
    private JLabel chosenWordsLabel;
    private JButton refreshButton, selectOrderButton, startFillingCrosswordButton, setValueOfWordButton, clearButton;
    public static ArrayList<WordVariable> allWordsList = getWordVariables();
    public static ArrayList<String> pickedWords = new ArrayList<>();
    public static JTextField tfPath;
    public static JCheckBox jcNumbersOfWords;

    public MainView() {

        fillEmptySpacesForChosenWords();

        Toolkit toolkit = getToolkit();
        screenSize = toolkit.getScreenSize();

        this.setPreferredSize(new Dimension(1500,1000));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        bFirstBlock = new JButton("BLOCK 1 (0-7)");
        bFirstBlock.setBounds(200, 10, 130, 30);
        add(bFirstBlock);
        bFirstBlock.addActionListener(this);

        bSecondBlock = new JButton("BLOCK 2 (10-20)");
        bSecondBlock.setBounds(350, 10, 130, 30);
        add(bSecondBlock);
        bSecondBlock.addActionListener(this);

        bThirdBlock = new JButton("BLOCK 3 (0-17)");
        bThirdBlock.setBounds(500, 10, 130, 30);
        add(bThirdBlock);
        bThirdBlock.addActionListener(this);

        bFourthBlock = new JButton("BLOCK 4 (0-20)");
        bFourthBlock.setBounds(650, 10, 130, 30);
        add(bFourthBlock);
        bFourthBlock.addActionListener(this);

        bFifthBlock = new JButton("BLOCK 5 (21, 27)");
        bFifthBlock.setBounds(800, 10, 130, 30);
        add(bFifthBlock);
        bFifthBlock.addActionListener(this);

        bSixthBlock = new JButton("BLOCK 6 (27, 37)");
        bSixthBlock.setBounds(950, 10, 130, 30);
        add(bSixthBlock);
        bSixthBlock.addActionListener(this);

        jcNumbersOfWords = new JCheckBox();
        jcNumbersOfWords.setBounds(1005, 670, 50, 50);
        add(jcNumbersOfWords);
        jcNumbersOfWords.addActionListener(this);

//        tfPath = new JTextField("C:\\Users\\PC\\Documents\\wordsFULL.txt");
        tfPath = new JTextField("C:\\Users\\alark\\Documents\\wyrazy.txt");
        tfPath.setBounds(1200, 10, 500, 30);
        tfPath.setEnabled(false);
        add(tfPath);

        refreshButton = new JButton("Refresh / Odswiez");
        refreshButton.setBounds(675, 475, 400, 50);
        refreshButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            repaint();
                        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(refreshButton);
        refreshButton.addActionListener(this);

        selectOrderButton = new JButton("Choice the word order / Wybierz kolejnosc wybierania slow");
        selectOrderButton.setBounds(675, 540, 400, 50);
        selectOrderButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            openChoosingWordOrderPanel();
                        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(selectOrderButton);
        selectOrderButton.addActionListener(this);

        startFillingCrosswordButton = new JButton("Star filling crossword / Rozpocznij uzupelnianie krzyzowki");
        startFillingCrosswordButton.setBounds(675, 605, 400, 50);
        startFillingCrosswordButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(startFillingCrosswordButton);
        startFillingCrosswordButton.addActionListener(this);

        setValueOfWordButton = new JButton("Set value of specific word / Ustaw konkretne slowa");
        setValueOfWordButton.setBounds(675, 670, 300, 50);
        setValueOfWordButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            setValueOfWordFrameOpen();
                        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(setValueOfWordButton);
        setValueOfWordButton.addActionListener(this);

        clearButton = new JButton("Clear crossword / Wyczysc krzyzowke");
        clearButton.setBounds(675, 730, 400, 50);
        clearButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            setValueOfWordFrameOpen();
                        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            doExit();
                        }
                    }
                });
        add(clearButton);
        clearButton.addActionListener(this);

        chosenWordsTextArea = new JTextArea();
        chosenWordsTextArea.setBounds(1125, 150, 305, 635);
        chosenWordsTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        chosenWordsTextArea.setFocusable(false);
        add(chosenWordsTextArea);

        chosenWordsLabel = new JLabel("Chosen Words / Wybrane slowa");
        chosenWordsLabel.setBounds(1155, 100, 300, 30);
        chosenWordsLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(chosenWordsLabel);

        MainCrossword.window.getRootPane().setDefaultButton(refreshButton);
    }

    private static void fillEmptySpacesForChosenWords() {
        choseWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] LengthOfWordsArray = {7, 5, 5, 7, 5, 6, 4, 5, 5, 4, 13, 7, 7, 5, 7, 5, 5, 7, 3, 3, 7, 5, 6, 5, 5, 6, 6, 6, 5, 7, 5, 7, 5, 4, 5, 4, 5};
        for (int i = 0; i < 37; i++) {
            for (int j = 0; j < LengthOfWordsArray[i]; j++) {
                sb.append(" ");
            }
            choseWords.add(sb.toString());
            sb = new StringBuilder();
        }
    }

    public static void sendLoadValue(ArrayList<String> choseWords) {
        MainView.choseWords = choseWords;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(225, 225, 225));
        g.fillRect(50, 50, screenSize.width - 200, screenSize.height - 200);

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

        creatingTextAreaBorder(g);
        inputLettersIntoCrossword(g);
    }

    private static void inputLettersIntoCrossword(Graphics g) {
        int[] firstValueInWordsOfXCoordinate = {125, 125, 225, 125, 125, 325, 425, 425, 425, 525, 625, 625, 625, 725, 625, 825, 925, 625, 775, 875, 475, 175, 125, 275, 375, 375, 375, 125, 125, 125, 225, 125, 325, 425, 425, 525, 425};
        int[] firstValueInWordsOfYCoordinate = {125, 125, 125, 225, 325, 125, 125, 175, 275, 125, 125, 125, 225, 125, 325, 125, 125, 425, 325, 325, 275, 325, 425, 325, 325, 375, 475, 525, 525, 625, 525, 725, 525, 575, 575, 575, 675};

        int verticalValue = 0;
        int horizontallyValue = 0;
        boolean[] wordIsInVertical = {false, true, true, false, false, true, true, false, false, true, true, false, false, true, false,
                true, true, false, true, true, true, true, false, true, true, false, false, false, true, false, true, false, true, true, false, true, false};
        for (int i = 0; i < choseWords.size(); i++) {
            verticalValue = 0;
            horizontallyValue = 0;
            if (choseWords.get(i) != null) {
                for (int j = 0; j < choseWords.get(i).length(); j++) {
                    if (wordIsInVertical[i]) {
                        g.drawString("" + choseWords.get(i).charAt(j), firstValueInWordsOfXCoordinate[i], firstValueInWordsOfYCoordinate[i] + verticalValue);
                        verticalValue += 50;
                    } else {
                        g.drawString("" + choseWords.get(i).charAt(j), firstValueInWordsOfXCoordinate[i] + horizontallyValue, firstValueInWordsOfYCoordinate[i]);
                        horizontallyValue += 50;
                    }
                }
            }
        }
        if(jcNumbersOfWords.isSelected()) {
            setNumbersOfWordInGivenPlacesOnCrossword(g);
        }
    }

    private static void setNumbersOfWordInGivenPlacesOnCrossword(Graphics g) {
        g.drawString("1-", 105,115);
        g.drawString("37-", 405,665);
        g.drawString("36", 505,565);
        g.drawString("|", 507,576);
        g.drawString("35-", 405,565);
        g.drawString("34", 405,580);
        g.drawString("|", 407,591);
        g.drawString("33", 305,515);
        g.drawString("|", 307,526);
        g.drawString("32-", 105,715);
        g.drawString("31", 205,515);
        g.drawString("|", 207,526);
        g.drawString("30-", 105,615);
        g.drawString("29", 105,530);
        g.drawString("|", 107,541);
        g.drawString("28-", 105,515);
        g.drawString("27-", 355,465);
        g.drawString("26-", 355,365);
        g.drawString("25", 355,315);
        g.drawString("|", 360,326);
        g.drawString("24", 255,315);
        g.drawString("|", 260,326);
        g.drawString("23-", 105,415);
        g.drawString("22", 155,315);
        g.drawString("|", 160,326);
        g.drawString("21", 455,265);
        g.drawString("|", 460,276);
        g.drawString("18-", 605,415);
        g.drawString("17", 905,115);
        g.drawString("|", 910,126);
        g.drawString("16", 805,115);
        g.drawString("|", 810,126);
        g.drawString("15-", 605,315);
        g.drawString("19", 755,315);
        g.drawString("|", 760,326);
        g.drawString("20", 855,315);
        g.drawString("|", 860,326);
        g.drawString("13-", 605,215);
        g.drawString("12-", 605,115);
        g.drawString("14", 705,115);
        g.drawString("|", 710,126);
        g.drawString("11", 605,130);
        g.drawString("|", 610,141);
        g.drawString("10", 505,115);
        g.drawString("|", 510,126);
        g.drawString("3", 205,115);
        g.drawString("|", 207,126);
        g.drawString("6", 305,115);
        g.drawString("|", 307,126);
        g.drawString("7", 405,115);
        g.drawString("|", 407,126);
        g.drawString("8-", 405,165);
        g.drawString("9-", 405,265);
        g.drawString("2", 105,130);
        g.drawString("|", 107,141);
        g.drawString("4-", 105,215);
        g.drawString("5-", 105,315);
    }

    private void creatingTextAreaBorder(Graphics g) {
        g.drawLine(1105, 130, 1450, 130);
        g.drawLine(1115, 140, 1440, 140);

        g.drawLine(1105, 130, 1105, 805);
        g.drawLine(1115, 140, 1115, 795);

        g.drawLine(1450, 130, 1450, 805);
        g.drawLine(1440, 140, 1440, 795);

        g.drawLine(1105, 805, 1450, 805);
        g.drawLine(1115, 795, 1440, 795);

    }

    public void inputChosenWordsIntoTextAreaFields() {
        chosenWordsTextArea.setText("");
        int countOfSpaces;
        for (int i = 0; i < choseWords.size(); i++) {
            if (choseWords.get(i) != null) {
                countOfSpaces = 66 - choseWords.get(i).length();
                chosenWordsTextArea.setText(chosenWordsTextArea.getText() + (i + 1) + ":");
                for (int j = 0; j < countOfSpaces / 2; j++)
                    chosenWordsTextArea.setText(chosenWordsTextArea.getText() + " ");
                chosenWordsTextArea.setText(chosenWordsTextArea.getText() + choseWords.get(i));
                for (int j = 0; j < countOfSpaces / 2 - 3; j++)
                    chosenWordsTextArea.setText(chosenWordsTextArea.getText() + " ");
                chosenWordsTextArea.setText(chosenWordsTextArea.getText() + "\n");
            }

        }
    }

    private static ArrayList<WordVariable> getWordVariables() {
        WordVariable word;
        ArrayList<WordVariable> allWordsList = new ArrayList<>();
        int[] wordLength = {7, 5, 5, 7, 6, 5, 4, 5, 5, 4, 13, 7, 7, 5, 7, 5, 5, 7, 3, 3, 7, 5, 6, 5, 6, 6, 6, 6, 5, 7, 5, 7, 5, 4, 5, 4, 5};
        int[] firstPositionOfXAxis = {100, 100, 200, 100, 100, 300, 400, 400, 400, 500, 600, 600, 600, 700, 600, 800, 900, 600, 750, 850, 450,
                150, 100, 250, 350, 350, 350, 100, 100, 100, 200, 100, 300, 400, 400, 500, 400};
        int[] firstPositionOfYAxis = {100, 100, 100, 200, 300, 100, 100, 150, 250, 100, 100, 100, 200, 100, 300, 100, 100, 400, 300, 300, 250,
                300, 400, 300, 300, 350, 450, 500, 500, 600, 500, 700, 500, 550, 550, 550, 650};
        boolean[] VerticalOrHorizontal = {false, true, true, false, false, true, true, false, false, true, true, false, false, true, false,
                true, true, false, true, true, true, true, false, true, true, false, false, false, true, false, true, false, true, true,
                false, true, false};
        for (int i = 0; i < 37; i++) {
            word = new WordVariable(i + 1, wordLength[i], VerticalOrHorizontal[i], firstPositionOfXAxis[i], firstPositionOfYAxis[i]);
            allWordsList.add(word);
        }
        return allWordsList;
    }

    public void refreshView() {
        inputChosenWordsIntoTextAreaFields();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event == refreshButton) {
            refreshView();
        } else if (event == selectOrderButton) {
            openChoosingWordOrderPanel();
        } else if (event == startFillingCrosswordButton) {
            startFindingTheWords(0, 37);
        } else if (event == setValueOfWordButton) {
            setValueOfWordFrameOpen();
        } else if (event == clearButton) {
            choseWords.clear();
            refreshView();
        } else if (event == bFirstBlock) {
            startFindingTheWords(0, 7);
        } else if (event == bSecondBlock) {
            startFindingTheWords(10, 20);
        } else if (event == bThirdBlock) {
            startFindingTheWords(0, 17);
        } else if (event == bFourthBlock) {
            startFindingTheWords(0, 20);
        } else if (event == bFifthBlock) {
            startFindingTheWords(21, 27);
        } else if (event == bSixthBlock) {
            startFindingTheWords(27, 37);
        }else if(event == jcNumbersOfWords){
            repaint();
        }
    }

    private void startFindingTheWords(int startNumber, int endNumber) {
        FindingWords findingWords = new FindingWords(allWordsList);
        findingWords.run(startNumber, endNumber);
        choseWords = pickedWords;
        refreshView();
    }

    private void setValueOfWordFrameOpen() {
        setValueOfWordFrame = new JFrame();
        setValueOfWordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setValueOfWordFrame.setResizable(false);
        setValueOfWordFrame.setTitle("Set word value");
//        setValueOfWordFrame.setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        SetValueOfSpecificWord setValueOfWordPanel = new SetValueOfSpecificWord();
        setValueOfWordPanel.setLayout(null);

        setValueOfWordFrame.add(setValueOfWordPanel, BorderLayout.CENTER);

        setValueOfWordFrame.setLocation(dim.width / 2 - (this.getSize().width / 2 / 2), dim.height / 2 - (this.getSize().height / 2 / 2));
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
        selectOrderFrame.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        ChoosingWordOrderPanel choosingWordOrderPanel = new ChoosingWordOrderPanel();
        choosingWordOrderPanel.setLayout(null);

        selectOrderFrame.add(choosingWordOrderPanel, BorderLayout.CENTER);

        selectOrderFrame.pack();
        selectOrderFrame.setVisible(true);
    }

    private void doExit() {
        int answer = JOptionPane.showConfirmDialog(MainCrossword.window, "Are You sure You want to exit? \n Czy napewno chcesz zakonczyc program?", "Exit", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION)
            System.exit(1);
    }
}
