import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.DirectedCycle;


/*******************************************************************************
 * This class contains methods to create and manipulate a WordNet digraph.
 *
 * Performance requirement: Should use space linear in input size (size of
 * synsets and hypernyms files).
 *
 * @author Anand Dyavanapalli
 * @version 0.0
 ******************************************************************************/
public class WordNet {

    private final RedBlackBST<String, Integer> rbtree;
    private final Digraph digraph;

    /**
     * Constructs a WordNet with the given synsets and hypernyms.
     *
     * Performance requirement: Should take time linearithmic (or better) in
     * the input size.
     *
     * @param synsets the synsets filename string
     * @param hypernyms the hypernyms filename string
     * @throws NullPointerException if synsets string or hypernyms string are
     * null
     * @throws IllegalArgumentException if the input doesn't correspond to a
     * rooted DAG
     */
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null)
            throw new NullPointerException(
                    "Synset or hypernym filename string cannot be null.");

        // making a RedBlackBST with synsets file
        rbtree = new RedBlackBST<String, Integer>();
        In synsetsFile = new In(synsets);
        // keeping track of # of values
        int count = 1;
        while (synsetsFile.hasNextLine()) {
            String line = synsetsFile.readLine();
            // this extracts the synset ID as the value
            int value =  Integer.parseInt(line.split(",")[0]);
            // this extracts the nouns in the synset as keys
            String[] keys = line.split(",")[1].split(" ");
            for (String key : keys)
                rbtree.put(key, value);
            count++;
        }

        // making a digraph with hypernyms file
        In hypernymsFile = new In(hypernyms);
        digraph = new Digraph(count);
        while (hypernymsFile.hasNextLine()) {
            String[] relations = hypernymsFile.readLine().split(",");
            for (int i = 1; i < relations.length; i++)
                digraph.addEdge(0, Integer.parseInt(relations[i]));
        }

        // throws exception if digraph contains a cycle
        if (new DirectedCycle(digraph).hasCycle())
            throw new IllegalArgumentException(
                    "The hypernyms file contains a directed cycle.");
    }

    /**
     * Return all WordNet nouns.
     *
     * @return all WordNet nouns
     */
    public Iterable<String> nouns() {
        return rbtree.keys();
    }

    /**
     * Return true if word is a WordNet noun.
     *
     * Performance requirement: Should take time logarithmic (or better) in the
     * input size.
     *
     * @param word the word to be checked
     * @return true if word is WordNet noun
     * @throws NullPointerException if word string is null
     */
    public boolean isNoun(String word) {
        if (word == null)
            throw new NullPointerException(
                    "Word string cannot be null.");
        return rbtree.contains(word);
    }
    
    /**
     * Return the distance between nounA and nounB. The notion of distance
     * between two nouns A and B is given by the following definition:
     * distance(A, B) = the minimum length of any ancestral path between any
     * synset v of A and any synset w of B.
     *
     * Performance requirement: Should take time linear in the size of the
     * WordNet digraph.
     *
     * @param nounA the first WordNet noun
     * @param nounB the second WordNet noun
     * @return the distance between nounA and nounB
     * @throws NullPointerException if nounA string or nounB string is null
     * @throws IllegalArgumentException if either nounA or nounB aren't WordNet
     * nouns
     */
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null)
            throw new NullPointerException(
                    "NounA or NounB string cannot be null.");
        if (!isNoun(nounA) || !isNoun(nounB))
            throw new IllegalArgumentException(
                    "NounA and NounB must both be WordNet nouns.");
        return 0;
    }

    /**
     * Return the synset that is the common ancestor of nounA and nounB in a
     * shortest ancestral path.
     *
     * Performance requirement: Should take time linear in the size of the
     * WordNet digraph.
     *
     * @param nounA the first WordNet noun
     * @param nounB the second WordNet noun
     * @return a synset that is the common ancestor of nounA and nounB in a
     * shortest ancestral path
     * @throws NullPointerException if nounA string or nounB string is null
     * @throws IllegalArgumentException if either nounA or nounB aren't WordNet
     * nouns
     */
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null)
            throw new NullPointerException(
                    "NounA or NounB string cannot be null.");
        if (!isNoun(nounA) || !isNoun(nounB))
            throw new IllegalArgumentException(
                    "NounA and NounB must both be WordNet nouns.");
        return null;
    }

    // Unit testing WordNet class
    public static void main(String[] args) {
        WordNet wn = new WordNet(args[0], args[1]);
    }
}
