package problems.p3568

import java.util.LinkedList

class SolutionImpl1 : Solution {
    override fun minMoves(classroom: Array<String>, energy: Int): Int {
        val m = classroom.size
        val n = classroom[0].length
        val grid = Array(m) { classroom[it].toCharArray() }
        val order = LinkedList<Node>()
        var lCount = '0'
        for (i in 0 until m)
            for (j in 0 until n)
                when (grid[i][j]) {
                    'L' -> grid[i][j] = lCount++
                    'S' -> order.add(Node(i, j, 0, energy))
                }
        val stateCount = 1 shl (lCount - '0')
        val states = Array(m) { Array(n) { IntArray(stateCount) { -1 } } }
        states[order[0].i][order[0].j][0] = energy
        var moves = 0

        fun next(node: Node, i: Int, j: Int) {
            var nextEnergy = node.energy - 1
            var nextState = node.state
            when (val next = grid[i][j]) {
                'X' -> return
                'R' -> nextEnergy = energy
                '.', 'S' -> {}
                else -> nextState = nextState or (1 shl (next - '0'))
            }
            if (states[i][j][nextState] < nextEnergy) {
                states[i][j][nextState] = nextEnergy
                order.add(Node(i, j, nextState, nextEnergy))
            }
        }

        while (!order.isEmpty()) {
            for (i in 0 until order.size) {
                val node = order.removeFirst()
                if (node.state == stateCount - 1) return moves
                if (node.energy == 0) continue
                if (node.i > 0) next(node, node.i - 1, node.j)
                if (node.i < m - 1) next(node, node.i + 1, node.j)
                if (node.j > 0) next(node, node.i, node.j - 1)
                if (node.j < n - 1) next(node, node.i, node.j + 1)
            }
            moves++
        }
        return -1
    }

    private data class Node(
        val i: Int,
        val j: Int,
        val state: Int,
        val energy: Int,
    )
}