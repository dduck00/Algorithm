package leetcode

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        var size = 0
        val charIndex = mutableMapOf<Char, Int>()
        for (index in s.indices) {
            val alreadyLocation = charIndex[s[index]]
            if (alreadyLocation == null) {
                size++
                charIndex[s[index]] = index
            } else {
                result = maxOf(size, result)
                size = index - alreadyLocation
                charIndex.keys.mapNotNull { key ->
                    val tempIndex = charIndex[key]
                    if (tempIndex != null && tempIndex < alreadyLocation)
                        key
                    else
                        null
                }.forEach { charIndex.remove(it) }
                charIndex[s[index]] = index
            }
        }

        return maxOf(result, size)
    }
}
