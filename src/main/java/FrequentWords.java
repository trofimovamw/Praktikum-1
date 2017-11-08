import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maria on 01/11/17.
 */
public class FrequentWords {

    public static void FrequentWords(String text, Integer k) {

        text = text.replace("\n", "").replace("\r", "");

        HashSet<String> frequentPatterns = new HashSet<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        for (int i = 0; i < (text.length()-k)+1; i++) {
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


        for (int i = 0; i < (text.length()-k)+1; i++) {
            int n = count.get(i);
            if (n == max) {frequentPatterns.add(text.substring(i,i+k));}
            else {continue;}
        }

        System.out.println(frequentPatterns);


    }

    public static Integer PatternCount(String text, String pattern) {
        int count = 0;
        for (int i = 0; i <= text.length()-pattern.length(); i++) {
            if (text.substring(i,i+pattern.length()).equals(pattern)) {
                count = count+1;
            }
        }
        return count;
    }

    public static void main(String args[]) throws Exception{}

}
