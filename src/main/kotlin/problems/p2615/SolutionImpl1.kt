package problems.p2615

/**
 * **LeetCode Performance:**
 * - Runtime: `17 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `78.84 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-of-distances/solutions/8067243/kotlin-on-17ms-on-one-map-by-alexeyminki-jo6n)
 */
class SolutionImpl1 : Solution {
    override fun distance(nums: IntArray): LongArray {
        val n = nums.size
        val res = LongArray(n)
        val numToSC = HashMap<Int, SC>()
        fun dist(i: Int, num: Int) {
            var sc = numToSC[num]
            if (sc == null) {
                sc = SC()
                numToSC[num] = sc
            }
            res[i] += Math.abs(sc.sum - i * sc.count)
            sc.sum += i
            sc.count++
        }
        for (i in 0 until n) {
            dist(i, nums[i])
            dist(n - 1 - i, -nums[n - 1 - i] - 1)
        }
        return res
    }

    private data class SC(
        var sum: Long = 0,
        var count: Long = 0
    )
}