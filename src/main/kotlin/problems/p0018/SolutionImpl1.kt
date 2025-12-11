package problems.p0018

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `94.74%` of Kotlin submissions)
 * - Memory: `46.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^3)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/4sum/solutions/7407568/kotlin-on3-21ms-o1-by-alexeyminkin-a24n)
 */
class SolutionImpl1 : Solution {
    override fun fourSum(nums: IntArray, target: Int): List<IntArray> {
        Arrays.sort(nums)
        val targetLong = target.toLong()
        val result = ArrayList<IntArray>()
        for (i in 0 until nums.size - 3) {
            if (i > 0 && nums[i - 1] == nums[i]) continue
            val numsI = nums[i].toLong()
            if (numsI + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break
            for (j in i + 1 until nums.size - 2) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue
                if (numsI + nums[j] + nums[j + 1] + nums[j + 2] > target) break
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = numsI + nums[j] + nums[left] + nums[right]
                    if (sum == targetLong)
                        result.add(intArrayOf(nums[i], nums[j], nums[left], nums[right]))
                    if (sum <= targetLong)
                        do left++ while (left < right && nums[left - 1] == nums[left])
                    if (sum >= targetLong)
                        do right-- while (left < right && nums[right] == nums[right + 1])
                }
            }
        }
        return result
    }
}