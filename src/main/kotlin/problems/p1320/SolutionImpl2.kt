package problems.p1320

/**
 * **LeetCode Performance:**
 * - Runtime: `37 ms` (Beats `66.67%` of Kotlin submissions)
 * - Memory: `48.03 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * 26 * 26)`
 * - Space: `O(n * 26 * 26)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/solutions/7892108/kotlin-onc2-37ms-onc2-3d-dp-by-alexeymin-ayct)
 */
class SolutionImpl2 : Solution {
    override fun minimumDistance(word: String): Int {
        val chars = 26
        val rowLength = 6
        val n = word.length
        val word = word.toCharArray()
        val dp = Array(n + 1) { k -> Array(chars) { IntArray(chars) { if (k == 0) 0 else 10_000 } } }
        for (k in 0 until n) {
            val char = word[k] - 'A'
            val curLength = dp[k]
            val nextLength = dp[k + 1]
            val row = char / rowLength
            val col = char - row * rowLength
            val leftHand = nextLength[char]
            for (i in 0 until chars) {
                val rightHand = nextLength[i]
                val iRow = i / rowLength
                val iPath = Math.abs(row - iRow) + Math.abs(col - (i - iRow * rowLength))
                for (j in 0 until chars) {
                    val jRow = j / rowLength
                    val jPath = Math.abs(row - jRow) + Math.abs(col - (j - jRow * rowLength))

                    leftHand[j] = Math.min(leftHand[j], iPath + curLength[i][j])
                    rightHand[char] = Math.min(rightHand[char], jPath + curLength[i][j])
                }
            }
        }
        var res = 10_000
        val last = dp[n]
        for (i in 0 until chars)
            for (j in 0 until chars)
                res = Math.min(res, last[i][j])
        return res
    }
}