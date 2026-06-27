package problems.p3020

class SolutionImpl1 : Solution {
    override fun maximumLength(nums: IntArray): Int {
        var ones = 0
        val set1 = HashSet<Int>(nums.size)
        val set2 = HashSet<Int>(nums.size)
        for (n in nums) if (n == 1) ones++ else if (!set1.add(n)) set2.add(n)
        ones -= (ones + 1) and 1
        if (ones >= 9) return ones
        var res = ones
        for (n in nums) {
            var chain = 0
            var next = n
            while (set2.contains(next)) {
                next *= next
                chain += 2
            }
            if (set1.contains(next)) chain++
            else chain--
            res = Math.max(res, chain)
        }
        return res
    }
}