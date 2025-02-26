class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> obj = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                obj.add("FizzBuzz");
            }
            else if(i % 5 == 0){
                obj.add("Buzz");
            }
            else if(i % 3 == 0){
                obj.add("Fizz");
            }
            else{
                obj.add(String.valueOf(i));
            }
        }
        return obj;
    }
}