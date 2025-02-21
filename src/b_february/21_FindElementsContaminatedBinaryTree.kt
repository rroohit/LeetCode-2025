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

class FindElements(root: TreeNode?) {
    private val nums = HashSet<Int>()

    init {
        if (root != null) {
            root.`val` = 0
            nums.add(0)
            val qu = LinkedList<TreeNode>()
            qu.offer(root)

            while (qu.isNotEmpty()) {
                val size = qu.size
                for (i in 0..<size) {
                    val curr = qu.poll()!!
                    val x = curr.`val`
                    if (curr.left != null) {
                        val newNum = (2 * x) + 1
                        curr.left?.`val` = newNum
                        qu.offer(curr.left)
                        nums.add(newNum)
                    }

                    if (curr.right != null) {
                        val newNum = (2 * x) + 2
                        curr.right?.`val` = newNum
                        qu.offer(curr.right)
                        nums.add(newNum)
                    }
                }
            }
        }
    }

    fun find(target: Int): Boolean {
        return nums.contains(target)
    }

}