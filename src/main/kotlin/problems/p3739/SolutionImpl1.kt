package problems.p3739

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `98.06%` of Kotlin submissions)
 * - Memory: `68.74 MB` (Beats `87.74%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val n = nums.size
        val offset = n + 1
        val cnt = IntArray((n shl 1) + 3)
        var pref = 0
        var less = 0L
        var res = 0L
        cnt[offset] = 1
        for (i in 0 until n) {
            if (nums[i] == target) less += cnt[offset + pref++] else less -= cnt[offset + --pref]
            res += less
            cnt[offset + pref]++
        }
        return res
    }
}