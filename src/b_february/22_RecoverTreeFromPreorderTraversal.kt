package b_february

import z_data_type.TreeNode
import z_data_type.printInorderTree

/**
 *  Problem 22. Recover a Tree From Preorder Traversal.
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
        "1-2--3--4-5--6--7",
        "1-2--3---4-5--6---7",
        "1-401--349---90--88"
    )

    testCases.forEach { traversal ->
        val result = recoverFromPreorder(traversal)
        printInorderTree(result)
    }

}

private var ind = 0
fun recoverFromPreorder(traversal: String): TreeNode? {
    ind = 0
    return treeConst(traversal, 0)
}
private fun treeConst(str: String, depth: Int): TreeNode? {
    if (ind >= str.length) return null

    var dashCnt = 0
    while (ind + dashCnt < str.length && str[ind + dashCnt] == '-') dashCnt++

    if (dashCnt != depth) return null
    ind += dashCnt

    var num = 0
    while (ind < str.length && str[ind] != '-') {
        num = num * 10 + str[ind++].digitToInt()
    }

    val node = TreeNode(num)
    node.left = treeConst(str, depth + 1)
    node.right = treeConst(str, depth + 1)
    return node
}