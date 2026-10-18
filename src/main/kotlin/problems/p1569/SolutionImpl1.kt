package problems.p1569

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.73 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(n²)`
 */
class SolutionImpl1 : Solution {
    override fun numOfWays(nums: IntArray): Int {
        return (dfs(nums) - 1 + mod) % mod
    }

    private fun dfs(nums: IntArray): Int {
        val n = nums.size
        if (n <= 1) return 1
        val root = nums[0]
        var lSize = 0
        var rSize = 0
        for (i in 1 until n)
            if (nums[i] < root) lSize++ else rSize++
        val leftNums = IntArray(lSize)
        var leftI = 0
        val rightNums = IntArray(rSize)
        var rightI = 0
        for (i in 1 until n)
            if (nums[i] < root) leftNums[leftI++] = nums[i] else rightNums[rightI++] = nums[i]
        return (pask[n - 1][lSize].toLong() * dfs(leftNums) % mod * dfs(rightNums) % mod).toInt()
    }
}

private const val mod = 1_000_000_007
private val pask = run {
    val pask = Array(1001) { IntArray(1001) }
    for (i in 0 until 1001) {
        pask[i][0] = 1
        pask[i][i] = 1
        for (j in 1 until i)
            pask[i][j] = (pask[i - 1][j - 1] + pask[i - 1][j]) % mod
    }
    pask
}