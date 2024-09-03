package org.example;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class FindingWords {
    private static ArrayList<WordVariable> allWordsInformation;
    private static ArrayList<WordsConnection> parametersOfWords = WordsConnection.getParametersOfWords();
    private static ArrayList<String> allWordsInCrossword = new ArrayList<>();
    public static ArrayList<String> selectedWordsToCrossword = new ArrayList<>();


    public FindingWords(ArrayList<WordVariable> allWordsInfo) {
        allWordsInformation = allWordsInfo;
        allWordsInCrossword = downloadWordsFile();
    }

    public static ArrayList<String> run() {
        boolean wordPass = true;

        for (int i = 0; i < 23; i++) {
//            WordsConnection presentWordParameters = parametersOfWords.get(MainCrossword.mainOrderOfSearchingWords.get(i));
            WordsConnection presentWordParameters = parametersOfWords.get(i);
            ArrayList<String> presentsWordsOfGivenLength = wordDraw(i);
            String firstWordToFit;
            String presentWord = null;
            for (int ii = 0; ii < presentsWordsOfGivenLength.size(); ii++) {
                presentWord = presentsWordsOfGivenLength.get(ii);
                for (int j = 0; j < presentWordParameters.numberOfConnectedWords; j++) {
                    try {
                        firstWordToFit = selectedWordsToCrossword.get(presentWordParameters.numberOfWordsToConnectedWords.get(j) - 1);
                        if (presentWord.charAt(presentWordParameters.numberOfLettersInWordConnectedToConnectedWords.get(j) - 1) ==
                                firstWordToFit.charAt(presentWordParameters.numberOfPositionInConnectedWords.get(j) - 1)) {
                            wordPass = true;
                        } else {
                            wordPass=false;
                            break;
                        }
                    } catch (Exception e) {
                        if (j == presentWordParameters.numberOfConnectedWords - 1) {
                            wordPass = true;
                        }
                    }
                }if (wordPass) {
                    selectedWordsToCrossword.add(presentWord);
                    break;
                }
            }
            if(!wordPass){
                selectedWordsToCrossword.clear();
                wordPass = true;
                i=-1;
            }
        }
        JOptionPane.showMessageDialog(MainCrossword.window,"End searching/Koniec wyszkiwania");
        return (selectedWordsToCrossword);
    }

    private static ArrayList<String> wordDraw(int i) {
        ArrayList<String> currentListOfSize = new ArrayList<>();
        for (int j = 0; j < allWordsInCrossword.size(); j++) {
            if(allWordsInCrossword.get(j).length()==allWordsInformation.get(i).lengthOfWord){
                currentListOfSize.add(allWordsInCrossword.get(j));
            }
        }
        Collections.shuffle(currentListOfSize);
        return currentListOfSize;
    }

    public static ArrayList<String> downloadWordsFile() {
        ArrayList<String> allWords = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    allWords.add(myReader.nextLine());
                }
                myReader.close();
            } catch (Exception e) {
                System.out.println("Read File Problem");
            }
        }
        return allWords;
    }
}
