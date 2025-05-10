class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        List<Integer>[] adjacencyList = new List[n];
        for(int i=0;i<n;i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        seen[source] = true;

        while(!stack.isEmpty()){
            int top = stack.pop();
            if(top == destination) return true;

            for(int node: adjacencyList[top]){
                if(!seen[node]){
                    seen[node] = true;
                    stack.push(node);
                }
            }
            
        }

        return false;
    }
}