package problems.p3310

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `180.15 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`, m - invocation.size
 * - Space: `O(n + m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/remove-methods-from-project/solutions/8442379/kotlin-onm-21ms-onm-primitives-only-csr-ipny5)
 */
class SolutionImpl1 : Solution {
    override fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): IntArray {
        // Build CSR graph
        val starts = IntArray(n)
        val ends = IntArray(n)
        for (inv in invocations) ends[inv[0]]++
        for (i in 1 until n) starts[i] = starts[i - 1] + ends[i - 1]
        System.arraycopy(starts, 0, ends, 0, n)
        val graph = IntArray(invocations.size)
        for (inv in invocations) graph[ends[inv[0]]++] = inv[1]

        // Iterate graph with DFS from 'k'
        val suspicious = BooleanArray(n)
        val stack = IntArray(n)
        var stackI = 0
        stack[stackI++] = k
        suspicious[k] = true
        while (stackI != 0) {
            val cur = stack[--stackI]
            for (nextI in starts[cur] until ends[cur])
                if (!suspicious[graph[nextI]]) {
                    stack[stackI++] = graph[nextI]
                    suspicious[graph[nextI]] = true
                }
        }

        // Build resul
        for (inv in invocations) if (!suspicious[inv[0]] && suspicious[inv[1]]) return IntArray(n) { it }
        var notSuspicious = 0
        for (i in 0 until n) if (!suspicious[i]) notSuspicious++
        val res = IntArray(notSuspicious)
        var resI = 0
        for (i in 0 until n) if (!suspicious[i]) res[resI++] = i
        return res
    }
}