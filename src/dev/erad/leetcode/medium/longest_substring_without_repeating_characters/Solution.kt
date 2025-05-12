package dev.erad.leetcode.medium.longest_substring_without_repeating_characters

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val m = hashMapOf<Char, Int>()
        var ans = 0
        var left = 0
        var right = 0

        for (i in s.indices) {
            if (m.containsKey(s[i])) {
                left = maxOf(left, m[s[i]]!! + 1)
            }
            right += 1
            m[s[i]] = i
            ans = maxOf(right - left, ans)
        }

        return ans
    }
}