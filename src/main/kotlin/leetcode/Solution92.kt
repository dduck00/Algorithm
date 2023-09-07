package leetcode

class Solution92 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) {
            return head
        }

        var cursor = head
        var cursorCount = 1
        val result = mutableListOf<ListNode>()
        val reversedResult = mutableListOf<ListNode>()
        while (cursor != null) {
            if (cursorCount >= left && cursorCount <= right) {
                reversedResult.add(cursor)
            } else {
                result.add(cursor)
            }
            cursorCount++
            cursor = cursor.next
        }

        reversedResult.reverse()

        var reversedCursor = 0
        var normalCursor = 0

        val returnValue = if (left == 1) {
            reversedResult[reversedCursor].apply { reversedCursor++ }
        } else {
            result[normalCursor].apply { normalCursor++ }
        }
        var returnValueCursor: ListNode? = returnValue
        (2..cursorCount - 1).map { index ->
            returnValueCursor?.next = if (index >= left && index <= right) {
                reversedResult[reversedCursor].apply { reversedCursor++ }
            } else {
                result[normalCursor].apply { normalCursor++ }
            }
            returnValueCursor = returnValueCursor?.next
            returnValueCursor?.next = null
        }

        return returnValue
    }
}