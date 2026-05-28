package problems.p3093

class SolutionImpl2 : Solution {
    override fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val idxs = IntArray(wordsContainer.sumOf { it.length } + 1)
        val tree = IntArray(idxs.size * 26)
        var globNext = 0

        for (i in 0 until wordsContainer.size) {
            var prev = 0
            val word = wordsContainer[i]
            val size = word.length
            if (wordsContainer[idxs[prev]].length > size || wordsContainer[idxs[prev]].length == size && idxs[prev] > i)
                idxs[prev] = i
            for (j in size - 1 downTo 0) {
                val next = 26 * prev + (word[j] - 'a')
                if (tree[next] == 0) {
                    tree[next] = ++globNext
                    idxs[tree[next]] = i
                }
                prev = tree[next]
                if (wordsContainer[idxs[prev]].length > size || wordsContainer[idxs[prev]].length == size && idxs[prev] > i)
                    idxs[prev] = i
            }
        }
        return IntArray(wordsQuery.size) { i ->
            var prev = 0
            val word = wordsQuery[i]
            for (j in word.length - 1 downTo 0) {
                val next = 26 * prev + (word[j] - 'a')
                if (tree[next] == 0) return@IntArray idxs[prev]
                prev = tree[next]
            }
            idxs[prev]
        }
    }
}
