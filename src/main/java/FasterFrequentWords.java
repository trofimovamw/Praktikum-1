import java.util.ArrayList;

/**
 * Created by maria on 01/11/17.
 */
public class FasterFrequentWords {

    public static void FasterFrequentWords(String text, Integer k) {

        ArrayList<String> frequentPatterns = new ArrayList<String>();

        ArrayList<Integer> FrequencyArray = ComputingFrequencies(text,k);

        int maxCount = FrequencyArray.get(0);

        for (int i = 1; i < FrequencyArray.size(); i++) {
            int m = FrequencyArray.get(i);
            if (m > maxCount) {maxCount = m;}
            else {continue;}
        }

        System.out.println("maxCount = " + maxCount);

        for (int i = 0; i < FrequencyArray.size(); i++) {
            if (FrequencyArray.get(i) == maxCount) {
                String pattern = NumberToPattern(i,k);
                frequentPatterns.add(pattern);
            }
        }

        for (int i = 0; i < frequentPatterns.size(); i++) {
            System.out.println(frequentPatterns.get(i));
        }

    }

    public static ArrayList<Integer> ComputingFrequencies(String text, Integer k) {

        ArrayList<Integer> frequencyArray = new ArrayList<Integer>();


        for (int i = 0; i < (Math.pow(4,k)-1); i++) {
            frequencyArray.add(0);
        }

        System.out.println("Size of freq array: " + frequencyArray.size());

        for (int i = 0; i < text.length()-k; i++) {

            String pattern = text.substring(i,i+k);
            //System.out.println("pattern: " + pattern);
            int j = PatternToNumber(pattern);
            //System.out.println("PatternToNumber: " + j);
            int f = frequencyArray.get(j);
            //System.out.println("f: " + j);
            frequencyArray.remove(j);
            frequencyArray.add(j,f+1);

        }

        return frequencyArray;
    }

    public static String NumberToPattern(Integer index, Integer k) {

        if (k == 1) {
            return NumberToSymbol(index);
        }

        else {
            Integer prefIndex = index / 4;
            Integer remainder = index % 4;
            String symbol = NumberToSymbol(remainder);
            String prefixPattern = NumberToPattern(prefIndex,k-1);
            String cc = prefixPattern.concat(symbol);

            return cc;
        }
    }

    public static Integer PatternToNumber(String pattern) {

        if (pattern.equals("")) {
            return 0;
        }

        else {
            String symbol = pattern.substring(pattern.length()-1);
            String prefix = pattern.substring(0,pattern.length()-1);
            return 4*PatternToNumber(prefix) + SymbolToNumber(symbol);
        }
    }

    public static Integer SymbolToNumber(String c) {

        String s = c.toLowerCase();

        if (s.equals("a")) {
            return 0;
        }
        else if (s.equals("c")) {
            return 1;
        }
        else if (s.equals("g")) {
            return 2;
        }
        else {
            return 3;
        }

    }

    public static String NumberToSymbol(Integer i) {

        if (i == 0) {
            return "a";
        }
        else if (i == 1) {
            return "c";
        }
        else if (i == 2) {
            return "g";
        }
        else {
            return "t";
        }

    }

    public static void main(String args[]) {
        FasterFrequentWords("atcaatgatcaacgtaagcttctaagcatgatcaaggtgctcacacagtttatccacaacctgagtggatgacatcaagataggtcgttgtatctccttcctctcgtactctcatgaccacggaaagatgatcaagagaggatgatttcttggccatatcgcaatgaatacttgtgacttgtgcttccaattgacatcttcagcgccatattgcgctggccaaggtgacggagcgggattacgaaagcatgatcatggctgttgttctgtttatcttgttttgactgagacttgttaggatagacggtttttcatcactgactagccaaagccttactctgcctgacatcgaccgtaaattgataatgaatttacatgcttccgcgacgatttacctcttgatcatcgatccgattgaagatcttcaattgttaattctcttgcctcgactcatagccatgatgagctcttgatcatgtttccttaaccctctattttttacggaagaatgatcaagctgctgctcttgatcatcgtttc",9);
    }

}
