package dev.erad.leetcode.medium.container_with_most_water

// https://leetcode.com/problems/container-with-most-water/description/

// Time complexity: O(n)
// Space complexity: O(1)
// Why is time complexity 0(n)? Because we are using a single loop that iterates over the input array.
// Wgy is space complexity o(1)? Because we are not using any extra space that grows with the input size.
// This is a two-pointer approach.

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            val length = minOf(height[left], height[right])
            val width = right - left
            val area = length * width
            println(area)
            maxArea = maxOf(maxArea, area)

            if (height[left] < height[right]) {
                left += 1
            } else {
                right -= 1
            }
        }

        return maxArea
    }
}

fun main() {
    val solution = Solution()
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val maxArea = solution.maxArea(height)
    println("The maximum area is: $maxArea")
}