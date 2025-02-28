class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for(Map.Entry<Character, Integer> entry : list){
            sb.append(Character.toString(entry.getKey()).repeat(entry.getValue()));
        }

        return sb.toString();
        
    }
}