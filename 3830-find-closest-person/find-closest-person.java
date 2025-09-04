class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1= Math.abs(x-z);
        int dist2 = Math.abs(y - z); // Distance from Person 2 to Person 3
        // Compare distances and return result as per problem statement
        if (dist1 < dist2) return 1; // Person 1 arrives first
        if (dist2 < dist1) return 2; // Person 2 arrives first
        return 0; // Both arrive at the same time
    }
}
