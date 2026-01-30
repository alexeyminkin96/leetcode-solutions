package problems.p2977

/**
 * **LeetCode Performance:**
 * - Runtime: `259 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `68.50 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^3)`
 * - Space: `O(n^2)`
 */
class SolutionImpl2 : Solution {
    private val INF = Long.MAX_VALUE / 4
    override fun minimumCost(
        source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray
    ): Long {
        val n = source.length
        val dp = LongArray(n + 1) { INF }
        dp[n] = 0
        val ls = original
            .zip(changed)
            .zip(cost.toTypedArray())
            .groupBy({ it.first }, { it.second })
            .map { Triple(it.key.first, it.key.second, it.value.min()) }
            .plus(Triple("a", "a", 0))
            .groupBy { it.first.length }
            .map { (l, rules) ->
                val strId = rules
                    .flatMap { listOf(it.first, it.second) }
                    .distinct()
                    .mapIndexed { i, tr -> Pair(tr, i) }
                    .associate { it }
                val dist = Array(strId.size) { i -> LongArray(strId.size) { j -> if (i == j) 0 else INF } }
                    .addRules(rules, strId)
                    .warshall()
                Triple(l, dist, strId)
            }

        for (i in n - 1 downTo 0) {
            for ((l, dist, strs) in ls) {
                if (i + l > n) continue
                val subSource = source.substring(i, i + l)
                val subTarget = target.substring(i, i + l)
                val w = if (subSource == subTarget) 0
                else dist[strs[subSource] ?: continue][strs[subTarget] ?: continue]
                dp[i] = minOf(dp[i], w + dp[i + l])
            }
        }
        return if (dp[0] != INF) dp[0] else -1L
    }

    private fun Array<LongArray>.addRules(
        rules: List<Triple<String, String, Int>>,
        strId: Map<String, Int>
    ): Array<LongArray> {
        for ((from, to, w) in rules) {
            val i = strId[from]!!
            val j = strId[to]!!
            this[i][j] = minOf(this[i][j], w.toLong())
        }
        return this
    }

    private fun Array<LongArray>.warshall(): Array<LongArray> {
        for (k in indices) for (i in indices) for (j in indices)
            this[i][j] = minOf(this[i][j], this[i][k] + this[k][j])
        return this
    }
}