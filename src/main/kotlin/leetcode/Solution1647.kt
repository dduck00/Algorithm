package leetcode

class Solution1647 {
    fun minDeletions(s: String): Int {
        val alphabetCountList = MutableList(26) { 0 }
        s.forEach {
            alphabetCountList[it.code - 97]++
        }
        alphabetCountList.sortDescending()

        var result = 0
        var index = 0

        while (index < 26) {
            if (index == 0 || alphabetCountList[index] == 0) {
                index++
                continue
            }

            if (alphabetCountList[index - 1] == alphabetCountList[index]) {
                alphabetCountList[index]--
                result++
                alphabetCountList.sortDescending()
            } else {
                index++
            }
        }
        return result
    }
}
