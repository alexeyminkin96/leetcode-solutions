package problems.p2492

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `131.44 MB` (Beats `14.29%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + r)`
 * - Space: `O(n + r)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/solutions/8375721/kotlin-onr-10ms-onr-primitives-only-by-a-6b8m)
 */
class SolutionImpl3 : Solution {
    override fun minScore(n: Int, roads: Array<IntArray>): Int {
        val adjCounts = IntArray(n + 1)
        for (road in roads) {
            adjCounts[road[0]]++
            adjCounts[road[1]]++
        }

        val start = IntArray(n + 2)
        for (i in 1..n)
            start[i + 1] = start[i] + adjCounts[i]
        val fin = Arrays.copyOf(start, start.size)

        val to = IntArray(roads.size shl 1)
        val dists = IntArray(to.size)

        for (road in roads) {
            val city1 = road[0]
            val city2 = road[1]
            val dist = road[2]

            val idxCity1 = fin[city1]++
            to[idxCity1] = city2
            dists[idxCity1] = dist

            val idxCity2 = fin[city2]++
            to[idxCity2] = city1
            dists[idxCity2] = dist
        }

        val visited = BooleanArray(n + 1)
        var res = Int.MAX_VALUE
        val s = IntArray(n + 1)
        var stackIdx = 0
        s[stackIdx++] = 1
        visited[1] = true
        while (stackIdx > 0) {
            val cur = s[--stackIdx]
            for (i in start[cur] until fin[cur]) {
                res = Math.min(res, dists[i])
                val next = to[i]
                if (!visited[next]) {
                    s[stackIdx++] = next
                    visited[next] = true
                }
            }
        }
        return res
    }
}