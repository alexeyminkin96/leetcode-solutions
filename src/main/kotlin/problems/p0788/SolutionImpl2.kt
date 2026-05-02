package problems.p0788

class SolutionImpl2 : Solution {
    override fun rotatedDigits(n: Int): Int {
        return ar[n]
    }

    companion object {
        val ar = IntArray(10_001)

        init {
            var idx = 0
            var sum = 0
            for (i in 0..9) {
                val vI = v(i)
                for (j in 0..9) {
                    val vJ = v(j) + vI
                    for (k in 0..9) {
                        val vK = v(k) + vJ
                        for (h in 0..9)
                            ar[idx++] = if (v(h) + vK > 0) ++sum else sum
                    }
                }
            }
            ar[10_000] = ar[9_999]
        }

        private fun v(dig: Int): Int {
            return when (dig) {
                0, 1, 8 -> 0
                2, 5, 6, 9 -> 1
                else -> -10
            }
        }
    }
}