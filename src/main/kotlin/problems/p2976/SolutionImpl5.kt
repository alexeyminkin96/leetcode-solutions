package problems.p2976

/**
 * **LeetCode Performance:**
 * - Runtime: `17 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `51.89 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + C^3 + n)`
 * - Space: `O(C^2)`
 */
class SolutionImpl5 : Solution {
    override fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        val bestWeights = Array(26) { i -> IntArray(26) { j -> if (i == j) 0 else Int.MAX_VALUE } }

        for (i in 0 until original.size) {
            val bd = bestWeights[original[i] - 'a'][changed[i] - 'a']
            if (bd > cost[i]) bestWeights[original[i] - 'a'][changed[i] - 'a'] = cost[i]
        }

        for (k in 0 until 26) {
            for (i in 0 until 26) {
                val ik = bestWeights[i][k]
                if (ik == Int.MAX_VALUE) continue
                for (j in 0 until 26) {
                    val kj = bestWeights[k][j]
                    if (kj == Int.MAX_VALUE) continue
                    if (ik + kj < bestWeights[i][j]) bestWeights[i][j] = ik + kj
                }
            }
        }

        val s = source.toCharArray()
        val t = target.toCharArray()

        var allWeight = 0L
        for (i in 0 until s.size) {
            val w = bestWeights[s[i] - 'a'][t[i] - 'a']
            if (w == Int.MAX_VALUE) return -1
            allWeight += w
        }
        return allWeight
    }
}
