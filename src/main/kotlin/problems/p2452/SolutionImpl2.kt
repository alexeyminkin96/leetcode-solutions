package problems.p2452

class SolutionImpl2 : Solution {
    override fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val dictSet = HashSet<String>()
        for (d in 0 until dictionary.size) dictSet.add(dictionary[d])
        val dictionary = Array(dictionary.size) { dictionary[it].toCharArray() }
        val res = ArrayList<String>()
        query@ for (q in 0 until queries.size) {
            if (dictSet.contains(queries[q])) {
                res.add(queries[q])
                continue
            }
            val query = queries[q].toCharArray()
            dict@ for (d in 0 until dictionary.size) {
                val dict = dictionary[d]
                var diffCount = 0
                for (i in 0 until query.size)
                    if (query[i] != dict[i] && ++diffCount > 2) continue@dict
                res.add(queries[q])
                continue@query
            }
        }
        return res
    }
}