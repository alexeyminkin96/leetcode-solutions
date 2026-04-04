package problems.p2075

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `59.72 MB` (Beats `11.11%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/decode-the-slanted-ciphertext/solutions/7773238/kotlin-on-8ms-on-by-alexeyminkin-3pmi)
 */
class SolutionImpl1 : Solution {
    override fun decodeCiphertext(encodedText: String, rows: Int): String {
        val n = encodedText.length
        if (n == 0) return encodedText
        val encodedText = encodedText.toCharArray()
        val cols = n / rows
        val res = CharArray((cols - rows + 2) * rows - 1)
        var resIdx = 0
        for (i in 0 until cols - rows + 2) {
            var j = i
            while (j < n) {
                res[resIdx++] = encodedText[j]
                j += cols + 1
            }
        }
        while (res[resIdx - 1] == ' ') resIdx--
        return String(res, 0, resIdx )
    }
}