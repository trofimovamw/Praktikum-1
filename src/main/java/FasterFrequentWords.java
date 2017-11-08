import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by maria on 01/11/17.
 */
public class FasterFrequentWords extends FrequentWords {

    public static void FasterFrequentWords(String text, Integer k) throws Exception{

        text = text.replace("\n", "").replace("\r", "");

        HashSet<String> frequentPatterns = new HashSet<String>();
        ArrayList<Integer> FrequencyArray = ComputingFrequencies(text,k);

        int maxCount = FrequencyArray.get(0);

        for (int i = 1; i < FrequencyArray.size(); i++) {
            int m = FrequencyArray.get(i);
            if (m > maxCount) {maxCount = m;}
            else {continue;}
        }


        for (int i = 0; i < FrequencyArray.size(); i++) {
            if (FrequencyArray.get(i) == maxCount) {
                String pattern = NumberToPattern(i,k);
                frequentPatterns.add(pattern);
            }
        }

        System.out.println(frequentPatterns);


    }

    public static ArrayList<Integer> ComputingFrequencies(String text, Integer k) throws Exception{

        ArrayList<Integer> frequencyArray = new ArrayList<Integer>();


        for (int i = 0; i < (Math.pow(4,k)-1); i++) {
            frequencyArray.add(0);
        }

        for (int i = 0; i < (text.length()-k)+1; i++) {

            String pattern = text.substring(i,i+k);
            int j = PatternToNumber(pattern);
            int f = frequencyArray.get(j);
            frequencyArray.set(j,f+1);

            }

        return frequencyArray;
    }

    public static String NumberToPattern(Integer index, Integer k) throws Exception{

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

    public static Integer PatternToNumber(String pattern) throws Exception{

        if (pattern.equals("")) {
            return 0;
        }

        else {
            String symbol = pattern.substring(pattern.length()-1);
            String prefix = pattern.substring(0,pattern.length()-1);
            return 4*PatternToNumber(prefix) + SymbolToNumber(symbol);
        }
    }

    public static Integer SymbolToNumber(String c) throws Exception{

        String s = c.toUpperCase();

        if (s.equals("A")) {
            return 0;
        }
        else if (s.equals("C")) {
            return 1;
        }
        else if (s.equals("G")) {
            return 2;
        }
        else {
            return 3;
        }


    }

    public static String NumberToSymbol(Integer i) throws Exception{

        if (i == 0) {
            return "A";
        }
        else if (i == 1) {
            return "C";
        }
        else if (i == 2) {
            return "G";
        }
        else {
            return "T";
        }

    }

    public static void main(String args[]) throws Exception{}

}
