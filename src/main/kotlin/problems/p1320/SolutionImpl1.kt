package problems.p1320

class SolutionImpl1 : Solution {
    override fun minimumDistance(word: String): Int {
        val chars = 26
        val rowLength = 6
        val n = word.length
        val word = word.toCharArray()
        val dp = Array(chars) { Array(chars) { IntArray(n + 1) { if (it == 0) 0 else 10_000 } } }
        for (k in 0 until n) {
            val char = word[k] - 'A'
            val row = char / rowLength
            val col = char - row * rowLength
            for (i in 0 until chars) {
                val iRow = i / rowLength
                val iCol = i - iRow * rowLength
                for (j in 0 until chars) {
                    val jRow = j / rowLength
                    val jCol = j - jRow * rowLength

                    val iPath = Math.abs(row - iRow) + Math.abs(col - iCol) + dp[i][j][k]
                    dp[char][j][k + 1] = Math.min(dp[char][j][k + 1], iPath)

                    val jPath = Math.abs(row - jRow) + Math.abs(col - jCol) + dp[i][j][k]
                    dp[i][char][k + 1] = Math.min(dp[i][char][k + 1], jPath)
                }
            }
        }
        var res = 10_000
        for (i in 0 until chars)
            for (j in 0 until chars)
                res = Math.min(res, dp[i][j][n])
        return res
    }
}