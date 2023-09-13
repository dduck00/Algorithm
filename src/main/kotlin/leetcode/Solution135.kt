package leetcode

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val candyList = MutableList(ratings.size) { 1 }
        ratings.indices.map { index ->
            if (index > 0 && ratings[index - 1] < ratings[index]) {
                candyList[index] = candyList[index - 1] + 1
            }
        }
        println(candyList)

        ratings.indices.reversed().map { index ->
            if (index < ratings.size - 1 && ratings[index] > ratings[index + 1]) {
                candyList[index] = maxOf(candyList[index], candyList[index + 1] + 1)
            }
        }

        println(candyList)
        return candyList.sum()
    }
}
