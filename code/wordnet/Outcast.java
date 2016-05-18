import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {

    private WordNet wordnet;

    // Constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // Given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int outcastDistance = 0;
        int maxOutcastDistance = 0;
        String outcast = nouns[0];

        for (int i = 0; i < nouns.length; i++) {
            outcastDistance = outcastDistance(nouns[i], nouns);
            if (outcastDistance > maxOutcastDistance) {
                maxOutcastDistance = outcastDistance;
                outcast = nouns[i];
            }
        }
        return outcast;
    }

    private int outcastDistance(String noun, String[] nouns) {
        int outcastDistance = 0;
        for (int i = 0; i < nouns.length; i++)
            outcastDistance += wordnet.distance(noun, nouns[i]);
        return outcastDistance;
    }

    // Unit testing Outcast class
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
