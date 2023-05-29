package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NavigationBar extends JPanel implements ActionListener {

    public static ArrayList<String> choseWords = new ArrayList<>();
    private JMenuBar menuBar;
    private JMenu menuFile, menuOptions;

    private JMenuItem mLoad;
    private JMenuItem mSave;
    private JMenuItem mExit;
    private JMenuItem mSetting;
    private JMenuItem mInformation;
    public NavigationBar() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuOptions = new JMenu("Options");

        mLoad = new JMenuItem("Load");
        mSave = new JMenuItem("Save");
        mExit = new JMenuItem("Exit");

        mLoad.addActionListener(this);
        mSave.addActionListener(this);
        mExit.addActionListener(this);

        menuFile.add(mLoad);
        menuFile.add(mSave);
        menuFile.addSeparator();
        menuFile.add(mExit);

        mSetting = new JMenuItem("Setting");
        mInformation = new JMenuItem("Information");

        mSetting.addActionListener(this);
        mInformation.addActionListener(this);

        menuOptions.add(mSetting);
        menuOptions.add(mInformation);

        add(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuOptions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event == mExit){
            System.exit(1);
        }else if(event == mSave){

        }else if(event == mLoad){
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while (line != null){
                    choseWords.add(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                MainView.sendLoadValue(choseWords);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else if(event == mSetting){

        }else if(event == mInformation){

        }
    }
}
