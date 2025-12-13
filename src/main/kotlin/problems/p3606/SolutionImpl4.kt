package problems.p3606

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(e·log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/coupon-code-validator/solutions/7410578/kotlin-onlogn-6ms-on-by-alexeyminkin-3mft)
 */
class SolutionImpl4 {
    fun validateCoupons(
        code: Array<String>,
        businessLine: Array<String>,
        isActive: BooleanArray
    ): Array<String?> {
        val codesByBLs = Array(4) { arrayOfNulls<String>(100) }
        val indexes = IntArray(4)

        var resultCount = 0

        outer@ for (i in 0 until code.size) {
            if (!isActive[i] || code[i].length == 0) continue
            val index = when (businessLine[i]) {
                "electronics" -> 0
                "grocery" -> 1
                "pharmacy" -> 2
                "restaurant" -> 3
                else -> continue
            }
            for (c in code[i]) {
                if (!(c.code == 95 || c.code in 48..57 || c.code in 65..90 || c.code in 97..122))
                    continue@outer
            }
            codesByBLs[index][indexes[index]++] = code[i]
            resultCount++
        }

        val result = arrayOfNulls<String>(resultCount)
        var resultIndex = 0

        for (i in 0 until 4) {
            Arrays.sort(codesByBLs[i], 0, indexes[i])
            System.arraycopy(codesByBLs[i], 0, result, resultIndex, indexes[i])
            resultIndex += indexes[i]
        }

        return result
    }
}
