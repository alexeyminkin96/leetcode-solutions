package problems.p0015

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `32 ms` (Beats `100.00%`)
 * - Memory: `65.61 MB` (Beats `86.30%`)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Sort array
 * - Fix each number `i`
 * - Skip duplicates
 * - If `nums[i] > 0` → break
 * - Use two pointers (`left`, `right`) to find pairs
 * - Adjust pointers by sum
 * - On match → add triplet, skip duplicates
 *
 * **Techniques:**
 * - Sorting
 * - Two pointers
 * - Duplicate skipping
 * - Early break
 *
 * **Notes:**
 * - Small optimization: result uses `List<IntArray>` instead of `List<List<Int>>`.
 *   `IntArray`, it is faster and lighter for the JVM.
 */
class SolutionImpl1 : Solution {
    override fun threeSum(nums: IntArray): List<IntArray> {
        Arrays.sort(nums)

        val result = ArrayList<IntArray>()

        var leftIndex: Int
        var rightIndex: Int
        var sum: Int

        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            leftIndex = i + 1
            rightIndex = nums.size - 1

            while (leftIndex < rightIndex) {
                sum = nums[i] + nums[leftIndex] + nums[rightIndex]
                when {
                    sum < 0 -> leftIndex++
                    sum > 0 -> rightIndex--
                    else -> {
                        result.add(intArrayOf(nums[i], nums[leftIndex], nums[rightIndex]))
                        do leftIndex++
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1])
                        do rightIndex--
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                    }
                }
            }
        }

        return result
    }
}