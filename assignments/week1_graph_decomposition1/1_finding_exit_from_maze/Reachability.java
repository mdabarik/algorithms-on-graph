import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        Set<Integer> set = new HashSet<>();
        return helper(adj, x, y, set);
    }

    private static int helper(ArrayList<Integer>[] adjList, int src, int dest, Set<Integer> set) {
        set.add(src);
        if (src == dest) return 1;
        for (int nbr : adjList[src]) {
            if (!set.contains(nbr)) {
                if (helper(adjList, nbr, dest, set) == 1) {
                    return 1;
                }
            }
        }
        return 0;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

