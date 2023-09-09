package leetcode

class Solution377 {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val result = Array(target + 1) { 0 }

        val filteredNums = nums.filter { it <= target }.sorted()

        filteredNums.forEach {
            result[it]++
        }

        (1..target).forEach { index ->
            filteredNums.forEach { num ->
                if (index >= num)
                    result[index] += result[index - num]
            }
        }

        return result[target]
    }
}
