package leetcode

class Solution332 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val routeList =
            tickets.groupBy { it[0] }
                .map {
                    it.key to it.value.map { it[1] }
                        .sorted().toMutableList()
                }.toMap()
        val result = mutableListOf<String>()
        val usedTicket = mutableSetOf<Pair<String, Int>>()

        fun dfs(country: String): Boolean {
            result.add(country)
            if (result.size == tickets.size + 1)
                return true

            if(routeList[country] == null) {
                result.removeLast()
                return false
            }
            for (index in routeList[country]!!.indices) {
                if (usedTicket.contains(country to index))
                    continue
                usedTicket.add(country to index)
                if (dfs(routeList[country]!![index]))
                    return true
                usedTicket.remove(country to index)
            }

            result.removeLast()
            return false
        }

        dfs("JFK")

        return result
    }
}
