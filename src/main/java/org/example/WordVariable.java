package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class WordVariable {
    String numberOfWord;
    int lengthOfWord;
    String verticalOrHorizontal;
    int PositionOfFirstCharInXAxis;
    int PositionOfFirstCharInYAxis;

    public WordVariable(String numberOfWord, int lengthOfWord, String verticalOrHorizontal, int positionOfFirstCharInXAxis, int positionOfFirstCharInYAxis) {
        this.numberOfWord = numberOfWord;
        this.lengthOfWord = lengthOfWord;
        this.verticalOrHorizontal = verticalOrHorizontal;
        PositionOfFirstCharInXAxis = positionOfFirstCharInXAxis;
        PositionOfFirstCharInYAxis = positionOfFirstCharInYAxis;
    }
}
