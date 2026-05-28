package problems.p3093

/**
 * **LeetCode Performance:**
 * - Runtime: `53 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `144.75 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(wc + wq)`
 * - Space: `O(wc)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-common-suffix-queries/solutions/8298744/kotlin-owc-wq-53ms-owc-by-alexeyminkin-43t4)
 */
class SolutionImpl1 : Solution {
    override fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val dh = Node(0)
        for (i in 0 until wordsContainer.size) {
            val word = wordsContainer[i]
            val size = word.length
            var node = dh
            if (size < wordsContainer[node.idx].length) node.idx = i
            for (j in size - 1 downTo 0) {
                var next = node.next[word[j] - 'a']
                if (next == null) {
                    next = Node(i)
                    node.next[word[j] - 'a'] = next
                } else if (wordsContainer[next.idx].length > size || wordsContainer[next.idx].length == size && next.idx > i)
                    next.idx = i
                node = next
            }
        }
        return IntArray(wordsQuery.size) { i ->
            val word = wordsQuery[i]
            var node = dh
            for (j in word.length - 1 downTo 0)
                node = node.next[word[j] - 'a'] ?: break
            node.idx
        }
    }

    private class Node(
        var idx: Int,
        val next: Array<Node?> = arrayOfNulls(26)
    )
}