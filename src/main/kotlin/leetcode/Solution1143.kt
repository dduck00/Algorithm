package leetcode

class Solution1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val memoization = Array(text2.length + 1) { IntArray(text1.length + 1) { 0 } }

        for (j in 1..text2.length) {
            for (i in 1..text1.length) {
                if (text2[j - 1] == text1[i - 1]) {
                    memoization[j][i] = memoization[j - 1][i - 1] + 1
                } else {
                    memoization[j][i] = maxOf(memoization[j][i - 1], memoization[j - 1][i])
                }
            }
        }

        return memoization.maxOf { it.max() }
    }
}
