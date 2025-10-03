package problems.p0016

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%`)
 * - Memory: `43.28 MB` (Beats `99.68%`)
 *
 * **Complexity:**
 * - Time: O(n^2)
 * - Space: O(1)
 *
 * **Approach:**
 * - Sort array
 * - Fix index `i`, skip duplicates
 * - Pre-check minSum and maxSum for pruning
 * - Use two pointers `left` and `right` to adjust towards target
 * - Track `closestSum` and minimal `closestDiff`
 *
 * **Techniques:**
 * - Sorting
 * - Two Pointers
 * - Duplicate skipping
 * - Early pruning
 *
 * **Notes:**
 * - Math.abs faster (JVM intrinsic)
 * - Arrays.sort() faster than nums.sort()
 * - Stores diff to avoid recompute
 */
class SolutionImpl1 : Solution {
    override fun threeSumClosest(nums: IntArray, target: Int): Int {
        Arrays.sort(nums)

        var closestSum = nums[0] + nums[1] + nums[2]
        var closestDiff = Math.abs(closestSum - target)

        var leftIndex: Int
        var rightIndex: Int
        var sum: Int
        var currentDiff: Int

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            leftIndex = i + 1
            rightIndex = nums.size - 1

            sum = nums[i] + nums[leftIndex] + nums[leftIndex + 1]
            if (sum >= target) {
                if (sum - target < closestDiff) closestSum = sum
                return closestSum
            }

            sum = nums[i] + nums[rightIndex - 1] + nums[rightIndex]
            if (sum <= target) {
                closestDiff = target - sum
                closestSum = sum
                continue
            }

            while (leftIndex < rightIndex) {
                sum = nums[i] + nums[leftIndex] + nums[rightIndex]
                currentDiff = Math.abs(sum - target)
                if (currentDiff < closestDiff) {
                    closestDiff = currentDiff
                    closestSum = sum
                }
                when {
                    sum < target -> do leftIndex++ while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1])
                    sum > target -> do rightIndex-- while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                    sum == target -> return sum
                }
            }
        }
        return closestSum
    }
}