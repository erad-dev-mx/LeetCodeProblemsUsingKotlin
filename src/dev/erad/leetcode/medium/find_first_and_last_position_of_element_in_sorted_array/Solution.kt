package dev.erad.leetcode.medium.find_first_and_last_position_of_element_in_sorted_array

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time complexity: O(log n)
// Space complexity: O(1)
// Why is time complexity O(log n)? Because we are using binary search to find the first and last position of the target element.
// Why is space complexity O(1)? Because we are not using any extra space that grows with the input size.
// This is a binary search approach to find the first and last position of an element in a sorted array.

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        fun findFirst(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1

            while (right >= left) {
                val mid = left + (right - left) / 2
                if (nums[mid] == target) {
                    // If this is the first occurrence of the target, return mid
                    if (mid - 1 < 0 || nums[mid - 1] != target) {
                        return mid
                    }
                    right = mid - 1
                } else if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return -1
        }

        fun findLast(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1

            while (right >= left) {
                val mid = left + (right - left) / 2
                if (nums[mid] == target) {
                    // If this is tha last occurrence of the target, return mid
                    if (mid + 1 >= nums.size || nums[mid + 1] != target) {
                        return mid
                    }
                    left = mid + 1
                } else if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }

            return -1
        }

        val first = findFirst(nums, target)
        val last = findLast(nums, target)

        return intArrayOf(first, last)

    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 7
    val result = solution.searchRange(nums, target)
    println("The first and last position of $target in the array is: ${result.joinToString(", ")}")
}