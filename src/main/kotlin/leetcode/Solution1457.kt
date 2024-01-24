package leetcode

class Solution1457 {
    class TreeNode(
        var `val`: Int
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var result = 0

    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        getAllRoutes(root, BooleanArray(10) { false })
        return result
    }

    fun getAllRoutes(root: TreeNode, count: BooleanArray) {
        count[root.`val`] = !count[root.`val`]
        if (root.left == null && root.right == null) {
            if (count.count { it } <= 1) {
                result++
            }
            count[root.`val`] = !count[root.`val`]
            return
        }

        root.left?.let {
            getAllRoutes(it, count)
        }

        root.right?.let {
            getAllRoutes(it, count)
        }
        count[root.`val`] = !count[root.`val`]
    }
}