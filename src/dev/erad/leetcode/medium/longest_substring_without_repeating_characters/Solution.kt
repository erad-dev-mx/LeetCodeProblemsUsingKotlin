package dev.erad.leetcode.medium.longest_substring_without_repeating_characters

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Time complexity: O(n)
// Space complexity: O(n)
// Why is time complexity O(n)? Because we are using a single loop that iterates over the input string.
// Why is space complexity O(n)? Because we are using a hash map to store the characters and their indices, which can grow with the input size.
// This is a sliding window approach.

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

fun main() {
    val solution = Solution()
    val s = "abcabcbb"
    val length = solution.lengthOfLongestSubstring(s)
    println("The length of the longest substring without repeating characters is: $length")
}