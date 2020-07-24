import java.util.ArrayList;
import java.util.List;

class AllPathsFromSourceToTarget797 {
    List<List<Integer>> main = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        findPaths(graph, path, 0, graph.length - 1);
        return main;
    }

    public void findPaths(int[][] graph, List<Integer> path, int node, int goal) {
        path.add(node);
        if (node == goal) {
            main.add(path);
            return;
        }

        for (int i = 0; i < graph[node].length; ++i) {
            List<Integer> pathCopy = new ArrayList(path);
            findPaths(graph, pathCopy, graph[node][i], goal);
        }

        return;
    }
}
