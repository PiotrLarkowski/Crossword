package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SetValueOfSpecificWord extends JPanel implements ActionListener {

    JButton returnButton, setEnableTextFieldButton, applyWordButton;
    JComboBox wordChooser;
    JTextField Letter1TextField, Letter2TextField, Letter3TextField, Letter4TextField, Letter5TextField,
            Letter6TextField, Letter7TextField, Letter8TextField, Letter9TextField, Letter10TextField,
            Letter11TextField, Letter12TextField, Letter13TextField, ExtraTextField;

    JLabel topLabel, middleLabel;

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

        Letter1TextField = new JTextField();
        Letter1TextField.setBounds(180, 150, 30, 60);
        add(Letter1TextField);

        Letter2TextField = new JTextField();
        Letter2TextField.setBounds(220, 150, 30, 60);
        add(Letter2TextField);

        Letter3TextField = new JTextField();
        Letter3TextField.setBounds(260, 150, 30, 60);
        add(Letter3TextField);

        Letter4TextField = new JTextField();
        Letter4TextField.setBounds(300, 150, 30, 60);
        add(Letter4TextField);

        Letter5TextField = new JTextField();
        Letter5TextField.setBounds(340, 150, 30, 60);
        add(Letter5TextField);

        Letter6TextField = new JTextField();
        Letter6TextField.setBounds(380, 150, 30, 60);
        add(Letter6TextField);

        Letter7TextField = new JTextField();
        Letter7TextField.setBounds(420, 150, 30, 60);
        add(Letter7TextField);

        Letter8TextField = new JTextField();
        Letter8TextField.setBounds(460, 150, 30, 60);
        add(Letter8TextField);

        Letter9TextField = new JTextField();
        Letter9TextField.setBounds(500, 150, 30, 60);
        add(Letter9TextField);

        Letter10TextField = new JTextField();
        Letter10TextField.setBounds(540, 150, 30, 60);
        add(Letter10TextField);

        Letter11TextField = new JTextField();
        Letter11TextField.setBounds(580, 150, 30, 60);
        add(Letter11TextField);

        Letter12TextField = new JTextField();
        Letter12TextField.setBounds(620, 150, 30, 60);
        add(Letter12TextField);

        Letter13TextField = new JTextField();
        Letter13TextField.setBounds(660, 150, 30, 60);
        add(Letter13TextField);

        setAllTextFieldDisabled();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(50, 50, 700, 400);
    }
    private void setThreeTextFieldActive() {
        Letter1TextField.setEnabled(true);
        Letter2TextField.setEnabled(true);
        Letter3TextField.setEnabled(true);
    }
    private void setFourTextFieldActive() {
        setThreeTextFieldActive();
        Letter4TextField.setEnabled(true);
    }
    private void setFiveTextFieldActive() {
        setFourTextFieldActive();
        Letter5TextField.setEnabled(true);
    }
    private void setSixTextFieldActive() {
        setFiveTextFieldActive();
        Letter6TextField.setEnabled(true);
    }
    private void setSevenTextFieldActive() {
        setSixTextFieldActive();
        Letter7TextField.setEnabled(true);
    }
    private void setThirteenTextFieldActive() {
        setSevenTextFieldActive();
        Letter8TextField.setEnabled(true);
        Letter9TextField.setEnabled(true);
        Letter10TextField.setEnabled(true);
        Letter11TextField.setEnabled(true);
        Letter12TextField.setEnabled(true);
        Letter13TextField.setEnabled(true);
    }

    private void setAllTextFieldDisabled() {
        Letter1TextField.setEnabled(false);
        Letter2TextField.setEnabled(false);
        Letter3TextField.setEnabled(false);
        Letter4TextField.setEnabled(false);
        Letter5TextField.setEnabled(false);
        Letter6TextField.setEnabled(false);
        Letter7TextField.setEnabled(false);
        Letter8TextField.setEnabled(false);
        Letter9TextField.setEnabled(false);
        Letter10TextField.setEnabled(false);
        Letter11TextField.setEnabled(false);
        Letter12TextField.setEnabled(false);
        Letter13TextField.setEnabled(false);
    }
    private void setEnableTextFields() {
        setAllTextFieldDisabled();
        if (wordChooser.getSelectedItem().equals(1) || wordChooser.getSelectedItem().equals(4) ||
                wordChooser.getSelectedItem().equals(12) || wordChooser.getSelectedItem().equals(13) ||
                wordChooser.getSelectedItem().equals(15) || wordChooser.getSelectedItem().equals(18) ||
                wordChooser.getSelectedItem().equals(21) || wordChooser.getSelectedItem().equals(30) ||
                wordChooser.getSelectedItem().equals(32)) {
            setSevenTextFieldActive();
        } else if (wordChooser.getSelectedItem().equals(2) || wordChooser.getSelectedItem().equals(3) ||
                wordChooser.getSelectedItem().equals(6) || wordChooser.getSelectedItem().equals(8) ||
                wordChooser.getSelectedItem().equals(9) || wordChooser.getSelectedItem().equals(14) ||
                wordChooser.getSelectedItem().equals(16) || wordChooser.getSelectedItem().equals(17) ||
                wordChooser.getSelectedItem().equals(22) || wordChooser.getSelectedItem().equals(24) ||
                wordChooser.getSelectedItem().equals(25) || wordChooser.getSelectedItem().equals(29) ||
                wordChooser.getSelectedItem().equals(31) || wordChooser.getSelectedItem().equals(33) ||
                wordChooser.getSelectedItem().equals(35) || wordChooser.getSelectedItem().equals(37)){
            setFiveTextFieldActive();
        } else if (wordChooser.getSelectedItem().equals(5) || wordChooser.getSelectedItem().equals(23) ||
                wordChooser.getSelectedItem().equals(26) || wordChooser.getSelectedItem().equals(27) ||
                wordChooser.getSelectedItem().equals(28)) {
            setSixTextFieldActive();
        } else if (wordChooser.getSelectedItem().equals(7) || wordChooser.getSelectedItem().equals(10) ||
                wordChooser.getSelectedItem().equals(34) || wordChooser.getSelectedItem().equals(36)) {
            setFourTextFieldActive();
        } else if (wordChooser.getSelectedItem().equals(19) || wordChooser.getSelectedItem().equals(20)) {
            setThreeTextFieldActive();
        } else if (wordChooser.getSelectedItem().equals(11)) {
            setThirteenTextFieldActive();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event == returnButton) {
            MainView.setValueOfWordFrame.dispose();
        }else if(event == setEnableTextFieldButton){
            setEnableTextFields();
        }else if(event == applyWordButton){

        }

    }
}
