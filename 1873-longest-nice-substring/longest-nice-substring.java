class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return ""; // A single character can't be nice

        // Use a set to store all characters in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.contains(Character.toString(Character.toUpperCase(c))) &&
                s.contains(Character.toString(Character.toLowerCase(c)))) {
                continue; // This character is fine
            }

            // Split into left and right substrings and recurse
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            // Return the longer of the two
            return left.length() >= right.length() ? left : right;
        }

        return s; // If the entire string is nice, return it
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestNiceSubstring("YazaAay")); // Output: "aAa"
        System.out.println(solution.longestNiceSubstring("Bb"));      // Output: "Bb"
        System.out.println(solution.longestNiceSubstring("c"));       // Output: ""
    }
}