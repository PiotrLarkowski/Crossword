package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class SetValueOfSpecificWord extends JPanel implements ActionListener {

    JButton returnButton, setEnableTextFieldButton, applyWordButton;
    JComboBox wordChooser;
    JTextField tfLongInputForWord;
    JTextField Letter1TextField = new JTextField(),
            Letter2TextField = new JTextField(),
            Letter3TextField = new JTextField(),
            Letter4TextField = new JTextField(),
            Letter5TextField = new JTextField(),
            Letter6TextField = new JTextField(),
            Letter7TextField = new JTextField(),
            Letter8TextField = new JTextField(),
            Letter9TextField = new JTextField(),
            Letter10TextField = new JTextField(),
            Letter11TextField = new JTextField(),
            Letter12TextField = new JTextField(),
            Letter13TextField = new JTextField(),
            ExtraTextField;


    JLabel topLabel, middleLabel;
    ArrayList<JTextField> textFieldList = new ArrayList<>(Arrays.asList(Letter1TextField, Letter2TextField,
            Letter3TextField, Letter4TextField, Letter5TextField, Letter6TextField, Letter7TextField,
            Letter8TextField, Letter9TextField, Letter10TextField, Letter11TextField, Letter12TextField, Letter13TextField));

    public SetValueOfSpecificWord() {

        this.setPreferredSize(new Dimension(800, 500));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        returnButton = new JButton("Return / Powrot");
        returnButton.setBounds(500, 400, 200, 30);
        returnButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            MainView.setValueOfWordFrame.dispose();
                        }
                    }
                });
        add(returnButton);
        returnButton.addActionListener(this);

        applyWordButton = new JButton("Apply / Zatwierdz");
        applyWordButton.setBounds(350, 290, 200, 30);
        applyWordButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        }
                    }
                });
        add(applyWordButton);
        applyWordButton.addActionListener(this);

        setEnableTextFieldButton = new JButton("Refresh / Odswierz");
        setEnableTextFieldButton.setBounds(350, 330, 200, 30);
        setEnableTextFieldButton.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            setEnableTextFields();
                        }
                    }
                });
        add(setEnableTextFieldButton);
        setEnableTextFieldButton.addActionListener(this);

        tfLongInputForWord = new JTextField();
        tfLongInputForWord.setBounds(350, 250, 300, 30);
        add(tfLongInputForWord);

        topLabel = new JLabel("Set the Value of Specific character / Wybierz wartosci pojedynczych liter");
        topLabel.setBounds(200, 100, 500, 50);
        add(topLabel);

        middleLabel = new JLabel("Select the word to define its value / Wybierz numer slowa ktore chcesz wybrac");
        middleLabel.setBounds(200, 200, 500, 50);
        add(middleLabel);

        wordChooser = new JComboBox();
        wordChooser.setBounds(250, 300, 50, 60);
        for (int i = 0; i < 37; i++) {
            wordChooser.addItem(i + 1);
        }
        wordChooser.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            setEnableTextFields();
                        } else if (e.getKeyCode() == KeyEvent.VK_1) {
                            wordChooser.setSelectedIndex(0);
                        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            MainView.setValueOfWordFrame.dispose();
                        }
                    }
                });
        add(wordChooser);

        Letter1TextField.setBounds(180, 150, 30, 60);
        add(Letter1TextField);

        Letter2TextField.setBounds(220, 150, 30, 60);
        add(Letter2TextField);

        Letter3TextField.setBounds(260, 150, 30, 60);
        add(Letter3TextField);

        Letter4TextField.setBounds(300, 150, 30, 60);
        add(Letter4TextField);

        Letter5TextField.setBounds(340, 150, 30, 60);
        add(Letter5TextField);

        Letter6TextField.setBounds(380, 150, 30, 60);
        add(Letter6TextField);

        Letter7TextField.setBounds(420, 150, 30, 60);
        add(Letter7TextField);

        Letter8TextField.setBounds(460, 150, 30, 60);
        add(Letter8TextField);

        Letter9TextField.setBounds(500, 150, 30, 60);
        add(Letter9TextField);

        Letter10TextField.setBounds(540, 150, 30, 60);
        add(Letter10TextField);

        Letter11TextField.setBounds(580, 150, 30, 60);
        add(Letter11TextField);

        Letter12TextField.setBounds(620, 150, 30, 60);
        add(Letter12TextField);

        Letter13TextField.setBounds(660, 150, 30, 60);
        add(Letter13TextField);

        setAllTextFieldDisabled();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(50, 50, 700, 400);
    }
    private void setTextFieldActive(int numberOfTextFieldToActive) {
        for (int i = 0; i < numberOfTextFieldToActive; i++) {
            textFieldList.get(i).setEnabled(true);
        }
    }

    private void setAllTextFieldDisabled() {
        for (JTextField jTextField : textFieldList) {
            jTextField.setEnabled(false);
        }
    }
    private void setEnableTextFields() {
        setAllTextFieldDisabled();
        int[][] numbersOfWordsWithSameLetters = {{1,4,12,13,15,21,30,32},{2,3,6,8,9,14,16,17,22,24,25,29,31,33,35,37},
                {5,23,26,27,28},{7,10,34,36},{19,20}};
        int[] numbersOfWordsWithSevenLetters = {1,4,12,13,15,21,30,32};
        int[] numbersOfWordsWithFiveLetters = {2,3,6,8,9,14,16,17,22,24,25,29,31,33,35,37};
        int[] numbersOfWordsWithSixLetters = {5,23,26,27,28};
        int[] numbersOfWordsWithFourLetters = {7,10,34,36};
        int[] numbersOfWordsWithTreeLetters = {19,20};
        for (int numbersOfWordsWithSevenLetter : numbersOfWordsWithSevenLetters) {
            if (wordChooser.getSelectedItem().equals(numbersOfWordsWithSevenLetter)) {
                setTextFieldActive(7);
            }
        }
        for (int i = 0; i < numbersOfWordsWithFiveLetters.length; i++) {
            if(wordChooser.getSelectedItem().equals(numbersOfWordsWithFiveLetters[i])){
                setTextFieldActive(5);
                break;
            }
        }
        if (wordChooser.getSelectedItem().equals(1) || wordChooser.getSelectedItem().equals(4) ||
                wordChooser.getSelectedItem().equals(12) || wordChooser.getSelectedItem().equals(13) ||
                wordChooser.getSelectedItem().equals(15) || wordChooser.getSelectedItem().equals(18) ||
                wordChooser.getSelectedItem().equals(21) || wordChooser.getSelectedItem().equals(30) ||
                wordChooser.getSelectedItem().equals(32)) {
            setTextFieldActive(7);
        } else if (wordChooser.getSelectedItem().equals(2) || wordChooser.getSelectedItem().equals(3) ||
                wordChooser.getSelectedItem().equals(6) || wordChooser.getSelectedItem().equals(8) ||
                wordChooser.getSelectedItem().equals(9) || wordChooser.getSelectedItem().equals(14) ||
                wordChooser.getSelectedItem().equals(16) || wordChooser.getSelectedItem().equals(17) ||
                wordChooser.getSelectedItem().equals(22) || wordChooser.getSelectedItem().equals(24) ||
                wordChooser.getSelectedItem().equals(25) || wordChooser.getSelectedItem().equals(29) ||
                wordChooser.getSelectedItem().equals(31) || wordChooser.getSelectedItem().equals(33) ||
                wordChooser.getSelectedItem().equals(35) || wordChooser.getSelectedItem().equals(37)){
            setTextFieldActive(5);
        } else if (wordChooser.getSelectedItem().equals(5) || wordChooser.getSelectedItem().equals(23) ||
                wordChooser.getSelectedItem().equals(26) || wordChooser.getSelectedItem().equals(27) ||
                wordChooser.getSelectedItem().equals(28)) {
            setTextFieldActive(6);
        } else if (wordChooser.getSelectedItem().equals(7) || wordChooser.getSelectedItem().equals(10) ||
                wordChooser.getSelectedItem().equals(34) || wordChooser.getSelectedItem().equals(36)) {
            setTextFieldActive(4);
        } else if (wordChooser.getSelectedItem().equals(19) || wordChooser.getSelectedItem().equals(20)) {
            setTextFieldActive(3);
        }
        if (wordChooser.getSelectedItem().equals(11)) {
            setTextFieldActive(13);
        }
    }
    private void combineValueOfLettersIntoWord() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < textFieldList.size(); i++) {
            if(textFieldList.get(i).isEnabled()){
                stringBuilder.append(textFieldList.get(i).getText());
            }
        }
        MainView.choseWords.set(wordChooser.getSelectedIndex(), stringBuilder.toString().toUpperCase());
        JOptionPane.showMessageDialog(this, "Value has been set / Wartosc zostala ustawiona");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event == returnButton) {
            MainView.setValueOfWordFrame.dispose();
        }else if(event == setEnableTextFieldButton){
            setEnableTextFields();
        }else if(event == applyWordButton){
            if(!tfLongInputForWord.getText().isEmpty()){
                MainView.choseWords.set(wordChooser.getSelectedIndex(), tfLongInputForWord.getText().toUpperCase());
                JOptionPane.showMessageDialog(this, "Value has been set / Wartosc zostala ustawiona");
            }else {
                combineValueOfLettersIntoWord();
            }
        }
    }
}
