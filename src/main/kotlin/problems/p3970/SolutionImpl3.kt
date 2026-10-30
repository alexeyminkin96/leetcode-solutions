package problems.p3970

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `33 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `260.33 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(e*k*log(n*k))`
 * - Space: `O(n*k+e)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/solutions/8594850/kotlin-oeklognk-33ms-onke-primitives-onl-ew6m)
 */
class SolutionImpl3 : Solution {
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
        val heap = PriorityQueueLong()
        heap.add(0)
        parent@ while (heap.isNotEmpty()) {
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

    private class PriorityQueueLong {
        private var heap = LongArray(16)
        private var size = 0
        fun isNotEmpty() = size > 0
        fun add(value: Long) {
            if (size == heap.size)
                heap = Arrays.copyOf(heap, size shl 1)
            var i = size++
            while (i > 0) {
                val p = (i - 1) shr 1
                if (heap[p] <= value) break
                heap[i] = heap[p]
                i = p
            }
            heap[i] = value
        }

        fun poll(): Long {
            val result = heap[0]
            val value = heap[--size]
            if (size > 0) {
                var i = 0
                while (true) {
                    var c = (i shl 1) + 1
                    if (c >= size) break
                    if (c + 1 < size && heap[c + 1] < heap[c]) c++
                    if (heap[c] >= value) break
                    heap[i] = heap[c]
                    i = c
                }
                heap[i] = value
            }
            return result
        }
    }
}