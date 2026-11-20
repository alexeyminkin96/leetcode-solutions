package problems.p3041

/**
 * **LeetCode Performance:**
 * - Runtime: `20 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `81.63 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + C)`, C = max(nums) - min(nums)
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/solutions/8618976/kotlin-onc-20ms-oc-by-alexeyminkin-xrqj)
 */
class SolutionImpl1 : Solution {
    override fun maxSelectedElements(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[0]
        for (num in nums)
            if (num < min) min = num
            else if (num > max) max = num
        val sort = IntArray(max - min + 1)
        for (num in nums) sort[num - min]++
        var lastZero = -1
        var start = -1
        var hasDouble = false
        var res = 0
        for (i in 0 until sort.size) {
            if (sort[i] == 0) {
                if (!hasDouble) {
                    res = Math.max(res, i - start - 1)
                    start = lastZero + 1
                } else hasDouble = false
                lastZero = i
            } else if (sort[i] > 1) hasDouble = true
        }
        return Math.max(res, sort.size - start - if (!hasDouble) 1 else 0)
    }
}