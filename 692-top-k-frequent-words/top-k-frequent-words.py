class Solution(object):
    def topKFrequent(self, words, k):
        frequency = Counter(words)
        sorted_words = sorted(frequency.keys(), key=lambda word: (-frequency[word], word))
        return sorted_words[:k]