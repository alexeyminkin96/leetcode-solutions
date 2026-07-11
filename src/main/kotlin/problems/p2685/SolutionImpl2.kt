package problems.p2685

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `64.68 MB` (Beats `92.31%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + e)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-the-number-of-complete-components/solutions/8390889/kotlin-one-6ms-on-primitive-only-by-alex-h5bs)
 */
class SolutionImpl2 : Solution {
    override fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        fun find(x: Int): Int {
            if (x != parent[x]) parent[x] = find(parent[x])
            return parent[x]
        }

        val edgeCount = IntArray(n)
        for (edge in edges) {
            edgeCount[edge[0]]++
            edgeCount[edge[1]]++
            parent[find(edge[0])] = find(edge[1])
        }
        var res = 0
        for (i in 0 until n) if (edgeCount[i] != edgeCount[find(i)]) edgeCount[find(i)] = -2
        for (i in 0 until n) edgeCount[find(i)]--
        for (i in 0 until n) if (edgeCount[i] == -1) res++
        return res
    }
}