package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class WordVariable {
    String numberOfWord;
    int lengthOfWord;
    String verticalOrHorizontal;
    ArrayList<Integer> PositionOfWordInXAxis;
    ArrayList<Integer> PositionOfWordInYAxis;

    public WordVariable(String numberOfWord, int lengthOfWord, String verticalOrHorizontal, ArrayList<Integer> positionOfWordInXAxis, ArrayList<Integer> positionOfWordInYAxis) {
        this.numberOfWord = numberOfWord;
        this.lengthOfWord = lengthOfWord;
        this.verticalOrHorizontal = verticalOrHorizontal;
        PositionOfWordInXAxis = positionOfWordInXAxis;
        PositionOfWordInYAxis = positionOfWordInYAxis;
    }
}
