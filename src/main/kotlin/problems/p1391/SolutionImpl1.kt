package problems.p1391

class SolutionImpl1 : Solution {
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
                when (from) {
                    'L' -> when (cell) {
                        1 -> jDiff++
                        3 -> {
                            iDiff++
                            from = 'U'
                        }

                        5 -> {
                            iDiff--
                            from = 'B'
                        }

                        else -> return false
                    }

                    'R' -> when (cell) {
                        1 -> jDiff--
                        4 -> {
                            iDiff++
                            from = 'U'
                        }

                        6 -> {
                            iDiff--
                            from = 'B'
                        }

                        else -> return false
                    }

                    'U' -> when (cell) {
                        2 -> iDiff++
                        5 -> {
                            jDiff--
                            from = 'R'
                        }

                        6 -> {
                            jDiff++
                            from = 'L'
                        }

                        else -> return false
                    }

                    'B' -> when (cell) {
                        2 -> iDiff--
                        3 -> {
                            jDiff--
                            from = 'R'
                        }

                        4 -> {
                            jDiff++
                            from = 'L'
                        }

                        else -> return false
                    }
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