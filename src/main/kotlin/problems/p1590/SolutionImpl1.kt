package problems.p1590

/**
 * **LeetCode Performance:**
 * - Runtime: `30 ms` (Beats `80.00%` of Kotlin submissions)
 * - Memory: `68.91 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun minSubarray(nums: IntArray, p: Int): Int {
        var sumArray = 0L
        for (i in 0 until nums.size) {
            sumArray += nums[i]
        }
        val rem = (sumArray % p).toInt()
        if (rem == 0) return 0

        var minLength = nums.size
        var sum = 0
        val remToInd = HashMap<Int, Int>()
        remToInd[0] = -1

        for (i in 0 until nums.size) {
            sum = (sum + nums[i]) % p
            val prevRem = (sum - rem + p) % p
            val prevRemInd = remToInd[prevRem]
            if (prevRemInd != null)
                minLength = minOf(minLength, i - prevRemInd)
            remToInd[sum] = i
        }

        if (minLength == nums.size)
            minLength = -1

        return minLength
    }
}
