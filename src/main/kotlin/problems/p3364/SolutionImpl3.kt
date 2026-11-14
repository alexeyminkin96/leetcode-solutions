package problems.p3364

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.63 MB` (Beats `14.29%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * (r - l))`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    override fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val n = nums.size
        val ps = IntArray(n + 1)
        for (i in 0 until n)
            ps[i + 1] = ps[i] + nums[i]
        var res = Int.MAX_VALUE
        for (i in 0..n - l) {
            for (j in i + l..Math.min(i + r, n)) {
                val sum = ps[j] - ps[i]
                if (sum > 0 && sum < res) res = sum
            }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}