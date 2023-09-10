package leetcode

import java.math.BigInteger

class Solution1359 {
    fun countOrders(n: Int): Int {
        var result : BigInteger = BigInteger.ONE
        for (i in n * 2 downTo 1 step 2) {
            val pic = (i * (i - 1)) / 2
            result = result.multiply(pic.toBigInteger())
        }

        return result.mod((1000000007).toBigInteger()).toInt()
    }
}

// ref https://www.youtube.com/watch?v=OpgslsirW8s