package leetcode

import java.util.*

class Solution232 {
    class MyQueue() {

        private var headerValue = 0

        private val data: Stack<Int> = Stack()
        private val temp: Stack<Int> = Stack()

        fun push(x: Int) {
            if (data.isEmpty()) {
                headerValue = x
            }
            data.push(x)
        }

        fun pop(): Int {
            while (!data.isEmpty()) {
                temp.push(data.pop())
            }

            val result = temp.pop()
            headerValue = if (temp.isEmpty()) 0 else temp.peek()

            while (!temp.isEmpty()) {
                data.push(temp.pop())
            }

            return result
        }

        fun peek(): Int {
            return headerValue
        }

        fun empty(): Boolean {
            return data.isEmpty()
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * var obj = MyQueue()
     * obj.push(x)
     * var param_2 = obj.pop()
     * var param_3 = obj.peek()
     * var param_4 = obj.empty()
     */
}