import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < adj.length; i++) {
            int u = i;
            if (!set.contains(u)) {
                result++;
                helper(adj, u, set);
            }
        }
        return result;
    }

    private static void helper(ArrayList<Integer>[] adjlist, int currNode, HashSet<Integer> set) {
        set.add(currNode);
        for (int nbr : adjlist[currNode]) {
            if (!set.contains(nbr)) {
                helper(adjlist, nbr, set);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

