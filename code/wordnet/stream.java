import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;

public class stream {
    public static void main(String[] args) {
        In hypernymsFile = new In(args[0]);
        int count = 1;
        while (hypernymsFile.hasNextLine()) {
            count++;
            hypernymsFile.readLine();
        }

        Digraph digraph = new Digraph(count);
        while (hypernymsFile.hasNextLine()) {
            String[] relations = hypernymsFile.readLine().split(",");
            for (int i = 1; i < relations.length; i++)
                digraph.addEdge(0, Integer.parseInt(relations[i]));
        }
        System.out.println(digraph);
    }
}
