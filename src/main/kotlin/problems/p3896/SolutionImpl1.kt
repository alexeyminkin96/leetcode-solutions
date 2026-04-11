package problems.p3896

/**
 * **LeetCode Performance:**
 * - Runtime: `26 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `68.23 MB` (Beats `95.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + C log log C)` C - 100_000
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/solutions/7875088/kotlin-on-cloglogc-26ms-oc-by-alexeymink-v5zv)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(nums: IntArray): Int {
        var res = 0
        for (i in 0 until nums.size) {
            val l = np[nums[i]] - nums[i]
            if (i and 1 == 0) res += l
            else if (nums[i] == 2) res += 2
            else if (l == 0) res++
        }
        return res
    }

    companion object {
        private const val PRIME = 100_003    // closest prime after 100_000
        val np = IntArray(100_001)      // next prime

        init {
            np[1] = -1
            for (i in 2 until np.size / 2)
                if (np[i] != -1)
                    for (j in i shl 1 until np.size step i)
                        np[j] = -1
            np[np.size - 1] = PRIME
            for (i in np.size - 2 downTo 1)
                np[i] = if (np[i] == -1) np[i + 1] else i
        }
    }
}