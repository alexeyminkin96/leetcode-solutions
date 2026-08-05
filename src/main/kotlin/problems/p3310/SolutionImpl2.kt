package problems.p3310

class SolutionImpl2 : Solution {
    override fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): IntArray {
        // Build chain forward star graph
        val head = IntArray(n) { -1 }
        val to = IntArray(invocations.size) { invocations[it][1] }
        val next = IntArray(invocations.size) {
            val next = head[invocations[it][0]]
            head[invocations[it][0]] = it
            next
        }

        // Iterate graph with DFS from 'k'
        val suspicious = BooleanArray(n)
        val stack = IntArray(n)
        var stackI = 0
        stack[stackI++] = k
        suspicious[k] = true
        while (stackI != 0) {
            var i = head[stack[--stackI]]
            while (i != -1) {
                if (!suspicious[to[i]]) {
                    stack[stackI++] = to[i]
                    suspicious[to[i]] = true
                }
                i = next[i]
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