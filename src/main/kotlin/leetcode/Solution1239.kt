package leetcode

import kotlin.math.max

class Solution1239 {
    var result = 0

    fun maxLength(arr: List<String>): Int {
        val arrParsed = arr.mapNotNull {
            val temp = IntArray(26) { 0 }
            var hasDuplicate = false
            it.forEach { character ->
                temp[character.code - 'a'.code]++
                if (temp[character.code - 'a'.code] > 1) {
                    hasDuplicate = true
                }
            }

            if (hasDuplicate) {
                null
            } else {
                result = max(result, it.length)
                temp
            }
        }

        backTracking(IntArray(26) { 0 }, arrParsed, 0, arrParsed.size)
        return result
    }


    fun backTracking(now: IntArray, source: List<IntArray>, targetIndex: Int, limitIndex: Int) {
        if (targetIndex >= limitIndex) {
            result = max(result, now.sum())
            return
        }

        for (index in (targetIndex until limitIndex)) {
            val temp = sum(now, source[index])
            if (temp.size == 1) {
                continue
            }

            backTracking(temp, source, index + 1, limitIndex)
        }
        result = max(result, now.sum())
    }

    fun sum(ar1: IntArray, ar2: IntArray): IntArray {
        val result = IntArray(26) { 0 }
        result.mapIndexed { index, i ->
            result[index] = ar1[index] + ar2[index]
            if (result[index] > 1)
                return IntArray(1) { 0 }
        }

        return result
    }
}