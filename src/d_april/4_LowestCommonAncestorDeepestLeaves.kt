package d_april

import z_data_type.TreeNode
import z_data_type.createTree
import z_data_type.printInorderTree

/**
 *  Problem 4. Lowest Common Ancestor of Deepest Leaves.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        val result = lcaDeepestLeaves(root)
        printInorderTree(result)
    }

}

fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    return postOrder(root).first
}


private fun postOrder(root: TreeNode?): Pair<TreeNode?, Int> {
    if (root == null) {
        return Pair(null, 0)
    }

    val left = postOrder(root?.left)
    val right = postOrder(root?.right)
    if (left.second > right.second) {
        return Pair(left.first, left.second + 1)
    }

    if (left.second < right.second) {
        return Pair(right.first, right.second + 1)
    }

    return Pair(root, left.second + 1)
}