package problems.p1301

class SolutionImpl2 : Solution {
    override fun pathsWithMaxScore(board: List<String>): IntArray {
        val mod = 1_000_000_007
        val n = board.size
        val max = IntArray(n + 1) { -1 }
        val count = IntArray(n + 1)
        var curMax = 0
        var curCount = 0
        fun update(max: Int, count: Int) {
            when {
                max > curMax -> {
                    curMax = max
                    curCount = count
                }

                max == curMax -> {
                    curCount += count
                    if (curCount >= mod) curCount -= mod
                }
            }
        }
        for (i in 0 until n) {
            val row = board[i].toCharArray()
            var diagMax = max[0]
            var diagCount = count[0]
            for (j in 1..n) {
                curMax = diagMax
                curCount = diagCount
                diagMax = max[j]
                diagCount = count[j]
                val dig = when (val c = row[j - 1]) {
                    'E' -> {
                        curMax = 0
                        curCount = 1
                        0
                    }

                    'S' -> 0
                    'X' -> {
                        max[j] = -1
                        continue
                    }

                    else -> c - '0'
                }
                update(max[j], count[j])
                update(max[j - 1], count[j - 1])
                max[j] = curMax + if (curMax != -1) dig else 0
                count[j] = curCount
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