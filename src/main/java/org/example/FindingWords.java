package org.example;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
        Random random = new Random();
        int maxRandomValue = allWordsInCrossword.size();
        int minRandomValue = 0;
        boolean wordPass = true;
        boolean wordDoNotFit = false;
        int numberOfAttempts = 50;

        for (int i = 0; i < 7; i++) {
            WordsConnection presentWordParameters = parametersOfWords.get(i);
            String presentWord = wordDraw(random, maxRandomValue, minRandomValue, i);
            String firstWordToFit;
            numberOfAttempts--;
            for (int j = 0; j < presentWordParameters.numberOfConnectedWords; j++) {
                try {
                    firstWordToFit = selectedWordsToCrossword.get(presentWordParameters.numberOfWordsToConnectedWords.get(j) - 1);
                    if (presentWord.charAt(presentWordParameters.numberOfLettersInWordConnectedToConnectedWords.get(j) - 1) ==
                            firstWordToFit.charAt(presentWordParameters.numberOfPositionInConnectedWords.get(j) - 1)) {
                        wordPass = true;
                    } else {
                        wordDoNotFit = true;
                        wordPass = false;
                    }
                    if (!wordPass) {
                        presentWord = wordDraw(random, maxRandomValue, minRandomValue, i);
                        numberOfAttempts--;
                        if (numberOfAttempts < 1) {
                            numberOfAttempts = 50;
                            i = 0;
                            break;
                        }
                    }
                } catch (Exception e) {
                    if(j == presentWordParameters.numberOfConnectedWords-1 && !wordDoNotFit){
                        wordDoNotFit = false;
                        wordPass = true;
                    }
                }
            }
            if (wordPass) {
                selectedWordsToCrossword.add(presentWord);
                numberOfAttempts = 50;
            } else {
                if(numberOfAttempts < 1){
                    numberOfAttempts = 50;
                    i = 0;
                }
                i--;
            }
        }
        return (selectedWordsToCrossword);
    }

    private static String wordDraw(Random random, int maxRandomValue, int minRandomValue, int i) {
        String presentWord;
        do {
            presentWord = allWordsInCrossword.get(random.nextInt((maxRandomValue - minRandomValue) + minRandomValue));
        } while (presentWord.length() != allWordsInformation.get(i).lengthOfWord);
        return presentWord;
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
