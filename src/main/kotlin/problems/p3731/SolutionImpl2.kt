package problems.p3731

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`, m = max(nums) - min(nums)
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-missing-elements/solutions/8440239/kotlin-on-m-1ms-om-by-alexeyminkin-r2cv)
 */
class SolutionImpl2 : Solution {
    override fun findMissingElements(nums: IntArray): IntArray {
        var min = 100
        var max = 0
        for (num in nums) {
            min = Math.min(min, num)
            max = Math.max(max, num)
        }
        val sort = BooleanArray(max - min + 1)
        for (num in nums) sort[num - min] = true
        val res = IntArray(max - min + 1 - nums.size)
        var i = 0
        for (l in min + 1 until max) if (!sort[l - min]) res[i++] = l
        return res
    }
}