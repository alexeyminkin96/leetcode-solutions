package problems.p1301

class SolutionImpl1 : Solution {
    override fun pathsWithMaxScore(board: List<String>): IntArray {
        val mod = 1_000_000_007
        val n = board.size
        val max = IntArray(n + 1) { -1 }
        val count = IntArray(n + 1)
        for (i in 0 until n) {
            val row = board[i].toCharArray()
            var diagMax = max[0]
            var diagCount = count[0]
            for (j in 0 until n) {
                var curMax = max[j + 1]
                var curCount = count[j + 1]
                val c = row[j]
                val dig = when (c) {
                    'E' -> {
                        curMax = 0
                        curCount = 1
                        0
                    }

                    'S' -> 0
                    'X' -> {
                        diagMax = max[j + 1]
                        diagCount = count[j + 1]
                        max[j + 1] = -1
                        continue
                    }

                    else -> c - '0'
                }

                when {
                    diagMax > curMax -> {
                        curMax = diagMax
                        curCount = diagCount
                    }

                    diagMax == curMax -> {
                        curCount += diagCount
                        if (curCount >= mod) curCount -= mod
                    }
                }

                when {
                    max[j] > curMax -> {
                        curMax = max[j]
                        curCount = count[j]
                    }

                    max[j] == curMax -> {
                        curCount += count[j]
                        if (curCount >= mod) curCount -= mod
                    }
                }

                diagMax = max[j + 1]
                diagCount = count[j + 1]
                max[j + 1] = curMax + if (curMax != -1) dig else 0
                count[j + 1] = curCount
            }
        }
        val res = IntArray(2)
        if (max[n] != -1) {
            res[0] = max[n]
            res[1] = count[n]
        }
        return res
    }
}