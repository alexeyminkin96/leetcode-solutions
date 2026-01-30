package problems.p2977

/**
 * **LeetCode Performance:**
 * - Runtime: `220 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `67.35 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^3)`
 * - Space: `O(n^2)`
 */
class SolutionImpl1 : Solution {
    override fun minimumCost(
        source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray
    ): Long {

        val rules = HashMap<Int, MutableList<Triple<String, String, Int>>>()

        for (i in 0 until original.size) {
            val length = original[i].length
            var list = rules[length]
            if (list == null) {
                list = ArrayList()
                rules[length] = list
            }
            list.add(Triple(original[i], changed[i], cost[i]))
        }

        val ls = ArrayList<L>()

        for ((l, r) in rules) {
            val strs = r
                .flatMap { listOf(it.first, it.second) }
                .distinct()
                .mapIndexed { i, str -> Pair(str, i) }
                .associate { it }
            val size = strs.size
            val dist = Array(size) { i -> LongArray(size) { j -> if (i == j) 0 else Long.MAX_VALUE } }
            for (rr in r) {
                val i = strs[rr.first]!!
                val j = strs[rr.second]!!
                val w = rr.third
                if (w < dist[i][j]) dist[i][j] = w.toLong()
            }

            for (k in 0 until size) {
                for (i in 0 until size) {
                    val ik = dist[i][k]
                    if (ik == Long.MAX_VALUE) continue
                    for (j in 0 until size) {
                        val kj = dist[k][j]
                        if (kj == Long.MAX_VALUE) continue
                        if (ik + kj < dist[i][j]) dist[i][j] = ik + kj
                    }
                }
            }
            ls.add(L(l, dist, strs))
        }

        val s = source.toCharArray()
        val t = target.toCharArray()
        val n = s.size

        val dp = LongArray(n + 1) { Long.MAX_VALUE }
        dp[n] = 0

        outer@ for (i in n - 1 downTo 0) {
            if (s[i] == t[i]) dp[i] = minOf(dp[i], dp[i + 1])
            inner@ for (ll in ls) {
                val l = ll.l
                if (i + l > n) continue@inner
                val ss = source.substring(i, i + l)
                val tt = target.substring(i, i + l)
                if (ss == tt) {
                    dp[i] = minOf(dp[i], dp[i + l])
                } else {
                    val sss = ll.strs[ss] ?: continue@inner
                    val ttt = ll.strs[tt] ?: continue@inner
                    val w = ll.dist[sss][ttt]
                    if (w == Long.MAX_VALUE) continue@inner
                    if (dp[i + l] == Long.MAX_VALUE) continue@inner
                    dp[i] = minOf(dp[i], w + dp[i + l])

                }
            }
        }
        return if (dp[0] != Long.MAX_VALUE) dp[0] else -1L
    }

    class L(
        val l: Int,
        val dist: Array<LongArray>,
        val strs: Map<String, Int>
    )
}