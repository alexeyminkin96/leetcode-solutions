package problems.p2452

import java.util.Arrays

class SolutionImpl4 : Solution {
    override fun twoEditWords(queries: Array<String>, dictionary: Array<String>): Array<String> {
        if (queries[0].length < 3) return queries
        var rI = 0
        val dictionary = Array(dictionary.size) { dictionary[it].toCharArray() }
        query@ for (q in 0 until queries.size) {
            val query = queries[q].toCharArray()
            dict@ for (d in 0 until dictionary.size) {
                val dict = dictionary[d]
                var diffCount = 0
                for (i in 0 until query.size)
                    if (query[i] != dict[i] && ++diffCount > 2) continue@dict
                queries[rI++] = queries[q]
                continue@query
            }
        }
        return if (rI == queries.size) queries else Arrays.copyOf(queries, rI)
    }
}