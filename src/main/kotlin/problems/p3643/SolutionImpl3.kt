package problems.p3643

class SolutionImpl3 : Solution {
    override fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        var top = x
        var bot = x + k - 1
        val buf = IntArray(k)
        while (top < bot) {
            System.arraycopy(grid[top], y, buf, 0, k)
            System.arraycopy(grid[bot], y, grid[top++], y, k)
            System.arraycopy(buf, 0, grid[bot--], y, k)
        }
        return grid
    }
}