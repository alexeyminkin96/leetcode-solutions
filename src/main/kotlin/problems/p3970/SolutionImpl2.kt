package problems.p3970

import java.util.PriorityQueue

class SolutionImpl2 : Solution {
    override fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
        val childrenCounts = IntArray(n)
        for (edge in edges)
            childrenCounts[edge[0]]++
        val starts = IntArray(n + 1)
        for (i in 1 until n)
            starts[i + 1] = starts[i] + childrenCounts[i - 1]
        val children = IntArray(edges.size)
        val weights = IntArray(edges.size)
        for (edge in edges) {
            children[starts[edge[0] + 1]] = edge[1]
            weights[starts[edge[0] + 1]++] = edge[2]
        }

        val labels = labels.toCharArray()
        val bestWeights = IntArray(n * k) { Int.MAX_VALUE }
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
            child@ for (j in starts[parent] until starts[parent + 1]) {
                val child = children[j]
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
}