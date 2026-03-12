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

    private static ArrayList<String> NumberOfCharacters3Words = new ArrayList<>();
    private static ArrayList<String> NumberOfCharacters4Words = new ArrayList<>();
    private static ArrayList<String> NumberOfCharacters5Words = new ArrayList<>();
    private static ArrayList<String> NumberOfCharacters6Words = new ArrayList<>();
    private static ArrayList<String> NumberOfCharacters7Words = new ArrayList<>();
    private static ArrayList<String> NumberOfCharacters13Words = new ArrayList<>();

    public FindingWords(ArrayList<WordVariable> allWordsInfo) {
        allWordsInformation = allWordsInfo;
        allWordsInCrossword = downloadWordsFile();
        fillMainArrayOfWords();
    }

    private static void fillMainArrayOfWords(){
        for (int j = 0; j < allWordsInCrossword.size(); j++) {
            if (allWordsInCrossword.get(j).length() == 3) {
                NumberOfCharacters3Words.add(allWordsInCrossword.get(j));
            }else if(allWordsInCrossword.get(j).length() == 4){
                NumberOfCharacters4Words.add(allWordsInCrossword.get(j));
            }else if(allWordsInCrossword.get(j).length() == 5){
                NumberOfCharacters5Words.add(allWordsInCrossword.get(j));
            }else if(allWordsInCrossword.get(j).length() == 6){
                NumberOfCharacters6Words.add(allWordsInCrossword.get(j));
            }else if(allWordsInCrossword.get(j).length() == 7){
                NumberOfCharacters7Words.add(allWordsInCrossword.get(j));
            }else if(allWordsInCrossword.get(j).length() == 13){
                NumberOfCharacters13Words.add(allWordsInCrossword.get(j));

            }
        }
    }

    private static ArrayList<String> wordDraw(int i) {
        ArrayList<String> currentListOfSize = new ArrayList<>();
        int length = allWordsInformation.get(i).lengthOfWord;
        switch(length){
            case 3:
            {
                currentListOfSize = NumberOfCharacters3Words;
                break;
            }
            case 4:
            {
                currentListOfSize = NumberOfCharacters4Words;
                break;
            }
            case 5:
            {
                currentListOfSize = NumberOfCharacters5Words;
                break;
            }
            case 6:
            {
                currentListOfSize = NumberOfCharacters6Words;
                break;
            }
            case 7:
            {
                currentListOfSize = NumberOfCharacters7Words;
                break;
            }
            case 13:
            {
                currentListOfSize = NumberOfCharacters13Words;
                break;
            }
        }
        Collections.shuffle(currentListOfSize);
        return currentListOfSize;
    }
    public static ArrayList<String> downloadWordsFile() {
        ArrayList<String> allWords = new ArrayList<>();
        MainView.tfPath.getText();
            File file = new File(MainView.tfPath.getText());
            try {
                Scanner myReader = new Scanner(file, "UTF-8");
                while (myReader.hasNextLine()) {
                    allWords.add(myReader.nextLine().toUpperCase());
                }
                myReader.close();
            } catch (Exception e) {
                System.out.println("Read File Problem");
            }
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
                    resetAllWords = 10000;
                    break;
                } else {
                    if (resetAllWords <= 0) {
                        resetCrossword(startFromSearchingWord);
                        break;
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
        resetAllWords = 100;
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
