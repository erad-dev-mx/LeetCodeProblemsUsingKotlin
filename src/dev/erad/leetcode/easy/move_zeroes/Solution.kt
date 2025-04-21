package dev.erad.leetcode.easy.move_zeroes

// https://leetcode.com/problems/move-zeroes/description/

// Time complexity: O(n)
// Space complexity: O(1)
// Why is time complexity O(n)? Because we are iterating over the input array once to count non-zero elements and then again to fill the output list.
// Why is space complexity O(1)? Because we are not using any extra space that grows with the input size. We are modifying the input array in place.

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = 0
        val n = nums.size

        for (nonZeroIndex in 0..<n) {
            if (nums[nonZeroIndex] != 0) {
                nums[zeroIndex] = nums[nonZeroIndex]
                zeroIndex++
            }
        }

        for (i in zeroIndex..<n) {
            nums[i] = 0
        }
    }
}