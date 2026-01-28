package problems.p3651

import java.util.Arrays
import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `1542 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `78.82 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m*n * log(m*n) + k*m*n * log(m*n))`
 * - Space: `O(k*m*n + m*n)`
 */
class SolutionImpl1 : Solution {
    override fun minCost(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val v = m * n

        val heap = heap()
        val bestWeights = bestWeights(m, n, k)
        val sorted = sorted(grid, n, v)
        val lower = IntArray(k + 1)

        while (!heap.isEmpty()) {
            val node = heap.poll()
            val i = node.i
            val j = node.j
            val t = node.t
            val w = node.w
            if (i == m - 1 && j == n - 1) return w
            if (w != bestWeights[i][j][t]) continue
            if (i + 1 < m) next(i + 1, j, t, w, grid, bestWeights, heap)
            if (j + 1 < n) next(i, j + 1, t, w, grid, bestWeights, heap)
            if (t < k) lower(i, j, t, w, v, grid, bestWeights, lower, heap, sorted)
        }
        return -1
    }

    private fun lower(
        i: Int, j: Int, t: Int, w: Int, v: Int,
        grid: Array<IntArray>,
        bestWeights: Array<Array<IntArray>>,
        lower: IntArray,
        heap: PriorityQueue<Node>,
        sorted: Array<Cell>
    ) {
        while (lower[t] < v && sorted[lower[t]].v <= grid[i][j]) {
            val ni = sorted[lower[t]].i
            val nj = sorted[lower[t]].j
            val nt = t + 1
            if (!(ni == i && nj == j) && w < bestWeights[ni][nj][nt]) {
                bestWeights[ni][nj][nt] = w
                heap.add(Node(ni, nj, nt, w))
            }
            lower[t]++
        }
    }

    private fun next(
        i: Int, j: Int, t: Int, w: Int,
        grid: Array<IntArray>,
        bestWeights: Array<Array<IntArray>>,
        heap: PriorityQueue<Node>
    ) {
        val nextW = w + grid[i][j]
        if (nextW < bestWeights[i][j][t]) {
            heap.add(Node(i, j, t, nextW))
            bestWeights[i][j][t] = nextW
        }
    }

    private fun heap(): PriorityQueue<Node> {
        val heap = PriorityQueue<Node>(compareBy { it.w })
        heap.add(Node(0, 0, 0, 0))
        return heap
    }

    private fun bestWeights(m: Int, n: Int, k: Int): Array<Array<IntArray>> {
        val bestWeights = Array(m) { Array(n) { IntArray(k + 1) { Int.MAX_VALUE } } }
        bestWeights[0][0][0] = 0
        return bestWeights
    }

    private fun sorted(grid: Array<IntArray>, n: Int, v: Int): Array<Cell> {
        val sorted = Array(v) {
            val i = it / n
            val j = it % n
            Cell(i, j, grid[i][j])
        }
        Arrays.sort(sorted, compareBy { it.v })
        return sorted
    }

    data class Node(val i: Int, val j: Int, val t: Int, val w: Int)
    data class Cell(val i: Int, val j: Int, val v: Int)
}