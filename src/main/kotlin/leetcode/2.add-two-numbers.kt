package leetcode

class SolutionAddTwoNumbers {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(l1!!.`val` + l2!!.`val`)
        var resultPointer = result
        var l1Pointer = l1
        var l2Pointer = l2
        while (true) {
            val roundUp = if (resultPointer.`val` >= 10) {
                resultPointer.`val` -= 10
                1
            } else {
                0
            }

            val l1Value = l1Pointer?.next?.`val` ?: 0
            val l2Value = l2Pointer?.next?.`val` ?: 0

            resultPointer.next = ListNode(l1Value + l2Value + roundUp)

            l1Pointer = l1Pointer?.next
            l2Pointer = l2Pointer?.next

            if (l1Pointer == null && l2Pointer == null && resultPointer.next!!.`val` == 0) {
                resultPointer.next = null
                break
            }

            resultPointer = resultPointer.next!!
        }

        return result
    }
}
