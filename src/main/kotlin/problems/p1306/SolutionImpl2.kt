package problems.p1306

class SolutionImpl2 : Solution {
    override fun canReach(arr: IntArray, start: Int): Boolean {
        val stack = IntArray(arr.size)
        var head = 0
        stack[head++] = start
        arr[start] *= -1
        while (head > 0) {
            val idx = stack[--head]
            val l = idx - arr[idx]
            if (l >= 0 && l < arr.size && arr[l] >= 0) {
                if (arr[l] == 0) return true
                arr[l] *= -1
                stack[head++] = l
            }
            val r = idx + arr[idx]
            if (r >= 0 && r < arr.size && arr[r] >= 0) {
                if (arr[r] == 0) return true
                arr[r] *= -1
                stack[head++] = r
            }
        }
        return false
    }
}