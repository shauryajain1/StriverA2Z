class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
        }
        int n = stack.size();
        for(int i=0; i<n; i++){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}