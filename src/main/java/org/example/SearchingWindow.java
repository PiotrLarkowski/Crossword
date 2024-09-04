package org.example;

import javax.swing.*;
import java.awt.*;

public class SearchingWindow extends JFrame {
    static JLabel searchingCount;
    public SearchingWindow() {
        this.setSize(500,250);
        this.setBackground(Color.GRAY);

        searchingCount = new JLabel(String.valueOf(FindingWords.selectedWordsToCrossword.size()));
        searchingCount.setBounds(50,50,40,900);
        searchingCount.setFont(new Font("Times New Roman", Font.BOLD, 128));
        add(searchingCount);
    }
    public static void numberOfSearchingWord(int i){
        searchingCount.setText("");
        searchingCount.setText(i + "");
    }
}
