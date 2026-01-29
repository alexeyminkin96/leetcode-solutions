package problems.p2976

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `94 ms` (Beats `0.00%` of Kotlin submissions)
 * - Memory: `58.07 MB` (Beats `0.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + C^3 * log C + n)`
 * - Space: `O(C^2)`
 */
class SolutionImpl3 : Solution {
    override fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        val cache = HashMap<Char, HashMap<Char, Int>>()
        for (c in 'a'..'z') cache[c] = HashMap()
        for (i in 0 until original.size) {
            val c = cache[original[i]]!!
            val r = c[changed[i]]
            if (r == null || r > cost[i])
                c[changed[i]] = cost[i]
        }
        for (c in 'a'..'z') trackside(c, cache)
        val s = source.toCharArray()
        val t = target.toCharArray()
        var allWeight = 0L
        for (i in 0 until s.size) {
            val weight = cache[s[i]]!![t[i]]
            if (weight == null) return -1
            allWeight += weight
        }
        return allWeight
    }

    private fun trackside(from: Char, cache: HashMap<Char, HashMap<Char, Int>>) {
        val heap = PriorityQueue<Pair<Char, Int>>(compareBy { it.second })
        heap.add(Pair(from, 0))
        val bestWeights = HashMap<Char, Int>()
        bestWeights[from] = 0
        while (!heap.isEmpty()) {
            val node = heap.poll()
            val c = node.first
            val w = node.second
            if (bestWeights[c] != w) continue
            cache[from]!![c] = w
            for (pp in cache[c] ?: continue) {
                val bw = bestWeights[pp.key]
                if (bw == null || pp.value + w < bw) {
                    heap.add(Pair(pp.key, pp.value + w))
                    bestWeights[pp.key] = pp.value + w
                }
            }
        }
    }
}
