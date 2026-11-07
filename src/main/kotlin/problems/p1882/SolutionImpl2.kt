package problems.p1882

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `59 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `198.24 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n + m log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/process-tasks-using-servers/solutions/8604540/kotlin-onmlogn-59ms-on-primitives-only-b-tbfp)
 */
class SolutionImpl2 : Solution {
    override fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val n = servers.size
        val priorities = LongArray(n) { (servers[it].toLong() shl 32) or it.toLong() }
        Arrays.sort(priorities)
        val freeServers = PriorityQueueLong(n)
        val busyServers = PriorityQueueLong(n)
        for (i in 0 until n) freeServers.add(i.toLong())
        return IntArray(tasks.size) { time ->
            while (busyServers.isNotEmpty() && busyServers.peek() shr 32 <= time)
                freeServers.add(busyServers.poll().toInt().toLong())
            val server = if (freeServers.isNotEmpty())
                freeServers.poll() + ((time.toLong() + tasks[time].toLong()) shl 32)
            else
                busyServers.poll() + (tasks[time].toLong() shl 32)
            busyServers.add(server)
            priorities[server.toInt()].toInt()
        }
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