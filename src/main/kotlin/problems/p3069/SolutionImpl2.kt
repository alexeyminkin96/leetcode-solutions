package problems.p3069

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.91 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/solutions/8472194/kotlin-on-1ms-o1-by-alexeyminkin-r3d5)
 */
class SolutionImpl2 : Solution {
    override fun resultArray(nums: IntArray): IntArray {
        val n = nums.size
        var arr1I = 0
        var arr2I = 0
        var lastArr1 = 102
        var lastArr2 = 101
        for (num in nums)
            if (lastArr1 > lastArr2) {
                lastArr1 = num
                arr2I++
            } else lastArr2 = num
        lastArr1 = 102
        lastArr2 = 101
        for (num in nums)
            if (lastArr1 > lastArr2) {
                lastArr1 = num and 127
                nums[arr1I] = nums[arr1I++] or ((num and 127) shl 7)
            } else {
                lastArr2 = num and 127
                nums[arr2I] = nums[arr2I++] or ((num and 127) shl 7)
            }
        for (i in 0 until n)
            nums[i] = nums[i] shr 7
        return nums
    }
}