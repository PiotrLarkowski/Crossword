package org.example;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class FindingWords {

    boolean wordPass = true;
    int resetAllWords = 100;
    int mainLoopIterator;

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
            if (allWordsInCrossword.get(j).length() == allWordsInformation.get(i).lengthOfWord) {
                currentListOfSize.add(allWordsInCrossword.get(j));
            }
        }
        ArrayList<String> endList = new ArrayList<>(currentListOfSize);
        Collections.shuffle(endList);
        return endList;
    }

    public static ArrayList<String> downloadWordsFile() {
        ArrayList<String> allWords = new ArrayList<>();
        MainView.tfPath.getText();
            File file = new File(MainView.tfPath.getText());
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    allWords.add(myReader.nextLine());
                }
                myReader.close();
            } catch (Exception e) {
                System.out.println("Read File Problem");
            }
//        }
        return allWords;
    }

    public void run(int startFromSearchingWord, int stopToSearchingWord) {
        resetCrossword(startFromSearchingWord);
        WordsConnection presentWordParameters;
        for (mainLoopIterator = startFromSearchingWord; mainLoopIterator < stopToSearchingWord; mainLoopIterator++) {
            if(mainLoopIterator!=startFromSearchingWord && selectedWordsToCrossword.get(mainLoopIterator-1)==null){
                resetCrossword(startFromSearchingWord);
            }
            if(selectedWordsToCrossword.get(mainLoopIterator)!=null && !selectedWordsToCrossword.get(mainLoopIterator).isEmpty()){
                mainLoopIterator++;
            }
            presentWordParameters = parametersOfWords.get(MainCrossword.mainOrderOfSearchingWords.get(mainLoopIterator)); //get parameters for searching number of word
            ArrayList<String> presentsWordsOfGivenLength = wordDraw(MainCrossword.mainOrderOfSearchingWords.get(mainLoopIterator));
            String firstWordToFit;
            String presentWord = null;
            for (int ii = 0; ii < presentsWordsOfGivenLength.size(); ii++) {
                resetAllWords--;
                for (int j = 0; j < presentWordParameters.numberOfConnectedWords; j++) {
                    presentWord = presentsWordsOfGivenLength.get(ii);
                    firstWordToFit = selectedWordsToCrossword.get(presentWordParameters.numberOfWordsToConnectedWords.get(j)-1);
                    try {
                        if (!presentWord.equals(firstWordToFit)) {
                            if (presentWord.charAt(presentWordParameters.numberOfLettersInWordConnectedToConnectedWords.get(j) - 1) ==
                                    firstWordToFit.charAt(presentWordParameters.numberOfPositionInConnectedWords.get(j) - 1)) {
                                wordPass = true;
                            } else {
                                wordPass = false;
                                break;
                            }
                        }
                    } catch (Exception ignore) {
                        wordPass = true;
                    }
                }
                if (wordPass) {
                    selectedWordsToCrossword.set(MainCrossword.mainOrderOfSearchingWords.get(mainLoopIterator), presentWord);
                    resetAllWords = 100;
                    break;
                } else {
                    if (resetAllWords <= 0) {
                        resetCrossword(startFromSearchingWord);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(MainCrossword.window, "End searching/Koniec wyszkiwania");
        MainView.pickedWords = selectedWordsToCrossword;
    }

    public void resetCrossword(int startFromSearchingWord) {
        mainLoopIterator = startFromSearchingWord;
        wordPass = true;
        resetAllWords = 1000;
        fillChosenWordsListWithEmptySlots();
        clearChosenWordsOnMainView();
    }
    public void clearChosenWordsOnMainView(){
        for (int i = 0; i < MainView.choseWords.size(); i++) {
            if(!MainView.choseWords.get(i).trim().isBlank()){
                selectedWordsToCrossword.set(i,MainView.choseWords.get(i));
            }
        }
    }
    public void fillChosenWordsListWithEmptySlots() {
        selectedWordsToCrossword = new ArrayList<>(Arrays.asList(
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null));
    }
}
