class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size(); // \U0001f3e0 Total number of rooms
    boolean[] visited = new boolean[n]; // \U0001f3f7️ Track visited rooms
    dfs(rooms, 0, visited); // \U0001f50d Start DFS from room 0

    for (boolean room : visited) { // \U0001f504 Check if all rooms are visited
        if (!room) return false; // ❌ If any room is unvisited, return false
    }
    return true; // ✅ All rooms visited!
}

private void dfs(List<List<Integer>> rooms, int current, boolean[] visited) {
    visited[current] = true; // \U0001f6a9 Mark the room as visited

    for (int key : rooms.get(current)) { // \U0001f511 Iterate through keys in the room
        if (!visited[key]) { // \U0001f3e0 If the room is not visited, visit it
            dfs(rooms, key, visited);
        }
    }
}
}