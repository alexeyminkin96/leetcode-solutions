package problems.p2161

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `92.75%` of Kotlin submissions)
 * - Memory: `64.90 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/partition-array-according-to-given-pivot/solutions/8366308/kotlin-on-5ms-o1-by-alexeyminkin-13tc)
 */
class SolutionImpl1 : Solution {
    override fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val res = IntArray(nums.size)
        var j = 0
        for (num in nums) if (num < pivot) res[j++] = num
        for (num in nums) if (num == pivot) res[j++] = num
        for (num in nums) if (num > pivot) res[j++] = num
        return res
    }
}