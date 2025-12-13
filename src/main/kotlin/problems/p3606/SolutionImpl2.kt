package problems.p3606

import java.util.Collections

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.84 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(e·log n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    private val validBL = HashMap<String, Int>()
    private val validCode = BooleanArray(123)

    init {
        validBL["electronics"] = 0
        validBL["grocery"] = 1
        validBL["pharmacy"] = 2
        validBL["restaurant"] = 3

        for (i in 0..122) {
            validCode[i] = (i == 95 || i in 48..57 || i in 65..90 || i in 97..122)
        }
    }

    override fun validateCoupons(
        code: Array<String>,
        businessLine: Array<String>,
        isActive: BooleanArray
    ): List<String> {
        val codesByBLs = Array(validBL.size) { ArrayList<String>() }

        outer@ for (i in 0 until code.size) {
            if (!isActive[i] || code[i].length == 0) continue
            val index = validBL[businessLine[i]] ?: continue
            for (c in code[i]) {
                if (c.code >= validCode.size || !validCode[c.code]) continue@outer
            }
            codesByBLs[index].add(code[i])
        }

        val result = ArrayList<String>()

        for (i in 0 until validBL.size) {
            Collections.sort(codesByBLs[i])
            result.addAll(codesByBLs[i])
        }

        return result
    }
}
