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
    private static ArrayList<String> allWords;

    public FindingWords(ArrayList<WordVariable> allWordsInfo) {
        allWordsInformation = allWordsInfo;
        allWordsInCrossword = downloadWordsFile();
    }
    public static ArrayList<String> run(){
        ArrayList<String> pickedWords= new ArrayList<>();
        boolean wordPassChecking = true;
        int maxRandomCount = 50;
//        System.out.println(allWordsInformation.get(0).toString());
//        System.out.println(parametersOfWords.get(0).toString());
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            WordsConnection presentWordParameters = parametersOfWords.get(i);
            String presentWord = allWords.get(random.nextInt(allWords.size()));
            for (int j = 0; j < presentWordParameters.numberOfConnectedWords; j++) {
                if(presentWord.length()==allWordsInformation.get(j).lengthOfWord) {
                    try {
                        String checkingWord = pickedWords.get(presentWordParameters.numberOfWordsToConnectedWords.get(j));
                        if (presentWord.charAt(presentWordParameters.numberOfLettersInWordConnectedToConnectedWords.get(j)) == checkingWord.charAt(presentWordParameters.
                                numberOfPositionInConnectedWords.get(j))) {
                            wordPassChecking = true;
                        } else {
                            wordPassChecking = false;
                        }
                    }catch(Exception e){
//                        System.out.println("Nie znaleziono dota slowa numer: " + j);
                    }
                    if (wordPassChecking) {
                        pickedWords.add(i, presentWord);
                        maxRandomCount=50;
                    } else {
                        maxRandomCount--;
                        j--;
                        wordPassChecking = true;
                    }
                }else{
                    j--;
                }
                if(maxRandomCount==0){
                    maxRandomCount=50;
                    pickedWords= new ArrayList<>();
                    j=-1;
                }
            }
        }
        return (pickedWords);
    }
    public static ArrayList<String> downloadWordsFile(){
        allWords = new ArrayList<>();
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
        System.out.println(allWords);
        return allWords;
    }
}
