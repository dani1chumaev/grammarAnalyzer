import Analyzer.Analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Analyzer.analyzeGrammar(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
