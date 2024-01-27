package org.example;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FindingWords {
    private static ArrayList<WordVariable> allWordsInfomration;
    private static ArrayList<WordsConnection> parametersOfWords = WordsConnection.getParametersOfWords();
    private static ArrayList<String> allWordsInCrossword = new ArrayList<>();

    public FindingWords(ArrayList<WordVariable> allWordsInfo) {
        allWordsInfomration = allWordsInfo;
        allWordsInCrossword = downloadWordsFile();
    }
    public static ArrayList<String> run(){
        ArrayList<String> pickedWords= new ArrayList<>();
            System.out.println(allWordsInfomration.get(0).toString());
            System.out.println(parametersOfWords.get(0).toString());


        for (int i = 0; i < 8; i++) {
            WordsConnection presentWord = parametersOfWords.get(i);
            for (int j = 0; j < presentWord.numberOfConnectedWords; j++) {
                if(pickedWords.get(presentWord.numberOfWordsToConnectedWords.get(j))!=null){

                }
            }
        }
        return (pickedWords);
    }
    public static ArrayList<String> downloadWordsFile(){
        ArrayList<String> allWords = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    allWords.add(myReader.nextLine());
                }
                myReader.close();
            }catch(Exception e){
                System.out.println("Read File Problem");
            }
        }
        return allWords;
    }
}
