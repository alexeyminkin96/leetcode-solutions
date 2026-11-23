package problems.p1352

/**
 * **LeetCode Performance**
 * - Runtime: `38 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `108.85 MB` (Beats `20.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/product-of-the-last-k-numbers/solutions/8622273/kotlin-o1-38ms-o1-by-alexeyminkin-zvy6)
 */
class SolutionImpl3 : Solution {
    private var allCount = 0
    private var non1Count = 0
    private val ps = IntArray(32) { 1 }
    private val counts = IntArray(32)

    override fun add(num: Int) {
        when (num) {
            0 -> {
                allCount = 0
                non1Count = 0
            }

            1 -> allCount++
            else -> {
                ps[++non1Count] = ps[non1Count - 1] * num
                counts[non1Count] = ++allCount
            }
        }
    }

    override fun getProduct(k: Int): Int {
        if (allCount < k) return 0
        var i = non1Count
        while (i > 0 && counts[i] > allCount - k) i--
        return ps[non1Count] / ps[i]
    }
}