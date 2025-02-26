class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
            // create a hashmap to store character mappings
            Map<Character, Character> charMappingMap=new HashMap<>();

            for(int i=0;i<s.length();i++){
                 char original=s.charAt(i); // original string
                 char replacement=t.charAt(i); // replacement string

                 if(!charMappingMap.containsKey(original)){
                    if(!charMappingMap.containsValue(replacement))
                    charMappingMap.put(original,replacement);
                    else
                    return false;
                 }
                 else{
                    char mappedCharacter=charMappingMap.get(original);
                    if(mappedCharacter!=replacement)
                    return false;
                 }
            }
            return true;
        }
    }
    