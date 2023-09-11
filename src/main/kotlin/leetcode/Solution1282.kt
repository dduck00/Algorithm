package leetcode

class Solution1282 {

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val resultSet = Array(500) { mutableListOf<Int>() }
        groupSizes.mapIndexed { index, i ->
            resultSet[i - 1].add(index)
        }

        val result = mutableListOf<List<Int>>()
        resultSet.mapIndexed { sizeMinusedOne, member ->
            if (member.isNotEmpty()) {
                val size = sizeMinusedOne + 1
                if (member.size > size) {
                    var pivot = 0
                    while (pivot < member.size) {
                        result.add(member.subList(pivot, pivot + size))
                        pivot += size
                    }
                } else {
                    result.add(member)
                }
            }
        }
        return result
    }
}
