class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [x for x, y in Counter(nums).most_common(k)]