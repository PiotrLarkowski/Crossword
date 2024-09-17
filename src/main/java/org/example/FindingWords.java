package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;

import static java.lang.System.currentTimeMillis;

public class FindingWords{
    private static ArrayList<WordVariable> allWordsInformation;
    private static ArrayList<WordsConnection> parametersOfWords = WordsConnection.getParametersOfWords();
    private static ArrayList<String> allWordsInCrossword = new ArrayList<>();
    public static ArrayList<String> selectedWordsToCrossword = new ArrayList<>();
    public FindingWords(ArrayList<WordVariable> allWordsInfo) {
        allWordsInformation = allWordsInfo;
        allWordsInCrossword = downloadWordsFile();
    }

    private static ArrayList<String> wordDraw(int i) {
        Set<String> currentListOfSize = new HashSet<>();
        for (int j = 0; j < allWordsInCrossword.size(); j++) {
            if(allWordsInCrossword.get(j).length()==allWordsInformation.get(i).lengthOfWord){
                currentListOfSize.add(allWordsInCrossword.get(j));
            }
        }
        ArrayList<String> endList = new ArrayList<>(currentListOfSize);
        Collections.shuffle(endList);
        return endList;
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

    public void fillListWithEmptySlots(){
        for (int i = 0; i < 37; i++) {
            selectedWordsToCrossword.add(i,null);
        }
    }
    public void run() {
        fillListWithEmptySlots();

        boolean wordPass = true;
        boolean firstLoop = true;
        int resetAllWords = 100;
        int useOfResetAllWords = resetAllWords;

        WordsConnection presentWordParameters;
        for (int i = 0; i < 10; i++) {
            presentWordParameters = parametersOfWords.get(MainCrossword.mainOrderOfSearchingWords.get(i)-1);
            ArrayList<String> presentsWordsOfGivenLength = wordDraw(MainCrossword.mainOrderOfSearchingWords.get(i)-1);
            String firstWordToFit;
            String presentWord = null;
            for (int ii = 0; ii < presentsWordsOfGivenLength.size(); ii++) {
                presentWord = presentsWordsOfGivenLength.get(ii);
                for (int j = 0; j < presentWordParameters.numberOfConnectedWords; j++) {
                    try {
                        firstWordToFit = selectedWordsToCrossword.get(presentWordParameters.numberOfWordsToConnectedWords.get(j));
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
                    selectedWordsToCrossword.add(MainCrossword.mainOrderOfSearchingWords.get(i),presentWord);
                    break;
                }
            }
            if(!wordPass){
                if(!firstLoop) {
                    i--;
                }
                for (int j = 0; j < 4; j++) {
                    if(i>0){
                        selectedWordsToCrossword.remove(i-1);
                        firstLoop = false;
                        i--;
                        useOfResetAllWords--;
                    }
                }
                if(useOfResetAllWords<=0){
                    wordPass = true;
                    useOfResetAllWords = resetAllWords;
                    fillListWithEmptySlots();
                    i=-1;
                }
            }
        }
        JOptionPane.showMessageDialog(MainCrossword.window,"End searching/Koniec wyszkiwania");
        MainView.pickedWords = selectedWordsToCrossword;
    }
}
