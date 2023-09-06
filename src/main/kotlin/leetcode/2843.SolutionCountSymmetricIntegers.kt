package leetcode

class SolutionCountSymmetricIntegers {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var result = 0
        (low..high).forEach {
            val number = it.toString()
            if (number.length % 2 == 0) {
                val first = number.substring(0, number.length / 2)
                val second = number.substring(number.length / 2, number.length)


                if (first.map { it.digitToInt() }.sum() == second.map { it.digitToInt() }.sum()) {
                    result++
                }
            }
        }
        return result
    }
}