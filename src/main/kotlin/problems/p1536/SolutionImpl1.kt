package problems.p1536

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `57.56 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/solutions/7619338/kotlin-on2-2ms-on-early-break-bubble-sor-vozh)
 */
class SolutionImpl1 : Solution {
    override fun minSwaps(grid: Array<IntArray>): Int {
        val n = grid.size
        val zerosPerRow = IntArray(n)
        val countPerZeros = IntArray(n + 1)

        for (i in 0 until n) {
            var j = n - 1
            while (j >= 0 && grid[i][j] == 0) j--
            zerosPerRow[i] = n - j - 1
            countPerZeros[zerosPerRow[i]]++
        }

        var cumulative = countPerZeros[n]
        for (i in n - 1 downTo 1) {
            cumulative += countPerZeros[i] - 1
            if (cumulative < 0) return -1
        }

        var count = 0
        for (i in 0 until n) {
            val needZeros = n - i - 1
            var cur = zerosPerRow[i]
            var j = i
            while (cur < needZeros) {
                val buf = zerosPerRow[++j]
                zerosPerRow[j] = cur
                cur = buf
            }
            count += j - i
            zerosPerRow[i] = cur
        }
        return count
    }
}