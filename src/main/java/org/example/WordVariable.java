package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class WordVariable {
    int numberOfWord;
    int lengthOfWord;
    boolean verticalOrHorizontal;
    int PositionOfFirstCharInXAxis;
    int PositionOfFirstCharInYAxis;

    public WordVariable(int numberOfWord, int lengthOfWord, boolean verticalOrHorizontal, int positionOfFirstCharInXAxis, int positionOfFirstCharInYAxis) {
        this.numberOfWord = numberOfWord;
        this.lengthOfWord = lengthOfWord;
        this.verticalOrHorizontal = verticalOrHorizontal;
        PositionOfFirstCharInXAxis = positionOfFirstCharInXAxis;
        PositionOfFirstCharInYAxis = positionOfFirstCharInYAxis;
    }
}
