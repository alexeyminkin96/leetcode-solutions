package problems.p3568

/**
 * **LeetCode Performance:**
 * - Runtime: `51 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `57.72 MB` (Beats `97.78%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * 2^l * energy)`
 * - Space: `O(m * n * 2^l)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/solutions/8499892/kotlin-omn2le-51ms-omn2l-primitives-only-dxxt)
 */
class SolutionImpl3 : Solution {
    //                         state    energy   j     i
    //                          10b       6b     5b    5b
    //                     <----------> <-----><----><---->
    //     node : 0b0000_0000_0000_0000_0000_0000_0000_0000
    override fun minMoves(classroom: Array<String>, energy: Int): Int {
        val iBits = 5
        val jBits = 5
        val enBits = 6
        val iMask = (1 shl iBits) - 1
        val jMask = (1 shl jBits) - 1
        val enMask = (1 shl enBits) - 1
        val jOf = iBits
        val enOf = jBits + jOf
        val stOf = enBits + enOf

        val m = classroom.size
        val n = classroom[0].length
        val grid = Array(m) { classroom[it].toCharArray() }
        var lCount = '0'

        var startI = 0
        var startJ = 0
        for (i in 0 until m)
            for (j in 0 until n)
                when (grid[i][j]) {
                    'L' -> grid[i][j] = lCount++
                    'S' -> {
                        startI = i
                        startJ = j
                    }
                }
        val stateCount = 1 shl (lCount - '0')
        var stack = IntArray(m * n * stateCount)
        var sI = 0
        var nextStack = IntArray(m * n * stateCount)
        var nsI = 0
        stack[sI++] = ((energy shl enOf) or (startJ shl jOf) or startI)
        val states = IntArray(m * n * stateCount) { -1 }
        states[startI * n + startJ] = energy
        var moves = 0

        fun next(curState: Int, curEnergy: Int, i: Int, j: Int) {
            var nextState = curState
            var nextEnergy = curEnergy - 1
            when (val next = grid[i][j]) {
                'X' -> return
                'R' -> nextEnergy = energy
                '.', 'S' -> {}
                else -> nextState = nextState or (1 shl (next - '0'))
            }
            val idx = (nextState * m + i) * n + j
            if (states[idx] < nextEnergy) {
                states[idx] = nextEnergy
                nextStack[nsI++] = ((nextState shl stOf) or (nextEnergy shl enOf) or (j shl jOf) or i)
            }
        }
        while (sI != 0) {
            while (sI != 0) {
                val node = stack[--sI]
                val curState = node shr stOf
                if (curState == stateCount - 1) return moves
                val curEnergy = (node shr enOf) and enMask
                if (curEnergy == 0) continue
                val j = (node shr jOf) and jMask
                val i = node and iMask
                if (i > 0) next(curState, curEnergy, i - 1, j)
                if (i < m - 1) next(curState, curEnergy, i + 1, j)
                if (j > 0) next(curState, curEnergy, i, j - 1)
                if (j < n - 1) next(curState, curEnergy, i, j + 1)
            }
            moves++
            val t = nextStack
            nextStack = stack
            stack = t
            sI = nsI
            nsI = 0
        }
        return -1
    }
}