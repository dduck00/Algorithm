package leetcode

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val pascalTriangle = mutableListOf(listOf(1))
        (1 until numRows).forEach { numRow ->
            val tempList = mutableListOf(1)
            (1 until numRow).map { index ->
                tempList.add(pascalTriangle.last()[index - 1] + pascalTriangle.last()[index])
            }
            tempList.add(1)
            pascalTriangle.add(tempList)
        }

        return pascalTriangle
    }
}
