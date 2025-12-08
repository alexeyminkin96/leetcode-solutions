package problems.p1925

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-square-sum-triples/solutions/7400385/kotlin-onlogn-0ms-o1-pythagorean-triples-gtec)
 */
class SolutionImpl3 : Solution {
    override fun countTriples(n: Int): Int {
        var result = 0
        var i = 1
        while (++i * i < n) {
            var j = i % 2 + 1
            while (j < i && i * i + j * j <= n) {
                if (gcd(i, j) == 1)
                    result += n / (i * i + j * j)
                j += 2
            }
        }

        return result * 2
    }

    private fun gcd(a: Int, b: Int): Int {
        var varA = Math.abs(a)
        var varB = Math.abs(b)
        while (varB != 0) {
            val rem = varA % varB
            varA = varB
            varB = rem
        }
        return varA
    }
}
