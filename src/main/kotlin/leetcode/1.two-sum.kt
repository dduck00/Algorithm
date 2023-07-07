package leetcode

class SolutionTwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val filteredNums = nums.sorted()

        var indexFromHead = 0
        var indexFromTail = filteredNums.size - 1

        var temp: Int

        while (true) {
            temp = filteredNums[indexFromHead] + filteredNums[indexFromTail]
            if (temp < target)
                indexFromHead++
            else if (temp > target)
                indexFromTail--
            else
                break
        }

        val headValue = filteredNums[indexFromHead]
        val tailValue = filteredNums[indexFromTail]

        return intArrayOf(
            nums.indexOfFirst { it == headValue },
            nums.indexOfLast { it == tailValue }
        ).sortedArray()
    }
}
