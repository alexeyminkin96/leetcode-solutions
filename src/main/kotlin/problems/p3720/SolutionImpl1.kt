package problems.p3720

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.67 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*C)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/solutions/8485627/kotlin-onc-2ms-oc-primitives-only-by-ale-ongi)
 */
class SolutionImpl1 : Solution {
    override fun lexGreaterPermutation(s: String, target: String): String {
        val n = s.length
        val counts = IntArray(26)
        for (c in s.toCharArray()) counts[c - 'a']++
        val res = CharArray(n)
        fun fill(charIdx: Int): Boolean {
            if (charIdx == n) return false
            var charCode = target[charIdx] - 'a'
            if (counts[charCode] > 0) {
                counts[charCode]--
                res[charIdx] = 'a' + charCode
                if (fill(charIdx + 1)) return true
                counts[charCode++]++
            }
            while (charCode < 26 && counts[charCode] == 0) charCode++
            if (charCode == 26) return false
            counts[charCode]--
            res[charIdx] = 'a' + charCode
            var resIdx = charIdx + 1
            for (nextCharCode in 0 until 26)
                for (repeat in 0 until counts[nextCharCode]) res[resIdx++] = 'a' + nextCharCode
            return true
        }
        return if (fill(0)) String(res) else ""
    }
}