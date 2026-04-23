package problems.p2615

class SolutionImpl3 : Solution {
    override fun distance(nums: IntArray): LongArray {
        val res = LongArray(nums.size)
        nums
            .withIndex()
            .groupBy({ it.value }, { it.index })
            .forEach { (_, ids) ->
                var sum = ids.sumOf { it.toLong() }
                ids.foldIndexed(0L) { index, acc, id ->
                    sum -= id
                    res[id] = id * index - acc + sum - id * (ids.size - 1 - index)
                    acc + id
                }
            }
        return res
    }
}