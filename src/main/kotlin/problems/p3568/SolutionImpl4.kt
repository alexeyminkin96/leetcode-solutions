package problems.p3568

class SolutionImpl4 : Solution {
    //                      energy    state      j     i
    //                        6b        10b      5b    5b
    //                     <-----> <----------><----><---->
    // enStCell : 0b0000_0000_0000_0000_0000_0000_0000_0000
    override fun minMoves(classroom: Array<String>, energy: Int): Int {
        val iBits = 5
        val jBits = 5
        val stBits = 10
        val iMask = (1 shl iBits) - 1
        val jMask = (1 shl jBits) - 1
        val stMask = (1 shl stBits) - 1
        val jOf = iBits
        val stOf = jBits + jOf
        val enOf = stBits + stOf

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
        val stack = IntArray(m * n * stateCount)
        var sI = 0
        stack[sI++] = ((energy shl enOf) or (startJ shl jOf) or startI)
        val states = IntArray(m * n * stateCount) { -1 }
        states[startI * n + startJ] = energy
        val bestEnergy = IntArray(m * n * stateCount) { -1 }
        val uniqPairs = IntArray(m * n * stateCount)
        var upI = 0
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
            val stCell = (nextState * m + i) * n + j
            if (bestEnergy[stCell] == -1) uniqPairs[upI++] = (nextState shl stOf) or (j shl jOf) or i
            bestEnergy[stCell] = Math.max(bestEnergy[stCell], nextEnergy)
        }

        while (sI != 0) {
            while (sI != 0) {
                val enStCell = stack[--sI]
                val curState = (enStCell shr stOf) and stMask
                if (curState == stateCount - 1) return moves
                val curEnergy = enStCell shr enOf
                if (curEnergy == 0) continue
                val j = (enStCell shr jOf) and jMask
                val i = enStCell and iMask
                if (i > 0) next(curState, curEnergy, i - 1, j)
                if (i < m - 1) next(curState, curEnergy, i + 1, j)
                if (j > 0) next(curState, curEnergy, i, j - 1)
                if (j < n - 1) next(curState, curEnergy, i, j + 1)
            }
            while (upI != 0) {
                val enStCell = uniqPairs[--upI]
                val curState = (enStCell shr stOf) and stMask
                val i = enStCell and iMask
                val j = (enStCell shr jOf) and jMask
                val stCell = ((curState) * m + i) * n + j
                val curEnergy = bestEnergy[stCell]
                if (states[stCell] < curEnergy) {
                    states[stCell] = curEnergy
                    stack[sI++] = (bestEnergy[stCell] shl enOf) or enStCell
                }
                bestEnergy[stCell] = -1
            }
            moves++
        }
        return -1
    }
}