package leetcode

class Solution979 {

    private var count = 0

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun distributeCoins(root: TreeNode?): Int {
        if (root!!.left == null && root.right == null) {
            return 0
        }

        recursiveCheck(root, root.left)

        recursiveCheck(root, root.right)

        return count
    }

    private fun recursiveCheck(head: TreeNode, node: TreeNode?) {
        if (node == null) {
            return
        }

        recursiveCheck(
            head = node,
            node = node.left
        )

        recursiveCheck(
            head = node,
            node = node.right
        )

        val value = node.`val`

        when {
            value == 1 -> {
                return
            }

            value > 1 -> {
                val sendToHeadCount = value - 1
                head.`val` += sendToHeadCount
                count += sendToHeadCount
            }

            value < 1 -> {
                val getToHeadCount = 1 - value
                head.`val` -= getToHeadCount
                count += getToHeadCount
            }
        }
    }
}
