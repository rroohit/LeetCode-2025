package b_february

import z_data_type.TreeNode
import z_data_type.createTree
import java.util.*

/**
 *  Problem 21. Find Elements in a Contaminated Binary Tree.
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
            listOf(-1, null, -1),
            listOf(1, 2)
        ),
        Pair(
            listOf(-1, -1, -1, -1, -1),
            listOf(1, 3, 5)
        )
    )

    testCases.forEach { test ->
        val root = createTree(test.first)
        val findElements = FindElements(root)
        test.second.forEach { target ->
            println("Result ==> ${findElements.find(target)}")
        }
    }

}

// DFS
class FindElements(root: TreeNode?) {
    private val nums = HashSet<Int>()

    init {
        dfs(root, 0)
    }

    private fun dfs(curr: TreeNode?, x: Int) {
        if (curr == null) return
        nums.add(x)
        if (curr.left != null) dfs(curr.left, (2 * x) + 1)
        if (curr.right != null) dfs(curr.right, (2 * x) + 2)
    }

    fun find(target: Int): Boolean {
        return nums.contains(target)
    }

}

// BFS
class FindElements1(root: TreeNode?) {
    private val nums = HashSet<Int>()

    init {
        if (root != null) {
            root.`val` = 0
            nums.add(0)
            val qu = LinkedList<TreeNode>()
            qu.offer(root)
            while (qu.isNotEmpty()) {
                val curr = qu.poll()!!
                val x = curr.`val`
                nums.add(x)
                if (curr.left != null) {
                    curr.left?.`val` = (2 * x) + 1
                    qu.offer(curr.left)
                }

                if (curr.right != null) {
                    curr.right?.`val` = (2 * x) + 2
                    qu.offer(curr.right)
                }
            }
        }
    }

    fun find(target: Int): Boolean {
        return nums.contains(target)
    }

}