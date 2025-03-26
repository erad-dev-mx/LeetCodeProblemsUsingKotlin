package dev.erad.leetcode.easy.valid_mountain_array

// https://leetcode.com/problems/valid-mountain-array/description/

// Time complexity: O(n)
// Space complexity: O(1)
// Why is time complexity 0(n)? Because we are using a single loop that iterates over the input array.
// Why is space complexity o(1)? Because we are not using any extra space that grows with the input size.

class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3)
            return false
        var i = 1
        while (i < arr.size && arr[i] > arr[i - 1]) {
            i += 1
        }
        if (i == 1 || i == arr.size)
            return false
        while (i < arr.size && arr[i] < arr[i - 1])
            i += 1
        return (i == arr.size)
    }
}

fun main() {
    val solution = Solution()
    val array = intArrayOf(0, 3, 2, 1)
    val validMountainArray = solution.validMountainArray(array)
    println("Is the array a valid mountain array $validMountainArray")
}