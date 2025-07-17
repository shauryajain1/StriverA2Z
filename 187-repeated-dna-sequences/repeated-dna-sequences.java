class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        int bits = 0;

        for (int right = 0; right < s.length(); right++) {
            // update Hash (bits)
            if (right >= 10) {
                bits = bits << 2;
                bits &= 0xfffff;
            } else {
                bits = bits << 2;
            }
            bits |= getBits(s, right);

            System.out.println("bits = " + Integer.toBinaryString(bits));

            // update result & Sets
            if (right >= 10 - 1) {
                if (!set.add(bits)) { // hash already in set
                    if(duplicates.add(bits)) { // hash NOT yet in duplicates
                        result.add(s.substring(right - 10 + 1, right + 1));
                    }
                }
            }
            
        }

        return result;
    }
    private int getBits(String s, int i) {
        return getBits(s.charAt(i));
    }
    private int getBits(char c) {
        assert c == 'A' || c == 'C' || c == 'T' || c == 'G': "should be a DNA Sequence character";

        switch(c) {
            case 'A':
                return 0b00;
            case 'C':
                return 0b01;
            case 'T':
                return 0b10;
            default:
                return 0b11;
        }
    }
}