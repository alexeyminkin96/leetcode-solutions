package problems.p2976

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `455 ms` (Beats `0.00%` of Kotlin submissions)
 * - Memory: `71.60 MB` (Beats `0.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + min(C^2,n) * ((m + C) log C) + n)`
 * - Space: `O(m + C^2)`
 */
class SolutionImpl2 : Solution {
    override fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        val weights = HashMap<Char, MutableList<Pair<Char, Int>>>()
        for (i in 0 until original.size) {
            val from = original[i]
            val to = changed[i]
            val weight = cost[i]
            var w = weights[from]
            if (w == null) {
                w = ArrayList()
                weights[from] = w
            }
            w.add(Pair(to, weight))
        }

        val s = source.toCharArray()
        val t = target.toCharArray()
        var allWeight = 0L

        val cache = HashMap<Char, HashMap<Char, Int>>()
        for (c in 'a'..'z') cache[c] = HashMap()

        for (i in 0 until s.size) {
            val r = cache[s[i]]!!
            val w = r[t[i]]
            if (w != null) {
                allWeight += w
                continue
            }
            val weight = trackside(s[i], t[i], weights)
            if (weight == -1) return -1
            allWeight += weight
            r[t[i]] = weight
        }

        return allWeight
    }

    private fun trackside(from: Char, to: Char, map: Map<Char, List<Pair<Char, Int>>>): Int {
        val heap = PriorityQueue<Pair<Char, Int>>(compareBy { it.second })
        heap.add(Pair(from, 0))
        val bestWeights = HashMap<Char, Int>()
        bestWeights[from] = 0
        while (!heap.isEmpty()) {
            val node = heap.poll()
            val c = node.first
            val w = node.second
            if (c == to) return w
            if (bestWeights[c] != w) continue
            for (pp in map[c] ?: continue) {
                val bw = bestWeights[pp.first]
                if (bw == null || pp.second + w < bw) {
                    heap.add(Pair(pp.first, pp.second + w))
                    bestWeights[pp.first] = pp.second + w
                }
            }
        }
        return -1
    }
}
