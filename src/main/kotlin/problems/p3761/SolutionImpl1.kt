package problems.p3761

/**
 * **LeetCode Performance:**
 * - Runtime: `28 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * D)` D=10
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/solutions/7956360/kotlin-ond-28ms-on-by-alexeyminkin-bndv)
 */
class SolutionImpl1 : Solution {
    override fun minMirrorPairDistance(nums: IntArray): Int {
        var res = Int.MAX_VALUE
        val map = HashMap<Int, Int>(nums.size shl 1)
        for (i in 0 until nums.size) {
            var num = nums[i]
            val revI = map[num]
            if (revI != null)
                res = Math.min(res, i - revI)
            var rev = 0
            while (num != 0) {
                val n = num / 10
                rev = 10 * rev + num - 10 * n
                num = n
            }
            map[rev] = i
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}