package problems.p3043

class SolutionImpl1 : Solution {
    override fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val min = if (arr1.size < arr2.size) arr1 else arr2
        val max = if (arr1.size < arr2.size) arr2 else arr1
        val set = HashSet<Int>()
        for (i in 0 until min.size) {
            var num = min[i]
            while (num > 0) {
                set.add(num)
                num /= 10
            }
        }
        var maxPref = 0
        for (i in 0 until max.size) {
            var num = max[i]
            while (num > maxPref) {
                if (set.contains(num)) maxPref = num
                num /= 10
            }
        }
        var res = 0
        while (maxPref > 0) {
            res++
            maxPref /= 10
        }
        return res
    }
}
