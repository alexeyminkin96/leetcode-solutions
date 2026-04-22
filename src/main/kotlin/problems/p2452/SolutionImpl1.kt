package problems.p2452

class SolutionImpl1 : Solution {
    override fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val res = ArrayList<String>()
        query@ for (q in 0 until queries.size) {
            val query = queries[q]
            dict@ for (d in 0 until dictionary.size) {
                val dict = dictionary[d]
                var diffCount = 0
                for (i in 0 until query.length)
                    if (query[i] != dict[i] && ++diffCount > 2) continue@dict
                res.add(query)
                continue@query
            }
        }
        return res
    }
}