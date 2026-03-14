package problems.p1415

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.43 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/solutions/7647131/kotlin-on-1ms-o1-without-generating-stri-g8pc)
 */
class SolutionImpl1 : Solution {
    override fun getHappyString(n: Int, k: Int): String {
        var count = 1 shl (n - 1)
        var k = k - 1
        var cur = k / count
        if (cur > 2) return ""
        val result = CharArray(n)
        result[0] = 'a' + cur
        for (i in 1 until n) {
            k -= cur * count
            count = count shr 1
            cur = k / count
            result[i] = when (result[i - 1]) {
                'a' -> if (cur == 0) 'b' else 'c'
                'b' -> if (cur == 0) 'a' else 'c'
                else -> if (cur == 0) 'a' else 'b'
            }
        }
        return String(result)
    }
}