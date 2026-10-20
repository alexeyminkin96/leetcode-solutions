package problems.p3886

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `89.59 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-of-sortable-integers/solutions/8580788/kotlin-onlogn-16ms-on-by-alexeyminkin-iixj)
 */
class SolutionImpl3 : Solution {
    override fun sortableIntegers(nums: IntArray): Int {
        val n = nums.size
        val correctBorder = getCorrectBorder(nums)
        val psDec = getPsDec(nums)
        var res = 0
        divider@ for (k in 1..n) {
            if (n % k != 0) continue@divider
            for (part in 0 until n / k) {
                val l = part * k
                val r = (part + 1) * k - 1
                if (!correctBorder[l]) continue@divider
                if ((psDec[r] - psDec[l] + if (nums[r] > nums[l]) 1 else 0) > 1) continue@divider
            }
            res += k
        }
        return res
    }

    private fun getCorrectBorder(nums: IntArray): BooleanArray {
        val maxLefter = IntArray(nums.size)
        var max = 0
        for (i in 0 until nums.size) {
            maxLefter[i] = max
            max = Math.max(max, nums[i])
        }
        val correctBorder = BooleanArray(nums.size)
        var min = Int.MAX_VALUE
        for (i in nums.size - 1 downTo 0) {
            min = Math.min(min, nums[i])
            correctBorder[i] = maxLefter[i] <= min
        }
        return correctBorder
    }

    private fun getPsDec(nums: IntArray): IntArray {
        val psDec = IntArray(nums.size)
        for (i in 1 until nums.size)
            psDec[i] = psDec[i - 1] + if (nums[i] < nums[i - 1]) 1 else 0
        return psDec
    }
}