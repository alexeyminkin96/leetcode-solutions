package problems.p3043

class SolutionImpl2 : Solution {
    override fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val min = if (arr1.size < arr2.size) arr1 else arr2
        val max = if (arr1.size < arr2.size) arr2 else arr1
        val tree = arrayOfNulls<Node>(10)
        val buf = IntArray(9)
        for (i in 0 until min.size) {
            var num = min[i]
            var j = -1
            while (num > 0) {
                buf[++j] = num % 10
                num /= 10
            }
            var arr = tree
            while (j >= 0) {
                if (arr[buf[j]] == null) arr[buf[j]] = Node()
                arr = arr[buf[j--]]!!.arr
            }
        }
        var res = 0
        for (i in 0 until max.size) {
            var num = max[i]
            var j = -1
            while (num > 0) {
                buf[++j] = num % 10
                num /= 10
            }
            val length = j
            var arr = tree
            while (j >= 0 && arr[buf[j]] != null)
                arr = arr[buf[j--]]!!.arr
            res = Math.max(res, length - j)
        }
        return res
    }

    class Node(
        val arr: Array<Node?> = arrayOfNulls(10)
    )
}
