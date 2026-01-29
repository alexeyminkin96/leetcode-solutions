package problems.p2976

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `33 ms` (Beats `33.33%` of Kotlin submissions)
 * - Memory: `51.45 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + C^3 * log C + n)`
 * - Space: `O(C^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-cost-to-convert-string-i/solutions/7533946/kotlin-omnc3logc-33ms-oc2-not-floyd-wars-3gxj)
 */
class SolutionImpl4 : Solution {
    override fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        val cache = Array(26) { i -> IntArray(26) { j -> if (i == j) 0 else Int.MAX_VALUE } }

        for (i in 0 until original.size) {
            val bd = cache[original[i] - 'a'][changed[i] - 'a']
            if (bd > cost[i]) cache[original[i] - 'a'][changed[i] - 'a'] = cost[i]
        }

        val heap = PriorityQueue<Int>()
        for (from in 0 until 26) {
            heap.add(from)
            val bestWeights = IntArray(26) { Int.MAX_VALUE }
            bestWeights[from] = 0
            while (!heap.isEmpty()) {
                val node = heap.poll()
                val w = node / 100
                val c = node - w * 100
                if (bestWeights[c] != w) continue
                cache[from][c] = w
                val nexts = cache[c]
                for (next in 0 until 26) {
                    if (nexts[next] == Int.MAX_VALUE) continue
                    val bw = bestWeights[next]
                    if (bw == Int.MAX_VALUE || nexts[next] + w < bw) {
                        heap.add((nexts[next] + w) * 100 + next)
                        bestWeights[next] = nexts[next] + w
                    }
                }
            }
        }

        val s = source.toCharArray()
        val t = target.toCharArray()

        var allWeight = 0L
        for (i in 0 until s.size) {
            val w = cache[s[i] - 'a'][t[i] - 'a']
            if (w == Int.MAX_VALUE) return -1
            allWeight += w
        }
        return allWeight
    }
}
