package dev.erad.leetcode.medium.boats_to_save_people

// https://leetcode.com/problems/boats-to-save-people/description/
// Time complexity: O(nlogn)
// Space complexity: O(1)
// Why time complexity is O(nlogn)? Because we sort the array of people.
// Why space complexity is O(1)? Because we are not using any extra space that grows with the input size.

class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var heavyP = people.size - 1
        var lightP = 0
        var boats = 0
        while (heavyP >= lightP) {
            if (people[heavyP] + people[lightP] <= limit) {
                boats += 1
                heavyP -= 1
                lightP += 1
            } else {
                boats += 1
                heavyP -= 1
            }
        }

        return boats
    }
}

fun main() {
    val solution = Solution()
    val people = intArrayOf(3, 2, 2, 1)
    val limit = 3
    val boats = solution.numRescueBoats(people, limit)
    println("The number of boats is: $boats")
}