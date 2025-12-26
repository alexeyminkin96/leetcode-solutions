package problems.p2483

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-penalty-for-a-shop/solutions/7440379/kotlin-on-5ms-o1-exactly-one-pass-by-ale-tcyr)
 */
class SolutionImpl1 : Solution {
    override fun bestClosingTime(customers: String): Int {
        val charArray = customers.toCharArray()
        var curPenalty = 0
        var minPenalty = 0
        var resultHour = 0

        for (i in 0 until charArray.size) {
            if (charArray[i] == 'N') curPenalty++
            else if (--curPenalty < minPenalty) {
                minPenalty = curPenalty
                resultHour = i + 1
            }
        }

        return resultHour
    }
}