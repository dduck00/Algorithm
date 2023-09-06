package leetcode

class Solution725 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var cursor = head
        var size = 0
        while (cursor != null) {
            size++
            cursor = cursor.next
        }
        var upperCount = size % k
        val count = size / k
        val sizeList = generateSequence {
            if (upperCount == 0) {
                count
            } else {
                upperCount--
                count + 1
            }
        }.take(k).toList()

        cursor = head

        return sizeList.map {
            val resultCursor = cursor
            var beforeCursor: ListNode? = null
            (0..it - 1).map {
                beforeCursor = cursor
                cursor = cursor!!.next
            }
            beforeCursor?.next = null
            resultCursor
        }.toTypedArray()
    }
}
