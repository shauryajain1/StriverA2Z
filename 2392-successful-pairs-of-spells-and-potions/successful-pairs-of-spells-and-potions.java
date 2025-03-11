import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int left = 0, right = potions.length - 1, count = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long) spell * potions[mid] >= success) {
                    right = mid - 1;
                    count = potions.length - mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = count;
        }
        return result;
    }
}