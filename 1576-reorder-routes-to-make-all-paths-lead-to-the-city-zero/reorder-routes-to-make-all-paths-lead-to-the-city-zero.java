class Solution {
    public int minReorder(int n, int[][] connections) {
    List<List<int[]>> graph = new ArrayList<>();
    
    // \U0001f3d7️ Initialize adjacency list
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    
    // \U0001f504 Convert directed edges into an undirected representation
    for (int[] road : connections) {
        graph.get(road[0]).add(new int[]{road[1], 1}); // \U0001f504 Needs reversal
        graph.get(road[1]).add(new int[]{road[0], 0}); // ✅ Already correct
    }
    
    // \U0001f680 Start DFS from node 0
    return dfs(graph, 0, -1);
}

// \U0001f6e0️ DFS Helper Function
private int dfs(List<List<int[]>> graph, int node, int parent) {
    int count = 0;
    
    // \U0001f50d Traverse all connected roads
    for (int[] road : graph.get(node)) {
        int to = road[0];   // Connected city
        int dir = road[1];  // 1 if needs reversal, 0 if already correct

        if (to != parent) { // ✅ Avoid traversing back to parent
            count += dir;   // \U0001f504 Count if reversal is needed
            count += dfs(graph, to, node);
        }
    }
    
    return count;
}
}