package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsConnection {
    public int wordNumber;
    public int numberOfConnectedWords;
    public List<Boolean> verticalConnectedWords;
    public List<Integer> numberOfLettersInWordConnectedToConnectedWords;
    public List<Integer> numberOfWordsToConnectedWords;
    public List<Integer> numberOfPositionInConnectedWords;

    public WordsConnection(int wordNumber, int numberOfConnectedWords, List<Boolean> verticalConnectedWords, List<Integer> numberOfLettersInWordConnectedToConnectedWords, List<Integer> numberOfWordsToConnectedWords, List<Integer> numberOfPositionInConnectedWords) {
        this.wordNumber = wordNumber;
        this.numberOfConnectedWords = numberOfConnectedWords;
        this.verticalConnectedWords = verticalConnectedWords;
        this.numberOfLettersInWordConnectedToConnectedWords = numberOfLettersInWordConnectedToConnectedWords;
        this.numberOfWordsToConnectedWords = numberOfWordsToConnectedWords;
        this.numberOfPositionInConnectedWords = numberOfPositionInConnectedWords;
    }

    public static ArrayList<WordsConnection> getParametersOfWords(){
        ArrayList<WordsConnection> wordsParameters = new ArrayList<>();
        wordsParameters.add(new WordsConnection(1,4,Arrays.asList(true,true,true,true), Arrays.asList(1,3,5,7),Arrays.asList(2,3,6,7),Arrays.asList(1,1,1,1)));
        wordsParameters.add(new WordsConnection(2,3,Arrays.asList(false,false,false), Arrays.asList(1,3,5),Arrays.asList(1,4,5),Arrays.asList(1,1,1)));
        wordsParameters.add(new WordsConnection(3,3,Arrays.asList(false,false,false), Arrays.asList(1,3,5),Arrays.asList(1,4,5),Arrays.asList(3,3,3)));
        wordsParameters.add(new WordsConnection(4,4,Arrays.asList(true,true,true,true), Arrays.asList(1,3,5,7),Arrays.asList(2,3,6,7),Arrays.asList(3,3,3,3)));
        wordsParameters.add(new WordsConnection(5,5,Arrays.asList(true,true,true,true,true), Arrays.asList(1,2,3,4,5),Arrays.asList(2,22,3,24,6),Arrays.asList(5,1,5,1,5)));
        wordsParameters.add(new WordsConnection(6,3,Arrays.asList(false,false,false), Arrays.asList(1,3,5),Arrays.asList(1,4,5),Arrays.asList(5,5,5)));
        wordsParameters.add(new WordsConnection(7,4,Arrays.asList(false,false,false,false), Arrays.asList(1,2,3,4),Arrays.asList(1,8,4,9),Arrays.asList(7,1,7,1)));
        wordsParameters.add(new WordsConnection(8,3,Arrays.asList(true,true,true),Arrays.asList(1,3,5),Arrays.asList(7,10,11),Arrays.asList(2,2,2)));
        wordsParameters.add(new WordsConnection(9,3,Arrays.asList(true,true,true),Arrays.asList(1,3,5),Arrays.asList(7,10,11),Arrays.asList(4,4,4)));
        wordsParameters.add(new WordsConnection(10,2,Arrays.asList(false,false),Arrays.asList(2,4),Arrays.asList(8,9),Arrays.asList(3,3)));
        wordsParameters.add(new WordsConnection(11,10,Arrays.asList(false,false,false,false,false,false,false,false,false,false),Arrays.asList(1,2,3,4,5,6,7,8,10,12),Arrays.asList(12,8,13,9,15,18,26,27,35,37),Arrays.asList(1,5,1,5,1,6,1,6,5,5)));
        wordsParameters.add(new WordsConnection(12,4,Arrays.asList(true,true,true,true),Arrays.asList(1,3,5,7),Arrays.asList(11,14,16,17),Arrays.asList(1,1,1,1)));
        wordsParameters.add(new WordsConnection(13,4,Arrays.asList(true,true,true,true),Arrays.asList(1,3,5,7),Arrays.asList(11,14,16,17),Arrays.asList(3,3,3,3)));
        wordsParameters.add(new WordsConnection(14,3,Arrays.asList(false, false, false),Arrays.asList(1,3,5),Arrays.asList(12,13,15),Arrays.asList(3,3,3)));
        wordsParameters.add(new WordsConnection(15,6,Arrays.asList(true,true,true,true,true,true),Arrays.asList(1,3,4,5,6,7),Arrays.asList(11,14,19,16,20,17),Arrays.asList(5,5,1,5,1,5)));
        wordsParameters.add(new WordsConnection(16,3,Arrays.asList(false, false, false),Arrays.asList(1,3,5),Arrays.asList(12,13,15),Arrays.asList(5,5,5)));
        wordsParameters.add(new WordsConnection(17,3,Arrays.asList(false, false, false),Arrays.asList(1,3,5),Arrays.asList(12,13,15),Arrays.asList(7,7,7)));
        wordsParameters.add(new WordsConnection(18,3,Arrays.asList(false, false, false),Arrays.asList(1,4,6),Arrays.asList(11,19,20),Arrays.asList(7,3,3)));
        wordsParameters.add(new WordsConnection(19,2,Arrays.asList(true,true),Arrays.asList(1,3),Arrays.asList(15,18),Arrays.asList(4,4)));
        wordsParameters.add(new WordsConnection(20,2,Arrays.asList(true,true),Arrays.asList(1,3),Arrays.asList(15,18),Arrays.asList(6,6)));
        wordsParameters.add(new WordsConnection(21,4,Arrays.asList(false,false,false,false),Arrays.asList(1,3,5,7),Arrays.asList(9,26,27,35),Arrays.asList(2,3,3,2)));
        wordsParameters.add(new WordsConnection(22,3,Arrays.asList(false,false,false),Arrays.asList(1,3,5),Arrays.asList(5,23,28),Arrays.asList(2,2,2)));
        wordsParameters.add(new WordsConnection(23,3,Arrays.asList(true,true,true), Arrays.asList(2,4,6),Arrays.asList(22,24,25),Arrays.asList(3,3,3)));
        wordsParameters.add(new WordsConnection(24,3,Arrays.asList(false,false,false),Arrays.asList(1,3,5),Arrays.asList(5,23,28),Arrays.asList(4,4,4)));
        wordsParameters.add(new WordsConnection(25,5,Arrays.asList(false,false,false,false,false),Arrays.asList(1,2,3,4,5),Arrays.asList(5,26,23,27,28),Arrays.asList(6,1,6,1,6)));
        wordsParameters.add(new WordsConnection(26,3,Arrays.asList(false,false,false),Arrays.asList(1,3,6),Arrays.asList(25,21,11),Arrays.asList(2,3,6)));
        wordsParameters.add(new WordsConnection(27,3,Arrays.asList(false,false,false),Arrays.asList(1,3,6),Arrays.asList(25,21,11),Arrays.asList(4,5,8)));
        wordsParameters.add(new WordsConnection(28,6,Arrays.asList(true,true,true,true,true,true), Arrays.asList(1,2,3,4,5,6),Arrays.asList(29,22,31,24,33,25),Arrays.asList(1,5,1,5,1,5)));
        wordsParameters.add(new WordsConnection(29,3,Arrays.asList(false,false,false),Arrays.asList(1,3,5),Arrays.asList(28,30,32),Arrays.asList(1,1,1)));
        wordsParameters.add(new WordsConnection(30,4,Arrays.asList(true,true,true,true), Arrays.asList(1,3,5,7),Arrays.asList(29,31,33,34),Arrays.asList(3,3,3,2)));
        wordsParameters.add(new WordsConnection(31,3,Arrays.asList(false,false,false),Arrays.asList(1,3,5),Arrays.asList(28,30,32),Arrays.asList(3,3,3)));
        wordsParameters.add(new WordsConnection(32,4,Arrays.asList(true,true,true,true), Arrays.asList(1,3,5,7),Arrays.asList(29,31,33,34),Arrays.asList(5,5,5,4)));
        wordsParameters.add(new WordsConnection(33,3,Arrays.asList(false,false,false),Arrays.asList(1,3,5),Arrays.asList(28,30,32),Arrays.asList(5,5,5)));
        wordsParameters.add(new WordsConnection(34,4,Arrays.asList(false,false,false,false),Arrays.asList(1,2,3,4),Arrays.asList(35,30,37,32),Arrays.asList(1,7,1,7)));
        wordsParameters.add(new WordsConnection(35,4,Arrays.asList(true,true,true,true),Arrays.asList(1,2,3,5),Arrays.asList(34,21,36,11),Arrays.asList(1,7,1,10)));
        wordsParameters.add(new WordsConnection(36,2,Arrays.asList(false,false),Arrays.asList(1,3),Arrays.asList(35,37),Arrays.asList(3,3)));
        wordsParameters.add(new WordsConnection(37,3,Arrays.asList(true,true,true),Arrays.asList(1,3,5),Arrays.asList(34,36,11),Arrays.asList(3,3,12)));
        return wordsParameters;
    }

    @Override
    public String toString() {
        return "WordNumber=" + wordNumber +
                ", numberOfConnectedWords=" + numberOfConnectedWords +
                ", verticalConnectedWords=" + verticalConnectedWords +
                ", numberOfLettersInWordConnectedToConnectedWords=" + numberOfLettersInWordConnectedToConnectedWords +
                ", numberOfWordsToConnectedWords=" + numberOfWordsToConnectedWords +
                ", numberOfPositionInConnectedWords=" + numberOfPositionInConnectedWords;
    }
}
