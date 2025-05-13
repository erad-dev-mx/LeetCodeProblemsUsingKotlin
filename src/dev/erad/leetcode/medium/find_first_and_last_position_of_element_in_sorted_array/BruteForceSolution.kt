package dev.erad.leetcode.medium.find_first_and_last_position_of_element_in_sorted_array


// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time complexity: O(n)
// Space complexity: O(1)
// Why is time complexity O(n)? Because we are using a linear search to find the first and last position of the target element.
// Why is space complexity O(1)? Because we are not using any extra space that grows with the input size.

class BruteForceSolution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = findFirst(nums, target)
        val last = findLast(nums, target)

        return intArrayOf(first, last)
    }

    fun findFirst(input: IntArray, target: Int): Int {
        val n = input.size
        for (i in 0 until n) {
            if (input[i] == target) {
                return i
            }
        }
        return -1
    }

    fun findLast(input: IntArray, target: Int): Int {
        val n = input.size
        for (i in n - 1 downTo 0) {
            if (input[i] == target) {
                return i
            }
        }
        return -1
    }
}

fun main() {
    val solution = BruteForceSolution()
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8
    val result = solution.searchRange(nums, target)
    println("The first and last position of $target in the array is: ${result.joinToString(", ")}")
}