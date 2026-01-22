package problems.p3507

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.67 MB` (Beats `85.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minimumPairRemoval(nums: IntArray): Int {
        var result = 0
        var isSorted = false
        while (!isSorted) {
            isSorted = true
            var minSum = Int.MAX_VALUE
            var minSumL = 0
            var minSumR = 0
            var prevInd = 0
            for (i in 1 until nums.size) {
                if (nums[i] == Int.MIN_VALUE) continue
                if (nums[prevInd] > nums[i]) isSorted = false
                if (nums[prevInd] + nums[i] < minSum) {
                    minSum = nums[prevInd] + nums[i]
                    minSumL = prevInd
                    minSumR = i
                }
                prevInd = i
            }
            if (!isSorted) {
                nums[minSumL] = minSum
                nums[minSumR] = Int.MIN_VALUE
                result++
            }
        }
        return result
    }
}