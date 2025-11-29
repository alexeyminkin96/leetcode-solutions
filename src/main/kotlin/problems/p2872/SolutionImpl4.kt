package problems.p2872

/**
 * **LeetCode Performance:**
 * - Runtime: `31 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `83.17 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-k-divisible-components/solutions/7381304/kotlin-on-31ms-on-without-recursion-dfs-terkw)
 */
class SolutionImpl4 : Solution {
    override fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val children = Array(n) { mutableListOf<Int>() }

        for (i in 0 until edges.size) {
            children[edges[i][0]].add(edges[i][1])
            children[edges[i][1]].add(edges[i][0])
        }

        val nodes = IntArray(n)
        val parents = IntArray(n)
        var nodeIndex = 0
        val visitedNode = mutableListOf<Int>()
        var count = 0

        while (nodeIndex >= 0) {
            val node = nodes[nodeIndex]
            val nodeChildren = children[node]
            for (i in 0 until nodeChildren.size) {
                if (children[nodeChildren[i]] === visitedNode) continue
                nodes[++nodeIndex] = nodeChildren[i]
                parents[nodeIndex] = node
            }
            children[node] = visitedNode
            if (node == nodes[nodeIndex]) {
                val rem = values[node] % k
                if (rem == 0) count++
                values[parents[nodeIndex]] = (values[parents[nodeIndex--]] + rem) % k
            }
        }

        return count
    }
}
