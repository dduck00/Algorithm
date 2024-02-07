package leetcode

class Solution451 {
    val code = IntArray(256) { 0 }
    fun frequencySort(s: String): String {
        s.forEach { character ->
            code[character.code]++
        }

        var result = ""

        code.mapIndexed { index, i -> index.toChar() to i }.sortedByDescending { it.second }.map {
            for (i in 0 until it.second) {
                result += it.first
            }
        }

        return result
    }
}
