import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maria on 01/11/17.
 */
public class FrequentWords {

    public static void FrequentWords(String text, Integer k) {

        ArrayList<String> frequentPatterns = new ArrayList<String>(500);
        ArrayList<Integer> count = new ArrayList<Integer>(500);

        for (int i = 0; i < text.length()-k; i++) {
            String pattern = text.substring(i,i+k);
            Integer c = PatternCount(text,pattern);
            count.add(i,c);
        }

        int max = count.get(0);

        for (int i = 1; i < count.size(); i++) {
            int m = count.get(i);
            if (m > max) {max = m;}
            else {continue;}
        }

        System.out.println(max);
        System.out.println();

        for (int i = 0; i < text.length()-k; i++) {
            int n = count.get(i);
            if (n == max) {frequentPatterns.add(text.substring(i,i+k));}
            else {continue;}
        }

        //remove duplicates from frequentPatterns

        for (int i = 0; i < frequentPatterns.size(); i++) {
            String p = frequentPatterns.get(i);
            System.out.println("i=" + i);
            for (int j = i+1; j < frequentPatterns.size(); j++) {
                String q = frequentPatterns.get(j);
                System.out.println(j);
                if (q.equals(p)) {
                    frequentPatterns.remove(j);
                    //j--; so that it bounces back and goes through this index again (already empty, so skips the if)
                    j = j-1;
                    System.out.println("here");
                }
            }
        }

        for (int i = 0; i < frequentPatterns.size(); i++) {
            System.out.println(frequentPatterns.get(i));
        }

    }

    public static Integer PatternCount(String text, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        Integer count = 0;
        while (m.find())
            count++;
        return count;
    }

    public static void main(String args[]) {
        FrequentWords("atcaatgatcaacgtaagcttctaagcatgatcaaggtgctcacacagtttatccacaacctgagtggatgacatcaagataggtcgttgtatctccttcctctcgtactctcatgaccacggaaagatgatcaagagaggatgatttcttggccatatcgcaatgaatacttgtgacttgtgcttccaattgacatcttcagcgccatattgcgctggccaaggtgacggagcgggattacgaaagcatgatcatggctgttgttctgtttatcttgttttgactgagacttgttaggatagacggtttttcatcactgactagccaaagccttactctgcctgacatcgaccgtaaattgataatgaatttacatgcttccgcgacgatttacctcttgatcatcgatccgattgaagatcttcaattgttaattctcttgcctcgactcatagccatgatgagctcttgatcatgtttccttaaccctctattttttacggaagaatgatcaagctgctgctcttgatcatcgtttc",9);
    }

}
