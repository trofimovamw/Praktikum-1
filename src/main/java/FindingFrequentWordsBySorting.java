import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by maria on 02/11/17.
 */
public class FindingFrequentWordsBySorting extends FasterFrequentWords{

    public static void FindingFrequentWordsBySorting(String text, Integer k) {


        ArrayList<String> frequentPatterns = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>(text.length()-k);

        for (int i = 0; i < text.length()-k; i++) {
            String pattern = text.substring(i,i+k);
            index.add(i,PatternToNumber(pattern));
            //System.out.println(pattern + " :" + PatternToNumber(pattern) );
            count.add(i,1);
        }

        Collections.sort(index);

        for (int i = 1; i < text.length()-k; i++) {
            if(index.get(i).equals(index.get(i-1))) {
                int cc = count.get(i-1);
                count.remove(i);
                count.add(i,cc+1);
                //System.out.println(i + " :" + (cc+1));
            }
        }

        int maxCount = count.get(0);

        for (int i = 1; i < count.size(); i++) {
            int m = count.get(i);
            if (m > maxCount) {maxCount = m;}
            else {continue;}
        }


        for (int i = 0; i < text.length()-k; i++) {
           if (count.get(i) == maxCount) {
               String pattern = NumberToPattern(index.get(i),k);
               frequentPatterns.add(pattern);
           }
        }

        for (int i = 0; i < frequentPatterns.size(); i++) {
            System.out.println(frequentPatterns.get(i));
        }

    }

    public static void main(String args[]) {
        FindingFrequentWordsBySorting("atcaatgatcaacgtaagcttctaagcatgatcaaggtgctcacacagtttatccacaacctgagtggatgacatcaagataggtcgttgtatctccttcctctcgtactctcatgaccacggaaagatgatcaagagaggatgatttcttggccatatcgcaatgaatacttgtgacttgtgcttccaattgacatcttcagcgccatattgcgctggccaaggtgacggagcgggattacgaaagcatgatcatggctgttgttctgtttatcttgttttgactgagacttgttaggatagacggtttttcatcactgactagccaaagccttactctgcctgacatcgaccgtaaattgataatgaatttacatgcttccgcgacgatttacctcttgatcatcgatccgattgaagatcttcaattgttaattctcttgcctcgactcatagccatgatgagctcttgatcatgtttccttaaccctctattttttacggaagaatgatcaagctgctgctcttgatcatcgtttc",9);
    }

}
