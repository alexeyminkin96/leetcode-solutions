package problems.p1391

class SolutionImpl2 : Solution {
    override fun hasValidPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        fun hasValid(from: Char): Boolean {
            var from = from
            var i = 0
            var j = 0
            while (true) {
                if (i >= m || i < 0 || j >= n || j < 0) return false
                val cell = grid[i][j]
                if (cell == 0) return false
                var iDiff = 0
                var jDiff = 0
                when {
                    cell == 1 && from == 'R' || cell == 5 && from == 'U' || cell == 3 && from == 'B' -> {
                        jDiff--
                        from = 'R'
                    }

                    cell == 1 && from == 'L' || cell == 6 && from == 'U' || cell == 4 && from == 'B' -> {
                        jDiff++
                        from = 'L'
                    }

                    cell == 2 && from == 'U' || cell == 3 && from == 'L' || cell == 4 && from == 'R' -> {
                        iDiff++
                        from = 'U'
                    }

                    cell == 2 && from == 'B' || cell == 5 && from == 'L' || cell == 6 && from == 'R' -> {
                        iDiff--
                        from = 'B'
                    }

                    else -> return false
                }
                if (i != 0 && j != 0) grid[i][j] = 0
                if (i == m - 1 && j == n - 1) return true
                i += iDiff
                j += jDiff
            }
        }

        return when (grid[0][0]) {
            1, 3 -> hasValid('L')
            4 -> hasValid('B') || hasValid('R')
            else -> hasValid('U')
        }
    }
}