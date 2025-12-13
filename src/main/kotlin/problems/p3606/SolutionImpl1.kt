package problems.p3606

/**
 * **LeetCode Performance:**
 * - Runtime: `62 ms` (Beats `50.00%` of Kotlin submissions)
 * - Memory: `51.02 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(e·log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/coupon-code-validator/solutions/7410608/kotlin-onlogn-62ms-on-by-alexeyminkin-xvea)
 */
class SolutionImpl1 : Solution {
    private val validBL = setOf("electronics", "grocery", "pharmacy", "restaurant")
    private val regexCode = Regex("^[A-Za-z0-9_]+$")
    private val comparator = compareBy<Pair<String, String>>({ it.second }, { it.first })

    override fun validateCoupons(
        code: Array<String>,
        businessLine: Array<String>,
        isActive: BooleanArray
    ): List<String> {
        return code
            .zip(businessLine)
            .filterIndexed { i, (c, bl) -> isActive[i] && validBL.contains(bl) && regexCode.matches(c) }
            .sortedWith(comparator)
            .map { it.first }
    }
}
