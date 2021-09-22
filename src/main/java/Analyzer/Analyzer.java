package Analyzer;

import entity.Sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Analyzer {

    public static String analyzeGrammar(String grammar) {

        char[] chars = grammar.toCharArray();

        List<Sequence> sequences = new ArrayList<>();

        char currentChar = ' ';
        int count = 0;

        for (char character: chars
             ) {

            if (currentChar == ' ') {
                currentChar = character;

            }
            if (character != currentChar) {
                sequences.add(new Sequence(currentChar, count));
                currentChar = character;
                count = 0;
            }
            count++;
        }
        return "";
    }

}
