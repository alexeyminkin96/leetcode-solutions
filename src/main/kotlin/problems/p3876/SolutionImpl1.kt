package problems.p3876

class SolutionImpl1 : Solution {
    override fun uniformArray(nums1: IntArray): Boolean {
        var minOdd = Int.MAX_VALUE
        for (num in nums1)
            if (num and 1 == 1 && num < minOdd) minOdd = num
        if (minOdd == Int.MAX_VALUE) return true
        for (num in nums1)
            if (num and 1 == 0 && num < minOdd) return false
        return true
    }
}