package problems.p3532

class SolutionImpl1 : Solution {
    override fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
        val connection = IntArray(n)
        for (i in 1 until n)
            connection[i] = if (nums[i] - nums[i - 1] > maxDiff) i else connection[i - 1]
        return BooleanArray(queries.size) { connection[queries[it][0]] == connection[queries[it][1]] }
    }
}