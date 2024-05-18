package leetcode

class Solution979 {

    private var count = 0

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun distributeCoins(root: TreeNode?): Int {
        recursiveCheck(root)

        return count
    }

    private fun recursiveCheck(node: TreeNode?): Int {
        if (node == null) {
            return  0
        }

        val leftValue = recursiveCheck(
            node = node.left
        )

        val rightValue = recursiveCheck(
            node = node.right
        )

        val value = node.`val` + leftValue + rightValue

        return when {
            value > 1 -> {
                val sendToHeadCount = value - 1

                count += sendToHeadCount
                sendToHeadCount
            }

            value < 1 -> {
                val getToHeadCount = 1 - value

                count += getToHeadCount
                getToHeadCount * -1
            }

            else -> {
                0
            }
        }
    }
}
