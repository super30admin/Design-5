from typing import List

#time complexity o(n^2)
#space complexity o(n)

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Solution:
    def insert(self, root: TrieNode, word: str) -> None:
        curr = root
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True

    def backtrack(self, curr: TrieNode, path: List[str], maxStr: List[str]) -> None:

        current_word = "".join(path)

        if len(current_word) > len(maxStr[0]) or (len(current_word) == len(maxStr[0]) and current_word < maxStr[0]):
            maxStr[0] = current_word

        # Explore all possible children (26 letters).
        for i in range(26):
            child = curr.children[i]
            if child is not None and child.isEnd:
                # Append the current character to the path.
                ch = chr(ord('a') + i)
                path.append(ch)

                # Recurse deeper.
                self.backtrack(child, path, maxStr)

                # Backtrack (remove the last character).
                path.pop()

    def longestWord(self, words: List[str]) -> str:
       
        # 1. Build the Trie.
        root = TrieNode()
        for word in words:
            self.insert(root, word)

        maxStr = [""]  
        self.backtrack(root, [], maxStr)

        return maxStr[0]

