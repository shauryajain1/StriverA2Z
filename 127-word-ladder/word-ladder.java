class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> L) {
        Queue<Tuple> q = new LinkedList<>();
        Set<String> set = new HashSet<>(L);
        set.remove(beginWord);
        q.add(new Tuple(beginWord, 1));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            String node = tuple.node;
            int x = tuple.x;
            if(node.equals(endWord)) return x;
            for (int i = 0; i < node.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] temp = node.toCharArray();
                    temp[i] = ch;
                    String newString = new String(temp);
                    if (set.contains(newString)) {
                        q.add(new Tuple(newString, x + 1));
                        set.remove(newString);
                    }
                }
            } 
        }
        return 0;
    }
}
class Tuple{
    String node;
    int x;
    Tuple(String node, int x) {
        this.node = node;
        this.x = x;
    }
}