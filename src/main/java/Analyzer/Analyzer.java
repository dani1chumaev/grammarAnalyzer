package Analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analyzer {

    public String analyze(String grammar) {

        List<String> rules = new ArrayList<>() {{
            add("0");
            add("01B");
            add("10B");
            add("10A");
        }};

        StringBuilder buf = new StringBuilder(grammar);
        StringBuilder sequence = new StringBuilder("");

        for (int i = buf.length() - 1; i >= 0; i--) {

            sequence.append(buf.charAt(i));
            StringBuilder reverseSequence = new StringBuilder(sequence).reverse();

            int finalI = i;
            if (rules.stream().noneMatch(r -> r.contains(reverseSequence) && finalI + 1 >= r.length() - sequence.length() + 1)) {
                i += sequence.length() - 1;
                sequence.delete(0, sequence.length());
                reverseSequence.delete(0, reverseSequence.length());
            }

            if (reverseSequence.toString().equals("0")) {
                buf.replace(i, i + 1, "B");
                i = buf.length();
                sequence.delete(0, sequence.length());
                reverseSequence.delete(0, reverseSequence.length());
            }
            if (reverseSequence.toString().equals("01B")) {
                buf.replace(i, i + 3, "B");
                i = buf.length();
                sequence.delete(0, sequence.length());
                reverseSequence.delete(0, reverseSequence.length());
            }
            if (reverseSequence.toString().equals("10B")) {
                buf.replace(i, i + 3, "A");
                i = buf.length();
                sequence.delete(0, sequence.length());
                reverseSequence.delete(0, reverseSequence.length());
            }
            if (reverseSequence.toString().equals("10A")) {
                buf.replace(i, i + 3, "A");
                i = buf.length();
                sequence.delete(0, sequence.length());
                reverseSequence.delete(0, reverseSequence.length());
            }

        }

        System.out.println(buf);

        if(Arrays.stream(buf.toString().split("")).anyMatch(s -> s.matches("\\d"))) {
            System.out.println("Неверная последовательность");
            return "Неверная последовательность";
        }

        System.out.println("Верная последовательность");
        return "Верная последовательность";
    }

}
