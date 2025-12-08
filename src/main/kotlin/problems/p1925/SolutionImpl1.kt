package problems.p1925

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `50.00%` of Kotlin submissions)
 * - Memory: `40.65 MB` (Beats `--%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun countTriples(n: Int): Int {
        val squareN = n * n
        var result = 0
        for (a in 1..n) {
            val squareA = (a * a).toDouble()
            for (b in a + 1..n) {
                val c = Math.sqrt(squareA + b * b)
                if (c > n) break
                if (c % 1 == 0.0) result++
            }
            if (2 * squareA > squareN)
                break
        }
        return result * 2
    }
}