package problems.p3666

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.84 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minOperations(s: String, k: Int): Int {
        val n = s.length
        var o = 0
        for (c in s.toCharArray()) o += c - '0'
        val z = n - o

        if (z == 0) return 0
        if (k == n) return if (z == n) 1 else -1
        if (k and 1 == 0 && z and 1 == 1) return -1

        fun ceil(a: Int, b: Int) = (a + b - 1) / b
        fun toParity(a: Int, p: Int) = if (a and 1 == p) a else a + 1

        val min = ceil(z, k)
        val minEven = toParity(Math.max(min, ceil(z, n - k)), 0)
        val minOdd = toParity(Math.max(min, ceil(o, n - k)), 1)

        return if (k and 1 == 1)
            if (z and 1 == 1) minOdd else minEven
        else Math.min(minOdd, minEven)
    }
}