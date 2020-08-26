package lab;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.List;

public class SplitWordsDemo {
    public static void main(String[] args) {
        String sentence = "念念不忘，必有回响";
        List<Term> termList = NlpAnalysis.parse(sentence).getTerms();
        for (Term term : termList) {
            System.out.println(term.getNatureStr() + ":" + term.getRealName());
        }
    }
}
