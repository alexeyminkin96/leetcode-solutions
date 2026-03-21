package problems.p3643

class SolutionImpl2 : Solution {
    override fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        var top = x
        var bot = x + k - 1
        while (top < bot) {
            val t = grid[top++]
            val b = grid[bot--]
            for (j in y until y + k) {
                val buf = t[j]
                t[j] = b[j]
                b[j] = buf
            }
        }
        return grid
    }
}