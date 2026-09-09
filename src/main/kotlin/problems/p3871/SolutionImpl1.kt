package problems.p3871

class SolutionImpl1 : Solution {
    override fun countCommas(n: Long): Long {
        return Math.max(0, n - 999) +
            Math.max(0, n - 999_999) +
            Math.max(0, n - 999_999_999) +
            Math.max(0, n - 999_999_999_999) +
            Math.max(0, n - 999_999_999_999_999)
    }
}