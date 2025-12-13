package problems.p3606

import java.util.Collections

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.11 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(e·log n)`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    override fun validateCoupons(
        code: Array<String>,
        businessLine: Array<String>,
        isActive: BooleanArray
    ): List<String> {
        val codesByBLs = Array(4) { ArrayList<String>() }

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
            codesByBLs[index].add(code[i])
        }

        val result = ArrayList<String>()

        for (i in 0 until 4) {
            Collections.sort(codesByBLs[i])
            result.addAll(codesByBLs[i])
        }

        return result
    }
}
