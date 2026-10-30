package problems.p3970

import java.util.Arrays
import java.util.PriorityQueue

class SolutionImpl1 : Solution {
    override fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
        val hasPath = hasPath(n, edges)
        if (!hasPath[0]) return -1

        val childrenCounts = IntArray(n)
        for (edge in edges)
            childrenCounts[edge[0]]++
        val starts = IntArray(n)
        for (i in 1 until n)
            starts[i] = starts[i - 1] + childrenCounts[i - 1]
        val ends = Arrays.copyOf(starts, n)
        val children = IntArray(edges.size)
        val weights = IntArray(edges.size)
        for (edge in edges) {
            children[ends[edge[0]]] = edge[1]
            weights[ends[edge[0]]++] = edge[2]
        }

        val labels = labels.toCharArray()
        val bestWeights = IntArray(n * k) { Int.MAX_VALUE }
        bestWeights[0] = 0
        val heap = PriorityQueue<Long>()
        heap.add(0)
        parent@ while (!heap.isEmpty()) {
            val node = heap.poll()
            val parentWeight = (node shr 32).toInt()
            val parentCount = node.toInt() shr 24
            val parent = node.toInt() shl 8 ushr 8
            if (parent == n - 1) return parentWeight
            for (count in 0 until parentCount)
                if (bestWeights[parent * k + count] <= parentWeight) continue@parent
            if (bestWeights[parent * k + parentCount] < parentWeight) continue@parent
            child@ for (j in starts[parent] until ends[parent]) {
                val child = children[j]
                if (!hasPath[child]) continue@child
                val childCount = if (labels[parent] != labels[child]) 0 else parentCount + 1
                if (childCount == k) continue
                val childWeight = parentWeight + weights[j]
                for (count in 0..childCount)
                    if (bestWeights[child * k + count] <= childWeight) continue@child
                bestWeights[child * k + childCount] = childWeight
                heap.add((childWeight.toLong() shl 32) or (childCount.toLong() shl 24) or child.toLong())
            }
        }
        return -1
    }

    private fun hasPath(n: Int, edges: Array<IntArray>): BooleanArray {
        val parentCounts = IntArray(n)
        for (edge in edges)
            parentCounts[edge[1]]++
        val starts = IntArray(n)
        for (i in 1 until n)
            starts[i] = starts[i - 1] + parentCounts[i - 1]
        val ends = Arrays.copyOf(starts, n)
        val parents = IntArray(edges.size)
        for (edge in edges)
            parents[ends[edge[1]]++] = edge[0]

        val hashPath = BooleanArray(n)
        fun dfs(i: Int) {
            if (hashPath[i]) return
            hashPath[i] = true
            for (j in starts[i] until ends[i])
                dfs(parents[j])
        }
        dfs(n - 1)
        return hashPath
    }
}