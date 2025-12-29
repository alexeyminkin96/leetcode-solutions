package problems.p0756

/**
 * **LeetCode Performance:**
 * - Runtime: `53 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `52.88 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(6^(n^2))`
 * - Space: `O(6^n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/pyramid-transition-matrix/solutions/7448359/kotlin-o6n2-53ms-o6n-by-alexeyminkin-bxzb)
 */
class SolutionImpl3 : Solution {
    private fun key(l: Int, r: Int): Int = (l shl 3) or r
    private fun int(char: Char): Int = char - 'A' + 1
    override fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val length = bottom.length
        val baseToTop = HashMap<Int, MutableList<Int>>()
        for (i in 0 until allowed.size) {
            val key = key(int(allowed[i][0]), int(allowed[i][1]))
            baseToTop.getOrPut(key) { ArrayList() }
                .add(int(allowed[i][2]))
        }
        val pyramid = Array(length + 1) { IntArray(it) }
        for (i in 0 until length)
            pyramid[length][i] = int(bottom[i])
        val cache = HashMap<Int, Boolean>()

        fun pyramidTransition(rowNum: Int, chCount: Int): Boolean {
            val row = pyramid[rowNum]
            val nextRow = pyramid[rowNum - 1]
            if (chCount == nextRow.size) {
                if (nextRow.size == 1) return true
                var cacheKey = 0
                for (i in 0 until nextRow.size) cacheKey = key(cacheKey, nextRow[i])
                return cache.getOrPut(cacheKey) { pyramidTransition(nextRow.size, 0) }
            }
            val baseKey = key(row[chCount], row[chCount + 1])
            val tops = baseToTop[baseKey] ?: return false
            for (top in tops) {
                nextRow[chCount] = top
                if (pyramidTransition(rowNum, chCount + 1))
                    return true
            }
            return false
        }

        return pyramidTransition(length, 0)
    }
}
