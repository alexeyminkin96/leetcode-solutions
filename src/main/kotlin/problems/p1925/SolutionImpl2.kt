package problems.p1925

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `50.00%` of Kotlin submissions)
 * - Memory: `44.68 MB` (Beats `--%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(n²)`
 */
class SolutionImpl2 : Solution {
    override fun countTriples(n: Int): Int {
        val squareN = n * n
        val squareToNum = IntArray(squareN + 1)
        for (i in 1..n) {
            squareToNum[i * i] = i
        }
        var result = 0
        for (a in 1..n) {
            val squareA = a * a
            if (2 * squareA > squareN) break
            for (b in a + 1..n) {
                val squareC = squareA + b * b
                if (squareC > squareN) break
                if (squareToNum[squareC] != 0)
                    result++
            }
        }
        return result * 2
    }
}
