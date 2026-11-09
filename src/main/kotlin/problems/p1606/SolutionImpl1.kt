package problems.p1606

import java.util.TreeSet

/**
 * **LeetCode Performance:**
 * - Runtime: `97 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `152.29 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log k)`
 * - Space: `O(k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/solutions/8606687/kotlin-onlogk-97ms-ok-by-alexeyminkin-l7lw)
 */
class SolutionImpl1 : Solution {
    override fun busiestServers(k: Int, arrival: IntArray, load: IntArray): IntArray {
        val reqCounts = IntArray(k)
        val freeServers = TreeSet<Int>()
        for (i in 0 until k) freeServers.add(i)
        val busyServers = PriorityQueueLong(k)
        var maxReqCount = 0
        var count = k
        for (i in 0 until arrival.size) {
            val time = arrival[i]
            while (busyServers.isNotEmpty() && busyServers.peek() shr 32 <= time)
                freeServers.add(busyServers.poll().toInt())
            if (freeServers.isEmpty()) continue
            val server = freeServers.higher(i % k - 1) ?: freeServers.first()
            freeServers.remove(server)
            busyServers.add(((time + load[i]).toLong() shl 32) or server.toLong())
            if (++reqCounts[server] > maxReqCount) {
                maxReqCount++
                count = 1
            } else if (reqCounts[server] == maxReqCount)
                count++
        }

        val res = IntArray(count)
        var resI = 0
        var countsI = 0
        while (resI < count)
            if (reqCounts[countsI++] == maxReqCount) res[resI++] = countsI - 1
        return res
    }

    private class PriorityQueueLong(capacity: Int) {
        private val heap = LongArray(capacity)
        private var size = 0
        fun isNotEmpty() = size > 0
        fun add(value: Long) {
            var i = size++
            while (i > 0) {
                val p = (i - 1) shr 1
                if (heap[p] <= value) break
                heap[i] = heap[p]
                i = p
            }
            heap[i] = value
        }

        fun peek(): Long {
            return heap[0]
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