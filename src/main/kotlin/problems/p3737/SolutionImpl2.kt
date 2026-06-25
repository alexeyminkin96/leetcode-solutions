package problems.p3737

/**
 * **LeetCode Performance:**
 * - Runtime: `25 ms` (Beats `68.20%` of Kotlin submissions)
 * - Memory: `50.46 MB` (Beats `30.65%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-subarrays-with-majority-element-i/solutions/8382808/kotlin-on2-25ms-o1-by-alexeyminkin-iua0)
 */
class SolutionImpl2 : Solution {
    override fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        var res = 0
        for (l in 0 until nums.size) {
            var c = 0
            for (r in l until nums.size)
                if ((if (nums[r] == target) ++c else --c) > 0) res++
        }
        return res
    }
}