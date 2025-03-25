package dev.erad.leetcode.medium.container_with_most_water

// https://leetcode.com/problems/container-with-most-water/description/

// Time complexity: O(n^2)
// Space complexity: O(1)
// Why is time complexity O(n^2)? Because we are using two nested loops that iterate over the input array.
// Why is space complexity O(1)? Because we are not using any extra space that grows with the input size.

class BruteForceSolution {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        val n = height.size

        for (i in height.indices) {
            for (j in i + 1..<n) {
                val length = minOf(height[i], height[j])
                val width = j - i
                val area = length * width
                maxArea = maxOf(maxArea, area)
            }
        }
        return maxArea
    }
}

fun main() {
    val solution = BruteForceSolution()
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val maxArea = solution.maxArea(height)
    println("The maximum area is: $maxArea")
}