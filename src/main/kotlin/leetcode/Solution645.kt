package leetcode

class Solution645 {
    fun findErrorNums(nums: IntArray): IntArray {
        val array = IntArray(nums.size) { 0 }

        var dup = 0
        nums.forEach {
            array[it - 1]++
            if (array[it - 1] == 2) {
                dup = it
            }
        }

        return intArrayOf(dup, array.indexOfFirst { it == 0 } + 1)
    }
}