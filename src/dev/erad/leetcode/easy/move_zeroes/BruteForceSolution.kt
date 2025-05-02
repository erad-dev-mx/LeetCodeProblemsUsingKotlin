package dev.erad.leetcode.easy.move_zeroes

// https://leetcode.com/problems/move-zeroes/description/

// Time complexity: O(n)
// Space complexity: O(n)
// Why is time complexity O(n)? Because we are iterating over the input array once to count non-zero elements and then again to fill the output list.
// Why is space complexity O(n)? Because we are using an output list to store the non-zero elements and then fill the rest with zeros.

class BruteForceSolution {
    fun moveZeroes(nums: IntArray): Unit {
        val output: MutableList<Int> = mutableListOf()

        val n = nums.size

        for (i in 0..<n) {
            if (nums[i] != 0) {
                output.add(nums[i])
            }
        }

        val nonZeroes = output.size
        for (j in nonZeroes..<n) {
            output.add(0)
        }

        for (i in nums.indices) {
            nums[i] = output[i]
        }
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    val solution = BruteForceSolution()
    solution.moveZeroes(nums)
    println("RT")
}