package b_february

import z_data_type.TreeNode
import z_data_type.printInorderTree

/**
 *  Problem 23. Construct Binary Tree from Preorder and Postorder Traversal.
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
        Pair(
            intArrayOf(1, 2, 4, 5, 3, 6, 7),
            intArrayOf(4, 5, 2, 6, 7, 3, 1)
        )
    )

    testCases.forEach { test ->
        val root = constructFromPrePost(test.first, test.second)
        println("Result ==> ${printInorderTree(root)}")
    }

}

private var preIndex = 0
private var postIndex = 0
fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode {
    return constructTree(preorder, postorder)
}

private fun constructTree(preorder: IntArray, postorder: IntArray): TreeNode {
    val root = TreeNode(preorder[preIndex++])
    if (root.`val` != postorder[postIndex]) {
        root.left = constructTree(preorder, postorder)
    }

    if (root.`val` != postorder[postIndex]) {
        root.right = constructTree(preorder, postorder)
    }

    postIndex++
    return root
}